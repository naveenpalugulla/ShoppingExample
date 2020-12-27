package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidate
 */
@WebServlet("/logval")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @return 
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
   {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
		String msg=request.getParameter("msg");
		
		if(msg!=null)
			out.println("<br>"+msg+"<br>");
		out.print("<html><body>");
		out.print("<form action=\"logval\" method=\"post\">");
		
		out.print("UserName <input type=\"text\" name=\"us\" placeholder=\"UserName\"><br>");
		
		out.print("Password <input type=\"password\" name=\"ps\" placeholder=\"password\"><br>");
		
		out.print("<input type=\"submit\" value=\"Login\">");

		out.print("</form>");
		out.print("</body></html");
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  				
		String username=request.getParameter("us");
		String password=request.getParameter("ps");
		
		
		try{  
			/*Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "nimsme", "nimsme");
			
			if (con != null)
                System.out.println("Connection established successfully!");
          else
                System.out.println("No Connection!");
                */
			Connection con=ShopDAO.getConnection();  
			PreparedStatement ps=con.prepareStatement(
					"select * from users where username=? and password=?");
			
			ps.setString(1,username);
			ps.setString(2,password);
			
		    ResultSet rs=ps.executeQuery();
		    		    
		    if(rs.next())
			{
		    	/*response.setContentType("text/html");
				PrintWriter out=response.getWriter();
		    	
				out.println("<html><body><b>");
				out.println("<br> LOGIN SUCCESSFUL <br>");
				out.println("<br> WELCOME TO <br>"+username);
				out.println("</b></body></html>");
				*/
				//response.sendRedirect("view");
		    	 RequestDispatcher rd=request.getRequestDispatcher("viewdata");  
		         rd.forward(request,response);  
				    	
			}
			else
			{
				response.sendRedirect("logval?msg=Entered Invalid Username or Password");
			}
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		
	}

}
