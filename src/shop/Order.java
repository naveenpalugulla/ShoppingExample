package shop;

public class Order extends Item
{
	
	int oid;
    int qnt;
    double tot;
     
    Order()
    {
    	
    }
    
    Order(int oid,double tot)
    {
    	this.oid=oid;
    	this.tot=tot;
    }
    
    Order(int id,String name,double price)
    {
    	super(id,name,price);
    }
    Order(int id,String name,double price,int qnt,double tot)
    {
    	super(id,name,price);
    	this.qnt=qnt;
    	this.tot=tot;
    }
    
    int getQuantity()
    {
    	return qnt;
    }
        
    int getCount()
    {
    	return oid;
    }
    double getTotal()
    {
    	return tot;
    }
}
