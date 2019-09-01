	/*
	*Student: 21600252 Taylor Everett 
	*Date: 17/08/2017
	*Version: 0.0001
	*/

public class PetrolPurchase {
	//declare variables
	private String station;//location
	private String petrolType;
	private int pLitre;// current petrol amount
	private double pricePerLitre;
	private double percentDiscount;
	private double total;//cost of petrol amount give by input times price minus discount
	
	//create a constructor call to receive class PetrolPurchase
	public PetrolPurchase  (String station , String petrolType , int pLitre , double pricePerLitre, double percentDiscount, double total)
	{	
		this.station = station;
		this.petrolType = petrolType;
		this.pLitre = pLitre;
		this.pricePerLitre = pricePerLitre;
		this.percentDiscount = percentDiscount;
		this.total = total;
		
	}
	// GETS*********************************************
	public String getStation()
	{
		return station;
	}
	
	public String getType()
	{
		return petrolType;
	}
	
	public int getLitre()
	{
		return pLitre;
	}
	
	public double getPricePerLitre()
	{
		return pricePerLitre;
	}

	public double getPercentDiscount()
	{
		return percentDiscount;
	}	
	
	public double getTotal()
	{
		return total;
	}
	
	//SETS*******************************************
	public void setStation(String station)
	{
		this.station = station;
	}
	
	public void setPetrolType(String petrolType)
	{
		this.petrolType = petrolType;
	}
	
	public void setLitre(int pLitre)
	{
		this.pLitre = pLitre;
	}

	public void setPricePerLitre(double pricePerLitre)
	{
		this.pricePerLitre = pricePerLitre;
	}
	
	public void setPercentDiscount(double percentDiscount)
	{
		this.percentDiscount = percentDiscount;
	}
	
	public void setTotal(double total)
	{
		this.total = total;
	}
	
	//method that calculates to total
	public void getPurchaseAmount(double quantity)
	{
		if(quantity > 0.0)
		total = (quantity * pricePerLitre) - percentDiscount;
	}


}