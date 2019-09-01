/*
*Student: 21600252 Taylor Everett 
*Date: 17/08/2017
*Version: 0.0001
*/

public class Car_Test {
	//prepares to run application
	public static void  main(String[]args)
	{
		//create two constructors for Car class
		Car car1= new Car("Red","1999", 5000.05);
		Car car2= new Car("Blue","2005", 6000.53);
		
		//Prints a form with information on the two cars
		System.out.printf("The %s car from %s is worth: $%.2f%n", car1.getModel(),car1.getYear(),car1.getPrice());
		System.out.printf("The %s car from %s is worth: $%.2f%n", car2.getModel(),car2.getYear(),car2.getPrice());
	}
}
