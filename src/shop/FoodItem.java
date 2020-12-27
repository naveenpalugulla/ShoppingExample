package shop;


public class FoodItem extends Item 
{
	String expdate;
	
	   
	FoodItem(int id,String name,double price,String expdate)
	{
		super(id,name,price);
	    this.expdate=expdate;
	}
	
	void setExpiry(String expdate)
	{
		this.expdate=expdate;
	}
	   
	String getExpiry()
	{
	    return expdate;
	}

}
