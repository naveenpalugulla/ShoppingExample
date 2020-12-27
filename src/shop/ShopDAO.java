package shop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class ShopDAO {
	
	public static Connection getConnection()
	{  
	        Connection con=null;  
	        try{  
	        	Class.forName("oracle.jdbc.driver.OracleDriver");  
				con = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@localhost:1521:xe",
	                    "nimsme", "nimsme");
			  if (con != null)
	                System.out.println("Connection established successfully!");
	          else
	                System.out.println("No Connection!");  
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }  
	        return con;  
	        
	 }  
	
	public static int createItem(Item it)
	{
		int status=0;
		try
		{
			Connection con=ShopDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Item(id,name,price) values (?,?,?)");
			ps.setInt(1,it.getId());
			ps.setString(2,it.getName());
			ps.setDouble(3,it.getPrice());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return status;
	}
	public static int createFoodItem(FoodItem it)
	{
		int status=0;
		try
		{
			Connection con=ShopDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into FoodItem(id,name,price,expdate) values (?,?,?,?)");
			ps.setInt(1,it.getId());
			ps.setString(2,it.getName());
			ps.setDouble(3,it.getPrice());
			ps.setString(4,it.getExpiry());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return status;
	}


	public static List<Item> getAllItems(){
		List<Item> list=new Vector<Item>();
		
		try{
			Connection con=ShopDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Item");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Item it=new Item();
				it.setId(rs.getInt(1));
				it.setName(rs.getString(2));
				it.setPrice(rs.getDouble(3));
				
				list.add(it);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
		
}



