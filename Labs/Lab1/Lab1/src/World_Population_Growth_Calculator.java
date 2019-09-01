import java.util.Scanner;

/*
*Student: 21600252 Taylor Everett 
*Date: 27/07/2017
*Version: 0.0001
*/
public class World_Population_Growth_Calculator {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		
		double year1;
		double year2;
		double year3;
		double year4;
		double year5;
		double rate1;
		double rate2;
		double rate3;
		double rate4;
		double totalrate;
		double total;
		
		/*7,097,500,453
		7,181,715,139
		7,265,785,946
		7,349,472,099
		7,432,663,275
		*/
		//asks the user to input the population number
		System.out.print("Enter First year population: ");
		year1 = input.nextDouble();
		
		System.out.print("Enter Second year population: ");
		year2 = input.nextDouble();
		
		System.out.print("Enter Third year population: ");
		year3 = input.nextDouble();
		
		System.out.print("Enter Forth year population: ");
		year4 = input.nextDouble();
		
		System.out.print("Enter Fifth year population: ");
		year5 = input.nextDouble();
		
		//finds the differences between original and next number for 5 sets 
		rate1 = year2 - year1;
		rate2 = year3 - year2;
		rate3 = year4 - year3;
		rate4 = year5 - year4;
		//finds the average of the differences
		totalrate = (rate1 + rate2 + rate3 + rate4) /4;
		//takes the last number and adds the averaged differences
		total = year5 + totalrate;
		
		
		System.out.printf("Sixth year Estimated population: %.2f%n", total);

		
		input.close();

	}

}
