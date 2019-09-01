/*
*Student: 21600252 Taylor Everett 
*Date: 27/07/2017
*Version: 0.0001
*/

import java.util.Scanner;

public class Largest_and_Smallest_Integers {

   public static void main( String[] args )
   {
     
      Scanner input = new Scanner( System.in );

      int number1;
      int number2;
      int number3;
      int number4;
      int number5;

      System.out.print( "Enter First integer: " );
      number1 = input.nextInt();

      System.out.print( "Enter Second integer: " ); 
      number2 = input.nextInt();
      
      System.out.print( "Enter Third integer: " ); 
      number3 = input.nextInt();

      System.out.print( "Enter Forth integer: " ); 
      number4 = input.nextInt();
           
      System.out.print( "Enter Fifth integer: " ); 
      number5 = input.nextInt();
      
      //checks and compares all possible number combinations for the largest number then prints once found  
		if ( number1 > number2 && number1 > number3 && number1 > number4 && number1 > number5)
			System.out.printf( "Larger integer: %d\n", number1);
		else if ( number2 > number1 && number2 > number3 && number2 > number4 && number2 > number5)
			System.out.printf( "Larger integer: %d\n", number2);
		else if ( number3 > number1 && number3 > number2 && number3 > number4 && number3 > number5)
			System.out.printf( "Larger integer: %d\n", number3);
		else if ( number4 > number1 && number4 > number2 && number4 > number3 && number4 > number5)
			System.out.printf( "Larger integer: %d\n", number4);
		else if ( number5 > number1 && number5 > number2 && number5 > number3 && number5 > number4)
			System.out.printf( "Larger integer: %d\n", number5);
		//checks and compares all possible number combinations for the smallest number then prints once found  
		if ( number1 < number2 && number1 < number3 && number1 < number4 && number1 < number5)
			System.out.printf( "Smaller integer: %d\n", number1);
		else if ( number2 < number1 && number2 < number3 && number2 < number4 && number2 < number5)
			System.out.printf( "Smaller integer: %d\n", number2);
		else if ( number3 < number1 && number3 < number2 && number3 < number4 && number3 < number5)
			System.out.printf( "Smaller integer: %d\n", number3);
		else if ( number4 < number1 && number4 < number2 && number4 < number3 && number4 < number5)
			System.out.printf( "Smaller integer: %d\n", number4);
		else if ( number5 < number1 && number5 < number2 && number5 < number3 && number5 < number4)
			System.out.printf( "Smaller integer: %d\n", number5);
		
      input.close();
   }
}