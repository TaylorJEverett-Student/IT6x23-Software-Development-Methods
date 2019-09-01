/*
*Student: 21600252 Taylor Everett 
*Date: 1/9/2017
*Version: 0.0001
*/
package lab3_GasMileage;
//globally declaring the library form java
import java.util.Scanner;
public class GasMPG 
{
	//gets program ready to run
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//setting imported scanner to the word input
		Scanner input = new Scanner(System.in);
		
		//declaring variables
		int tripMiles=0;
		int tripGallons=0;
		
		//asks for the miles traveled
		System.out.print("How many miles traveled (0 to quit): ");
		//takes the integer into input scanner
		int miles =input.nextInt();
		
		//loop that has a condition to exit if value is zero 
		while(miles != 0)
		{
			//asks for the gallons used
			System.out.print("How many gallons used: ");
			//takes the integer into input scanner
			int gallons =input.nextInt();
			
			//adding miles and gallons to the tank
			tripMiles += miles;
			tripGallons += gallons;
			
			//calculates the MPG in the trip
			if(gallons != 0)
			{
				double milesPerGallon = (double) miles / gallons;
	            System.out.printf("MPG this tank is: %.2f%n", milesPerGallon);
			}
			//calculates the average MPG with all the trips inputed
			if(tripGallons != 0)
			{
				double totalMilesPerGallon = (double) tripMiles / tripGallons;
	            System.out.printf("Total MPG: %.2f%n", totalMilesPerGallon);
			}
			//starts the input for the next trip
			System.out.print("How many miles traveled(0 to quit): ");
	        miles = input.nextInt();
	           
		}
		input.close();
	}

}
