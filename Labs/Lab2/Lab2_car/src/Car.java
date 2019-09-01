/*
*Student: 21600252 Taylor Everett 
*Date: 17/08/2017
*Version: 0.0001
*/
public class Car
	{
	//declare variables
	private String model;
	private String year;
	private double price;
	// set up a constructor 
	public Car (String model , String year, double price)
	{	
		this.model = model;
		this.year = year;	
		this.price = price;
	}
	//sets the cars price
	public void setPrice (double price)
	{
		this.price = price;
	}
	
	//gets the returns of the cars price
	public double getPrice()
	{
		return price;
	}
	//sets the cars model
	public void setModel (String model)
	{
		this.model = model;
	}
	//gets the returns of the cars model
	public String getModel()
	{
		return model;
	}
	//sets the cars year
	public void setYear (String year)
	{
		this.year = year;
	}
	//gets the returns of the cars year
	public String getYear()
	{
		return year;
	}
}
