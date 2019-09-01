/*
*Student: 21600252 Taylor Everett 
*Date: 1/9/2017
*Version: 0.0001
*/
public class Interest {
	public static void main(String[] args)
	{
		int amount; // amount on deposit at end of each year
		int principal = 100000; // initial amount (single cent amount)
		double rate = 0.05; // interest rate

		// show header
		System.out.printf("%s%20s%n", "Year", "Amount on deposit");

		// calculate amount on deposit for each of ten years
		for (int year = 1; year <= 10; year++)
		{
			// calculate new amount for specified year
			amount = (int) (principal * Math.pow(1.0 + rate, year));
	         
			int dollars = amount / 100;
			int cents = amount % 100; 

			// print the year, the dollars portion and a decimal point
			System.out.printf("%4d%,17d.", year, dollars);
	         
			// print the cents portion (with a leading zero if cents < 10)
			System.out.printf("%02d%n", cents);
		} 
	} 
}
