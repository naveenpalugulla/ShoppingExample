package shop;

import java.util.*;

public class NewShop {

	List<Item> items=new Vector<Item>();
	List<Order> or=new Vector<Order>();
	List<Order> itemord=new Vector<Order>();
	
	int i,n,x,j;
	  
	boolean addItem(Item item) 
	{
		items.add(item);
		return true;
	}
	 
	 
	Item searchItem(int id) throws ItemNotFoundException
	{
	    for(int j=0;j<items.size();j++)
	    {
	    	Item it=items.get(j);
	        if(it.getId()==id)
	        	return it;
	    }
	               
	    throw new ItemNotFoundException();
	}
	 
	void viewItem(Item item)
	{
	      System.out.print(item.getId()+"\t\t"+item.getName()+"\t\t"+item.getPrice());
	      if(item instanceof FoodItem)
	      {
	           FoodItem f=(FoodItem)item;
	           System.out.println("\t\t"+f.getExpiry());
	      }
	       System.out.println();     
	       System.out.println("--------------------------------------------------------");
	           
	}

	List<Item>   getAllItems()   
	{
		return items;
	}        
	 
	boolean addOrderItem(Order item)
	{
	    itemord.add(item);
	    return true;
	}

	boolean addOrder(Order item)
	{
	    or.add(item);
	    return true;
	}
	  

	List<Order>   getAllOrders()
	{
		return or;
	}  

	boolean removeItem(int rid) throws ItemNotFoundException
	{   
	     
	    int index=findIndex(items,rid);
	    if(index!=-1)
	    {
	    	items.remove(items.get(index));
	        return true;
	    }
	    else 
	        throw new ItemNotFoundException();   
	}

    int  findIndex (List<Item> ary, int t) 
	{
	    if (ary == null) 
	    	return -1;
	    for(int y=0;y<items.size();y++)
	    {
	        Item it=items.get(y);
	        if(it.getId()==t)
	        	return y;
	    }
	        
	        return -1;
	 }
	 
	 boolean removeAllItems() throws NoItemsFoundException
	 {
	     if(items.size() !=0 )
	     {  
	         items.clear();
	         return true;
	     }
	     else
	        throw new NoItemsFoundException();
	 }

	 void show()
	 {
	       System.out.println("-----------------------------------------------------------------------");
	       System.out.println("Item Id "+"\t"+"Item Name "+"\t"+"Item Price"+"\t"+"Item Expiry");
	       System.out.println("-----------------------------------------------------------------------");
	 }
	 void show1()
	 {
	       System.out.println("-----------------------------------");
	       System.out.println("Order Id "+"\t"+"Total");
	       System.out.println("-----------------------------------");
	 }

}
