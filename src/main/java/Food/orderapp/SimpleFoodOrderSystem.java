package Food.orderapp;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SimpleFoodOrderSystem extends Invoice_generate
{
	Scanner s = new Scanner(System.in);
	public void user_choice() throws IOException
	{
		System.out.println("Enter 1 to Order food.\nEnter 2 to Add your Hotel.\nEnter 3 to Remove your hotel.");
		
		int users_option = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice: "));
		
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
			}
			
			case 3:
			{
				HotelManager hm= new HotelManager();// to remove hotel
				hm.remove_hotel();//note to remove hotel use LICENSE NUMBER IN owner details excel file
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
