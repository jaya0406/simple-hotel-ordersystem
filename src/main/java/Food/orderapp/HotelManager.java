package Food.orderapp;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
public class HotelManager
{
	
	protected String filepath=System.getProperty("user.dir")+"\\Excel_files\\Hotels_menu.xlsx";
	protected String Owners_details=System.getProperty("user.dir")+"\\Excel_files\\ownerdetails.xlsx";
	protected List<String> newHotels= new ArrayList<String>();
	protected String new_Hotelname;
	protected String add_branch;
	protected String gethotel_name;
	protected String getLicense_no;
	protected String Item_name;
	protected double add_price;
	protected String user_choice;
	
	boolean ishotel=false;
	boolean isitem=false;
	boolean isreg=false;
	boolean isremoved=false;	
	
	
	Scanner s = new Scanner(System.in);

	private void NewHotel_menu() throws IOException//to add menu of newly created hotel
	{
		if(isreg==true)
			{
				System.out.println("Re-enter hotel name to add menu(Enter stop to end menu) : ");
				gethotel_name = s.nextLine();
				
				File f = new File(filepath);
				FileInputStream fis = new FileInputStream(f);
				//FileOutputStream foi = new FileOutputStream(f);
				XSSFWorkbook wbk = new XSSFWorkbook(fis);
					
				Sheet sheet =  wbk.getSheet(gethotel_name);
					
					if(sheet==null)
					{
						System.out.println("Hotel name not found.");
						return;
					}
						
						boolean isadd =true;
						
						while(true)
						{
							 System.out.println("Enter Item_name: ");
							 Item_name = s.nextLine();
							 
							if(Item_name.equalsIgnoreCase("Stop"))
							{
								System.out.println("Items added.");
								
								File f1 = new File(filepath);
								FileInputStream fis1 = new FileInputStream(f);
								
								XSSFWorkbook wbk1 = new XSSFWorkbook(fis1);
								
								System.out.println("Your menu\n=========");
								
								for(int sheetcount = 0 ;sheetcount<wbk1.getNumberOfSheets();sheetcount++)
								{
									 sheet = wbk1.getSheetAt(sheetcount);
									if(gethotel_name.equalsIgnoreCase(sheet.getSheetName()))
									{
										
										for(Row row : sheet)
										{	
											Cell Foodcell;
											Cell Pricecell;
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
										return;
									}
									wbk1.close();
								}
								
							}
						
							System.out.println("Enter Item's price: ");
							add_price = s.nextDouble();
							s.nextLine();
							
							int rowcount = sheet.getLastRowNum()+1;
							
							Row row = sheet.createRow(rowcount);
						
							Cell foodcell = row.createCell(0);
							Cell pricecell = row.createCell(1);
							
												
							foodcell.setCellValue(Item_name);
							pricecell.setCellValue(add_price);
							isadd =true;
							fis.close();
							
							FileOutputStream foi = new FileOutputStream(f);
							wbk.write(foi);
						}
				}
					
			
			
	}

	public void Addnew_hotel() throws IOException//to add hotel
	{
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		try (//FileOutputStream foi = new FileOutputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis)) {
			//System.out.println("Enter hotel name: ");
			System.out.println("Enter hotel name: ");
			new_Hotelname= s.nextLine();
			
			 for (int sheet_count = 0; sheet_count < wbk.getNumberOfSheets(); sheet_count++)
			 {
			   Sheet sheet = wbk.getSheetAt(sheet_count);
			
			   if(new_Hotelname.equalsIgnoreCase(sheet.getSheetName()))
			   {
				   ishotel=true;
				   System.out.println("Given hotel name is already exist.");//get branch details etc
				   return;
			   }
			 }
			  if(!ishotel)
				   if(!ishotel)
				   {
					   
					   System.out.println("Would you like to add your hotel in our site!!!");
					   user_choice = s.nextLine();
					   
					   if(user_choice.equalsIgnoreCase("yes")||user_choice.equalsIgnoreCase("s"))
					   {
						   	  fis.close();
						   
							  FileOutputStream foi = new FileOutputStream(f);  
							  Sheet createSheet = wbk.createSheet(new_Hotelname); 
							  
							  	Row headerRow = createSheet.createRow(0);
						        Cell foodCell = headerRow.createCell(0);
						        Cell priceCell = headerRow.createCell(1);

						        foodCell.setCellValue("Food Items");
						        priceCell.setCellValue("Price");

						        Font boldFont = wbk.createFont();
						        boldFont.setBold(true);
						        CellStyle boldStyle = wbk.createCellStyle();
						        boldStyle.setFont(boldFont);

						        foodCell.setCellStyle(boldStyle);
						        priceCell.setCellStyle(boldStyle);
						        
						        wbk.write(foi); 
						        isreg=true;
						        System.out.println("Hotel Successfully Registered.");
						        NewHotel_menu();
						        foi.close();
					   }
					     
				   }
			fis.close();
			wbk.close();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		if(user_choice.equalsIgnoreCase("No"))
		   {
			   System.out.println("Thank you!!!");
			   return;
		   }
		   
	}
	
	public void remove_hotel() throws IOException
	{
		boolean removehotel=false;
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		//FileOutputStream foi = new FileOutputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		
		for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
		{
			String Sheetname =wbk.getSheetName(sheetcount);
			System.out.println(sheetcount+1+"."+Sheetname);
		}
		
		System.out.println("Enter hotel name to remove: ");
		gethotel_name= s.nextLine();
		
		 for (int sheet_count = 0; sheet_count < wbk.getNumberOfSheets(); sheet_count++)
		 {
		   Sheet sheet = wbk.getSheetAt(sheet_count);
		
		   if(gethotel_name.equalsIgnoreCase(sheet.getSheetName()))
		   {
			   			wbk.removeSheetAt(sheet_count); 
						removehotel=true;
						break;
			}
					
		  }

		 if(removehotel)
		 {	
			 System.out.println("Enter LICENSE Number: ");
			 getLicense_no = s.nextLine();
			 
			 File f1 = new File(Owners_details);
			 FileInputStream fis1= new FileInputStream(f1);
			 XSSFWorkbook wbk1 = new XSSFWorkbook(fis1);
			 
			 for(int sheetcount = 0 ; sheetcount<wbk1.getNumberOfSheets() ; sheetcount++)
			 {
				 Sheet sheet1 = wbk1.getSheetAt(sheetcount);
				 
				 if(gethotel_name.equalsIgnoreCase(sheet1.getSheetName()))
				 {
					 int totalRows= sheet1.getPhysicalNumberOfRows();
					
					for(int i=0;i<=totalRows;i++)
					{
						 Row row = sheet1.getRow(i);
						Cell ownerdet_values = row.getCell(1);
						if(ownerdet_values!= null && ownerdet_values.getCellType()==CellType.STRING)
						{
							String getcellvalue = ownerdet_values.getStringCellValue();
							
							if(getcellvalue.equals(getLicense_no))
							{

								 FileOutputStream fos = new FileOutputStream(f);		
								 wbk.write(fos);
								 fos.close();
								 System.out.println("Hotel removed Succesfully.");
								 isremoved=true;
								 break;
							}
						}
						
					}
				}
				
				 if(isremoved)
				 {
					 FileOutputStream fos1 = new FileOutputStream(f1); 
					 wbk1.removeSheetAt(sheetcount);
					 wbk1.write(fos1);
					 fos1.close();
					 System.out.println("Owner details succesfully removed...");
					 return;
					 
				 }

			 }
		
			 fis1.close();
			 wbk1.close();
		 }
			fis.close();
			wbk.close();
			
			if(!removehotel)
			{
				System.out.println("Hotel name not found...");
				return;
			}
			
			if(!isremoved)
			{
				System.out.println("Hotel is not removed or wrong License number....");
				return;
			}
	}

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		HotelManager hm = new HotelManager();
		hm.Addnew_hotel();
		//ham.NewHotel_menu();
		//hm.remove_hotel();

	}

}
