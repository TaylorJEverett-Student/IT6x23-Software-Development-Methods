/*
*Student: 21600252 Taylor Everett 
*Date: 27/07/2017
*Version: 0.0001
*/

import java.util.Scanner;

public class Divisible_by_3 {

	public static void main(String[] args) {
		
	    Scanner input = new Scanner( System.in );

	    int number1;
	    
	    System.out.print( "Can be dived by 3?: " );
	    number1 = input.nextInt(); 
	    
	    //loop that will dived by 3 until the answer is 0 and prints it "CAN" if there is a remainder it will print it "CAN'T"
	    if(number1 % 3 == 0)
	    	System.out.printf("%d can be dived by 3", number1);
	    else
	    	System.out.printf("%d can't be dived by 3", number1);
	    
	    input.close();
	}

}
