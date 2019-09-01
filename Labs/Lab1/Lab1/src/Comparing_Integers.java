/*
*Student: 21600252 Taylor Everett 
*Date: 27/07/2017
*Version: 0.0001
*/

import java.util.Scanner;

public class Comparing_Integers{

   public static void main( String[] args )
   {
     
      Scanner input = new Scanner( System.in );

      int number1;
      int number2;

      System.out.print( "Enter first integer: " );
      number1 = input.nextInt();

      System.out.print( "Enter second integer: " ); 
      number2 = input.nextInt();
      // checks to see if numbers are the same
      if ( number1 == number2 ) 
         System.out.printf( "These numbers are equal");
      //checks to see if the second number is larger and prints the number
      if ( number1 < number2 )
         System.out.printf( "%d : is Larger", number2);
    //checks to see if the first number is larger and prints the number
      if ( number1 > number2 )
         System.out.printf( "%d : is Larger", number1);


      input.close();
   }
}