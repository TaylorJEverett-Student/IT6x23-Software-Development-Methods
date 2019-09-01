	/*
	*Student: 21600252 Taylor Everett 
	*Date: 17/08/2017
	*Version: 0.0001
	*/
import java.util.Scanner;//allows the use of this library in java

public class Account_Test {
	//prepares to run application
	public static void  main(String[]args)
	{
		//create two constructors for account
		Account account1= new Account("Jane Green", 50.00);
		Account account2= new Account("John Blue", -7.53);
		
		//display the balance for each account
		System.out.printf("%s balance: $%.2f%n", account1.getName(),account1.getBalance());
		System.out.printf("%s balance: $%.2f%n", account2.getName(),account2.getBalance());
		
		//Create a scanner to obtain input in the command window
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter deposit amount for account1: ");
		//declares a new variable
		double depositAmount = input .nextDouble();
		
		//displays that money is being added to the account
		System.out.printf("%nAdding %.2f to account1 balance %n%n", depositAmount);
		//sending the input to Account class
		account1.deposit(depositAmount);
		
		//display balance of account1
		System.out.printf("%s balance: $%.2f%n", account1.getName(),account1.getBalance());
		
		//ask to withdraw
		System.out.print("Enter withdraw amount for account1: ");
		//declares a new variable
		double withdrawAmount = input.nextDouble();
		
		//displays the 
		System.out.printf("%nSubtracting %.2f to account1 balance ", withdrawAmount);
		//sending the input to Account class
		account1.withdraw(withdrawAmount);
		
		System.out.printf("%n%s balance: $%.2f%n%n", account1.getName(),account1.getBalance());
		
		System.out.print("Enter deposit amount for account2: ");
		depositAmount = input.nextDouble();
		
		System.out.printf("%nAdding %.2f to account2 Balance %n%n", depositAmount);
		account2.deposit(depositAmount);
		
		System.out.printf("%s balance: $%.2f%n", account2.getName(),account2.getBalance());
		
		System.out.print("Enter withdraw amount for account2: ");
		withdrawAmount = input.nextDouble();
		
		System.out.printf("%nSubtracting %.2f to account2 balance %n%n", withdrawAmount);
		account2.withdraw(withdrawAmount);
		
		System.out.printf("%n%s balance: $%.2f%n", account2.getName(),account2.getBalance());
		
		input.close();
	}	
}