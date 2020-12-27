package shop;

public class Item 
{
   int id;
   String name;
   double price;

   Item()
   {
	
   }

   Item(int id,String name,double price)
   {
	   this.id=id;
	   this.name=name;
	   this.price=price;
   }
   
   void setId(int id)
   {
	   this.id=id;
   }
   int getId()
   {
	   return id;
   }

   void setName(String name)
   {
	   this.name=name;
   }

   String getName()
   {
	   return name;
   }

   void setPrice(double price)
   {
	   this.price=price;
   }	

   double getPrice()
   {
	   return price;
   }
}