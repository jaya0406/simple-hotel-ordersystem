package Food.orderapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class hotel_Search extends Thread {
	
	Scanner s = new Scanner(System.in);
	protected String filepath=System.getProperty("user.dir")+"\\Excel_files\\Hotels.xlsx"; String user_hotel= new String();
	protected boolean isthere = false;
	protected String Food;
	protected double Price;
	protected String user_item=new String();
	protected int user_quantity;
	Cell Foodcell;
	Cell Pricecell;
	Sheet sheet ;
	
	public void search_hotel() throws IOException
	{
		System.out.println("ORDER YOUR FOOD HERE");
		
		System.out.println("Available Hotels: ");
		//Available hotels Thalapakatti,Buddha hut,Taj,Copper Kitchen,A2B
		
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		
		for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
		{
			
			String Sheetname =wbk.getSheetName(sheetcount);
			System.out.println(sheetcount+1+"."+Sheetname);
		}//to display hotel name
		 System.out.println("Enter Hotel name: ");
		 user_hotel=s.nextLine();
		
		for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
		{
			 sheet = wbk.getSheetAt(sheetcount);
			if(user_hotel.equalsIgnoreCase(sheet.getSheetName()))
			{
				isthere = true;
				System.out.println("Welcome to Hotel "+ user_hotel.toUpperCase()+" !!");
				System.out.println("Menu:\n-----");
				
		for(Row row : sheet)
			{
				 Foodcell = row.getCell(0);
				 Pricecell = row.getCell(1);
					
				 if(Foodcell!= null && Foodcell.getCellType()==CellType.STRING)
					{
					 if(Pricecell!=null && Pricecell.getCellType()==CellType.NUMERIC)
						{
							String Food=Foodcell.getStringCellValue();
							double Price=Pricecell.getNumericCellValue();
							System.out.println(Food+" - ₹"+Price);
						}
					}
				}
				break;
			}
			wbk.close();
		}
		
		if(!isthere)
		{
			 System.out.println("Error: Hotel name not found.");
			return;
		}
		
	}
	
	public void run()
	{
		// TODO Auto-generated method stub
		try {
			search_hotel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		hotel_Search t = new hotel_Search();
		t.start();
	}
}
