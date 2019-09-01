/*
*Student: 21600252 Taylor Everett 
*Date: 1/9/2017
*Version: 0.0001
*/
//globally declaring the library form java
import java.util.Scanner;

public class Credit 
{
	//prepares to run application
	public static void main(String[] args)
	{
		//imported scanner set to the word input
		Scanner input = new Scanner(System.in);
		
		//asks user for account details
		System.out.print("Enter Account Number (or 0 to quit): ");
	    int account = input.nextInt();
	    
	    //loop that will keep running until condition is met
	      while (account != 0)
	      {
	         System.out.print("Enter Balance: ");
	         double oldBalance = input.nextDouble(); // balance at start of month

	         System.out.print("Enter Charges: ");
	         double charges = input.nextDouble(); // total of charges made this month

	         System.out.print("Enter Credit paid: ");
	         double credits = input.nextDouble(); // total of credit made this month

	         System.out.print("Enter Credit Limit: ");
	         double creditLimit = input.nextDouble(); // read in credit limit

	         // calculate and display new balance owed
	         double newBalance = oldBalance + charges - credits;
	         System.out.printf("New balance is $%.2f%n", newBalance);

	         // display a warning if the user has exceed the credit limit
	         if (newBalance > creditLimit)
	            System.out.println("Credit limit exceeded");

	         System.out.printf("%nEnter Account Number (or 0 to quit): ");
	         account = input.nextInt(); // read in next account number
	      } 
	      input.close();
	}
}
