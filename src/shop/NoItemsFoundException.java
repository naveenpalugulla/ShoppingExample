package shop;

public class NoItemsFoundException extends Exception
{
	   NoItemsFoundException()
	   {
	       super(" No Items Present... Items Array is Empty ");
	   }
	}