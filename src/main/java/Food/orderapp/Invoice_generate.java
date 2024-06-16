package Food.orderapp;

import java.io.IOException;


public class Invoice_generate extends discount_generate{

	public void invoice() throws IOException
	{
		discount_calculation();
		
		if(super.user_hotel!=null && super.isthere==true && super.isitem && super.user_item.length()<=7)
		{
			if(super.user_item.equalsIgnoreCase("Idly")|| super.user_item.equalsIgnoreCase("Vada")|| super.user_item.equalsIgnoreCase("Dosa"))
			{
				//discount_calculation();
		        System.out.println("\nInvoice:\n" + "Hotel: " + user_hotel.toUpperCase());
		        System.out.println("Food Item\t\tPrice");
		        System.out.println("-------------------------------");
		        System.out.println(Food + "*2\t\t\t₹" + Price);
		        System.out.println("\nAmount:\t" +Price+"*"+super.user_quantity+ "\t\t"+amount);
		        System.out.println("Discount rate:(" + ((discount_rate / amount) * 100) + "%)\t" + discount_rate);
		        System.out.println("-------------------------------");
		        System.out.println("Total amount \t\t" + "₹"+Total_price);
		        System.out.println("   Thank you & visit again!!!");
		        return;
			}
			else
			{
			//discount_calculation();
				System.out.println("\nInvoice:\n" + "Hotel: " + user_hotel.toUpperCase());
				System.out.println("Food Item\t\tPrice");
				System.out.println("-------------------------------");
				System.out.println(Food + "\t\t\t₹" + Price);
				System.out.println("\nAmount:\t" +Price+"*"+super.user_quantity+ "\t\t"+amount);
				System.out.println("Discount rate:(" + ((discount_rate / amount) * 100) + "%)\t" + discount_rate);
				System.out.println("-------------------------------");
				System.out.println("Total amount \t\t" + "₹"+Total_price);
				System.out.println("   Thank you & visit again!!!");
				return;
			}
		}
		
		
		if(super.user_hotel!=null && super.isthere==true && super.isitem && (super.user_item.length()>7 && super.user_item.length()<=15 ))
		{
			//discount_calculation();
	        System.out.println("\nInvoice:\n" + "Hotel: " + user_hotel.toUpperCase());
	        System.out.println("Food Item\t\tPrice");
	        System.out.println("-------------------------------");
	        System.out.println(Food + "\t\t₹" + Price);
	        System.out.println("\nAmount:\t" +Price+"*"+super.user_quantity+ "\t\t"+amount);
	        System.out.println("Discount rate:(" + ((discount_rate / amount) * 100) + "%)\t" + discount_rate);
	        System.out.println("-------------------------------");
	        System.out.println("Total amount \t\t" + "₹"+Total_price);
	        System.out.println("   Thank you & visit again!!!");
		}
		if(super.user_hotel!=null && super.isthere==true && super.isitem && super.user_item.length()>15)
		{
			//discount_calculation();
	        System.out.println("\nInvoice:\n" + "Hotel: " + user_hotel.toUpperCase());
	        System.out.println("Food Item\t\tPrice");
	        System.out.println("-------------------------------");
	        System.out.println(Food + "\t₹" + Price);
	        System.out.println("\nAmount:\t" +Price+"*"+super.user_quantity+ "\t\t"+amount);
	        System.out.println("Discount rate:(" + ((discount_rate / amount) * 100) + "%)\t" + discount_rate);
	        System.out.println("-------------------------------");
	        System.out.println("Total amount \t\t" + "₹"+Total_price);
	        System.out.println("   Thank you & visit again!!!");
		}
		   
		
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Invoice_generate ig = new Invoice_generate();
		ig.invoice();
	
	}
}
