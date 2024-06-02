package Food.orderapp;

import java.io.IOException;

public class discount_generate extends OrderService {
	
	protected double Total_price;
	protected double amount;
	protected double discount_rate;

	public void discount_calculation() throws IOException {
		get_item();
		if (super.isitem == true)
		{
			amount = super.Price * super.user_quantity;

			if (amount <= 300) {
				discount_rate = amount * 0.05;
				Total_price = amount - discount_rate;
			}

			if (amount > 300 && amount <= 500) {
				discount_rate = amount * 0.08;
				Total_price = amount - discount_rate;
			}

			if (amount > 500 && amount <= 1000) {
				discount_rate = amount * 0.11;
				Total_price = amount - discount_rate;
			}

			if (amount > 1000) {
				discount_rate = amount * 0.15;
				Total_price = amount - discount_rate;
			}
		}
	}

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

	}

}
