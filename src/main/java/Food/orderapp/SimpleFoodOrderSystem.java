package Food.orderapp;

import java.io.IOException;
import java.util.Scanner;

public class SimpleFoodOrderSystem extends Invoice_generate
{
	Scanner s = new Scanner(System.in);
	public void user_choice() throws IOException
	{
		System.out.println("Enter 1 to Order food.\nEnter 2 to Add your Hotel.\nEnter 3 to Remove your hotel.\nEnter 4 to Update Menu.");
		
		System.out.println("Enter your choice: ");
		int users_option = s.nextInt();
		
		switch(users_option)
		{
			case 1:
			{
				invoice();//to order food - generate invoice.
				break;
			}
			
			case 2:
			{
				HotelManager hm= new HotelManager();// to add new hotel
				hm.Addnew_hotel();//inherit by object
				break;
			}
			
			case 3:
			{
				HotelManager hm= new HotelManager();// to remove hotel
				hm.remove_hotel();//note to remove hotel use LICENSE NUMBER IN owner details excel file
				break;
			}
			
			case 4:
			{
				int updatechoice;
				System.out.println("Enter 1 to Add Items.\nEnter 2 to Change price.\nEnter 3 to Remove Items.");
				updatechoice=s.nextInt();
				
				switch(updatechoice)
				{
					case 1:
					{
						To_update_Menu tam = new To_update_Menu();
						tam.additemMenu();
						break;
					}
					
					case 2:
					{
						To_update_Menu tam = new To_update_Menu();
						tam.changeprice();
						break;
					}
					
					case 3:
					{
						
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		SimpleFoodOrderSystem sos = new SimpleFoodOrderSystem();
		sos.user_choice();
	}

}
