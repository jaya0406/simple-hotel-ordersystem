package Food.orderapp;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class OrderService extends hotel_Search 
{
	protected boolean isitem=false;
	public void get_item() throws IOException
	{
		search_hotel();
		if(super.isthere==true)
		{
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			try (XSSFWorkbook wbk = new XSSFWorkbook(fis)) {
				for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
				{
					sheet = wbk.getSheetAt(sheetcount);
						 
					if (user_hotel.equalsIgnoreCase(sheet.getSheetName())) 
					{
						System.out.println("Enter Item name: ");
						user_item= s.nextLine();
						
				    for (Row row : sheet)
				    {
				    	Foodcell = row.getCell(0);
				        Pricecell = row.getCell(1);
				                    
				        if (Foodcell != null && Foodcell.getCellType() == CellType.STRING)
				           	{
				            	String Food = Foodcell.getStringCellValue();
				                        
				        if (user_item.equalsIgnoreCase(Food))
				            {
				            	isitem = true;
				            	System.out.println("Enter Quantity: ");
				            	user_quantity= s.nextInt();
				       if (Pricecell != null && Pricecell.getCellType() == CellType.NUMERIC)
				            {
				                Price = Pricecell.getNumericCellValue();
				                this.Food = Food; // Set the correct Food value
				               System.out.println("Your Order - " + user_item.toUpperCase() + " " + "₹"+Price + " - " + user_quantity);
				               System.out.println("Click 'OK' to Generate INVOICE.");
				                break; // Exit the loop once item is found
				            }
				            }
				            }
				    }
				    	 break; // Exit the loop once hotel is found
				     }
				}
			} catch (HeadlessException | NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			return;
		}
		if(!isitem)
		{
			System.out.println("Error: Item not found.");
			return;
		}
	}

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		OrderService os= new OrderService();
		os.get_item();

	}
}
