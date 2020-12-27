package shop;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","nimsme","nimsme");

		System.out.println("Connected");
		}
		catch(Exception e)
		{
			
		}

	}

}
