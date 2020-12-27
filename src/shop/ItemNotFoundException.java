package shop;


public class ItemNotFoundException extends Exception 
{
ItemNotFoundException()
{
super("Item Does Not Exist Enter Valid ID");
}
}