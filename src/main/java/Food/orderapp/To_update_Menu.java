package Food.orderapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class To_update_Menu
{

	protected String Filepath =System.getProperty("user.dir")+"\\Excel_files\\Hotels.xlsx";
	Scanner s = new Scanner(System.in);
	
public void additemMenu() throws IOException
	{
		File f = new File(Filepath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		
		System.out.println("Enter your Hotel name:  ");
		String gethotelname = s.nextLine();
		
		
		for(int countsheet=0;countsheet<wbk.getNumberOfSheets();countsheet++)
		{
			Sheet sheet1 = wbk.getSheetAt(countsheet);
			
			if(gethotelname.equalsIgnoreCase(sheet1.getSheetName()))
			{
				System.out.println("Your Current Menu\n==================");
				
				//String out_food = new String() ;
				//double out_price=0;
				
				//Row row1 = sheet1.getRow(0);
				
				for(Row row1:sheet1)
				{
					Cell fooditem= row1.getCell(0);
					Cell price= row1.getCell(1);
				
					if(fooditem.getCellType()==CellType.STRING && fooditem!=null)
					{
						if(price.getCellType()==CellType.NUMERIC && price!=null)
						{
							String get_food = fooditem.getStringCellValue();
							double get_price = price.getNumericCellValue();
					
						System.out.println(get_food+"-"+get_price);
						 
						}
					}
				}
				
				
				boolean added=true;
				while(true)
				{
					String out_food=new String() ;
					double out_price = 0 ;
				System.out.println("\nEnter Item to be add (Ente stop to finish adding):  ");
				String Additem = s.nextLine();
				
				if(Additem.equalsIgnoreCase("Stop"))
				{
					added=false;
					System.out.println("Items Added!!!");
					System.out.println("\nYour Updated menu\n================");
					for(Row row1:sheet1)
					{
						Cell fooditem= row1.getCell(0);
						Cell price= row1.getCell(1);
					
						if(fooditem.getCellType()==CellType.STRING && fooditem!=null)
						{
							if(price.getCellType()==CellType.NUMERIC && price!=null)
							{
								 out_food = fooditem.getStringCellValue();
								 out_price = price.getNumericCellValue();
							 
								System.out.println(out_food+"-"+out_price);
							}
						}
					}
					return;
				}
				
					System.out.println("Enter price: ");
					double addprice=s.nextDouble();
					s.nextLine();
				
					int getlastrow=sheet1.getLastRowNum()+1;
					
					Row row2=sheet1.createRow(getlastrow);
					
					Cell addfood = row2.createCell(0);
					Cell add_price = row2.createCell(1);
					
					
					addfood.setCellValue(Additem);
					add_price.setCellValue(addprice);
					
					fis.close();
					
					FileOutputStream fos = new FileOutputStream(f);
					wbk.write(fos);
			}
		
			}
			else
			{
				System.out.println("Error : Check Given Hotel Name!!!!");
			}

		}
		wbk.close();
		
	}
	
	
public void changeprice() throws IOException
	{	
		File f = new File(Filepath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk1 = new XSSFWorkbook(fis);
		
		System.out.println("Enter your Hotel name:  ");
		String gethotelname = s.nextLine();
		
		String change_food = new String() ;
		double change_price=0;
		
		for(int countsheet=0;countsheet<wbk1.getNumberOfSheets();countsheet++)
		{
			Sheet sheet1 = wbk1.getSheetAt(countsheet);
			
			if(gethotelname.equalsIgnoreCase(sheet1.getSheetName()))
			{
				System.out.println("Your Current Menu\n==================");
				
				
				//Row row1 = sheet1.getRow(0);
				
				for(Row row:sheet1)
				{
					Cell fooditem= row.getCell(0);
					Cell price= row.getCell(1);
				
					if(fooditem.getCellType()==CellType.STRING && fooditem!=null)
					{
						if(price.getCellType()==CellType.NUMERIC && price!=null)
						{
							change_food = fooditem.getStringCellValue();
							change_price = price.getNumericCellValue();
					
						System.out.println(change_food+"-"+change_price);
						 
						}
					}
				}
				//Row row1 = sheet1.getRow(0);
				
				for(Row row1:sheet1)
				{
					Cell fooditem1= row1.getCell(0);
					Cell price1= row1.getCell(1);
				
					if(fooditem1.getCellType()==CellType.STRING && fooditem1 !=null)
					{
						if(price1.getCellType()==CellType.NUMERIC && price1!=null)
						{
							change_food = fooditem1.getStringCellValue();
							change_price = price1.getNumericCellValue();
					
						 boolean tochange=true;
						 while(true)
						 {
							System.out.println("\nEnter Item (Enter end to stop):  ");
							String changefood = s.nextLine();
							
							
							if(changefood.equalsIgnoreCase("end"))
							{
								tochange=false;
								System.out.println("Items Added!!!");
								System.out.println("\nYour Updated menu\n================");
								for(Row row2:sheet1)
								{
									Cell fooditem= row2.getCell(0);
									Cell price= row2.getCell(1);
								
									if(fooditem.getCellType()==CellType.STRING && fooditem!=null)
									{
										if(price.getCellType()==CellType.NUMERIC && price!=null)
										{
											change_food = fooditem.getStringCellValue();
											change_price = price.getNumericCellValue();
											
											System.out.println(change_food+"-"+change_price);
										 
										}
									}
								}
								return;
							}

							if(changefood.equalsIgnoreCase(change_food))
							{
							System.out.println("Enter Price :  ");
							double changeprice= s.nextDouble();
							s.nextLine();
							
							price1.setCellValue(changeprice);
							fis.close();
							FileOutputStream fos1 = new FileOutputStream(f);
							wbk1.write(fos1);
							System.out.println("Your changes: " +changefood+" "+changeprice);
							break;
							}
							
							else
							{
								System.out.println("Please check Items name....");
								return;
							}
						}
						}
					}
				}
			}
			else
			{
				System.out.println("Error : Check Given Hotel Name!!!!");
			}
		}
		wbk1.close();
	}
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		To_update_Menu up_add = new To_update_Menu();
		up_add.additemMenu();
		//up_add.changeprice();
	}


}
