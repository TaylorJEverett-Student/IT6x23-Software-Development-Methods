	/*
	*Student: 21600252 Taylor Everett 
	*Date: 17/08/2017
	*Version: 0.0001
	*/
import java.util.Scanner;//allows the use of this library in java
public class Petrol_Test {
	//prepares to run application
	public static void  main(String[]args)
	{
		PetrolPurchase car1= new PetrolPurchase("Shell" , "gas" , 1 , 5.00 , .50,0);// preset status of a car
		
		//displays the station, type, liters, price , discount 
		System.out.printf("Closes Station:%s%nType of petrol needed:%s%nHow many Litres are the in tank:%d%nPrice per litre: $%.2f Discount per litre:%.2f%n", car1.getStation(),car1.getType(),car1.getLitre(),car1.getPricePerLitre(),car1.getPercentDiscount());
		//allows input my user to be set to the "input"
		Scanner input = new Scanner(System.in);
		System.out.print("Enter deposit amount of litres wanted: ");//Asking user for an input amount 
		double quantity = input .nextDouble();
		car1.getPurchaseAmount(quantity);// sends input amount to PetrolPurchase class as quantity
		
		//display total
		System.out.printf("You want to buy : $%.2f of %s%n", car1.getTotal(),car1.getType());
		//car1.getPurchaseAmount(quantity);
		
		
		input.close();
	}
	
}
