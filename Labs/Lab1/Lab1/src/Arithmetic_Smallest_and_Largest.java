	import java.util.Scanner;

	/*
	*Student: 21600252 Taylor Everett 
	*Date: 26/07/2017
	*Version: 0.0001
	*/

	public class Arithmetic_Smallest_and_Largest {

		public static void main(String [] arga){
		
				Scanner input = new Scanner (System.in);
				
				int number1;
				int number2;
				int number3;
				
				int sum;
				int average;
				int product;
				
				System.out.print("Enter First Number: ");
				number1 = input.nextInt();
				
				System.out.print("Enter Second Number: ");
				number2 = input.nextInt();
				
				System.out.print("Enter Third Number: ");
				number3 = input.nextInt();
			    //adds the numbers together
				sum = number1 + number2 + number3;
				
				//makes an average by dividing the sum by how many numbers being asked
				average = sum /3;
				
				//multiples the 3 numbers inputed
				product = number1 * number2 * number3;
				
				//Prints out what was added, averaged, and multiplied in that order
				System.out.printf("Your Sum: %d\n", sum);
				System.out.printf("Average: %d\n", average);
				System.out.printf("Product: %d\n", product);

				//Checks and compares all numbers for the largest number then prints 
				if ( number1 > number2 && number1 > number3)
					System.out.printf( "Larger integer: %d\n", number1);
				else if ( number2 > number1 && number2 > number3)
					System.out.printf( "Larger integer: %d\n", number2);
				else if ( number3 > number1 && number3 > number2)
					System.out.printf( "Larger integer: %d\n", number3);
				
				//Checks and compares all numbers for the smallest number then prints 
				if ( number1 < number2 && number1 < number3)
					System.out.printf( "Smaller integer: %d\n", number1);
				else if ( number2 < number1 && number2 < number3)
					System.out.printf( "Smaller integer: %d\n", number2);
				else if ( number3 < number1 && number3 < number2)
					System.out.printf( "Smaller integer: %d\n", number3);
		
				input.close();
		
		}
	}