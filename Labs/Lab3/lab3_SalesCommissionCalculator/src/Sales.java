/*
*Student: 21600252 Taylor Everett 
*Date: 1/9/2017
*Version: 0.0001
*/
//globally declaring the library form java
import java.util.Scanner;
public class Sales 
{

	public static void main(String[] args)
	{		
		//imported scanner set to the word input
		Scanner input = new Scanner(System.in);
		
	    double gross = 0.0; // total gross sales
	    double com; // commission earned
	    int product = 0; // product numbers
	    int sold; // number of products sold
	    
	    //this loop
	    while (product < 4)
	    {
	    	//increases product number until the while condition
	    	++product;

	    	//prints to user the product number and asks for how many sold
	    	System.out.printf("Enter number sold of product #%d: ", product);
	    	sold = input.nextInt();

	    	//gives the price for each product number and mutilpies it by the amount given for sold and adds it to gross
	    	if (product == 1)
	    		gross += sold * 239.99;
	    	else if (product == 2)
	    		gross += sold * 129.75;
	    	else if (product == 3)
	    		gross += sold * 99.95;
	    	else if (product == 4)
	    		gross += sold * 350.89;
	    }
	    
	    // calculate total commission earned
	    com = 0.09 * gross + 200;
	    System.out.printf("Total earnings this week: $%.2f%n", com);
		
	    //closes the input scanner
		input.close();
	}

}
