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

public class Match_license 
{

	protected String filepath="C:\\Users\\SIVAGAMI\\eclipse-workspace\\orderapp\\Excel_files\\Hotels_menu.xlsx";
	protected String Owners_details="C:\\Users\\SIVAGAMI\\eclipse-workspace\\Class_code_practice\\sample\\ownerdetails.xlsx";
	protected String user_choice;
	protected String gethotel_name;
	protected String getLicense_no;
	protected boolean ishotel=false;
	protected boolean ismatch=false;
	Scanner s = new Scanner(System.in);
	
	private boolean matchlicence_no() throws IOException
	{
		
		File f = new File(Owners_details);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);

		System.out.println("Would you like to update menu!!!");
		user_choice=s.nextLine();
		if(user_choice.equalsIgnoreCase("YES")||user_choice.equalsIgnoreCase("s"))
		{
		for(int sheetcount = 0; sheetcount <wbk.getNumberOfSheets(); sheetcount++)
		{
			Sheet sheet=wbk.getSheetAt(sheetcount);
			
			System.out.println("Enter Hotel Name: ");
			gethotel_name=s.nextLine();
			
			System.out.println("Enter Shop LICENSE Number(i.e-AB00TN0000): ");
			getLicense_no = s.nextLine();
			
			if(gethotel_name.equalsIgnoreCase(sheet.getSheetName()))
			{
				ishotel=true;
				for(Row row : sheet)
				{
					Cell key = row.getCell(0);
					Cell value = row.getCell(1);
					
					if(key.getCellType()==CellType.STRING)
					{
						String Key=key.getStringCellValue();
						
						if(value.getCellType()==CellType.STRING)
						{
							String Value = value.getStringCellValue();
							
							if(getLicense_no.equals(Value))
							{
								ismatch = true;
								System.out.println("Done");
							}
							else
							{
								System.out.println("Error: Wrong LICENSE NUMBER.");
								//return;
								ismatch = false;
							}
									
						}
					}
				}
			}
			break;
		}
		
		}
		
		fis.close();
		wbk.close();
		
		
		/*if(!ismatch)
		{
			System.out.println("Error: Wrong LICENSE NUMBER.");
		}*/
	
	return ismatch;
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Match_license ml = new Match_license();
		ml.matchlicence_no();

	}

}
