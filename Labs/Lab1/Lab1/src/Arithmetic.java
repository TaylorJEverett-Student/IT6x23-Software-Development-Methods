import java.util.Scanner;

/*
*Student: 21600252 Taylor Everett 
*Date: 27/07/2017
*Version: 0.0001
*/

public class  Arithmetic{

	public static void main(String [] arga){
	
			Scanner input = new Scanner (System.in);
			
			double number1;
			double number2;
			double sum1;
			double sum2;
			
			System.out.print("Enter first Number: ");
			number1 = input.nextInt();
			
			System.out.print("Enter Second Number: ");
			number2 = input.nextInt();

			//Subtracts the 2 numbers and stores in sum1
			sum1 = number1 - number2;
			//Divides the 2 numbers  and stores in sum2 
			sum2 = number1 / number2;
			//prints difference with sum1
			System.out.printf("Difference is: %f\n", sum1);
			//prints divided with sum2
			System.out.printf("Divided: %f\n", sum2);
			
			input.close();
	
	}
}
