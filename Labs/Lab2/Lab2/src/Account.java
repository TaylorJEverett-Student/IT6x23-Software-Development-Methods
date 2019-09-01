	/*
	*Student: 21600252 Taylor Everett 
	*Date: 17/08/2017
	*Version: 0.0001
	*/
public class Account {
	//declare variables
	private String name;
	private double balance;
	
	//create a constructor calls to receive class Account
	public Account (String name , double balance)
	{	
	//assign the name to the string variable
		this.name = name;
		
	//assign the value to the double
		this.balance = balance;	
	}
	
	//the method in the account is add to the overall balance
	public void deposit (double depositAmount)
	{
		if(depositAmount > 0.0)
			balance = balance + depositAmount;
	}
	
	//the method in the account is to stop overdraft
	public void withdraw (double withdrawAmount)
	{
		if(withdrawAmount < balance)
			balance = balance - withdrawAmount;
		else
			System.out.print("Withdrawal amount exceeded account balance");
	}
	
	//get the return account balance
	public double getBalance()
	{
		return balance;
	}
	
	//sets account name
	public void setName (String name)
	{
		this.name = name;
	}
	
	//gets the return account name
	public String getName()
	{
		return name;
	}
	
}