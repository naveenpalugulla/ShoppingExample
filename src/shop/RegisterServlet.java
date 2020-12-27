package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/regval")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
       response.setContentType("text/html");
 	   PrintWriter out=response.getWriter();
 		String msg=request.getParameter("msg");
 		
 		if(msg!=null)
 			out.println("<br>"+msg+"<br>");
 		
 		out.print("<html><body>");
 		out.print("<form action=\"regval\" method=\"post\">");

 		out.print("User Name <input type=\"text\" name=\"us\" value=" +request.getParameter("us") +" > <br>");
 		out.print("Email Id <input type=\"email\" name=\"email\" ><br>");
 		out.print("Mobile Number <input type=\"text\" name=\"mobile\"><br>");
 		out.print("Address <input type=\"text\" name=\"address\"><br>");

 		out.print("Password <input type=\"password\" name=\"ps\" ><br>");

 		out.print("<input type=\"submit\" value=\"Register\">");
 		out.print("<input type=\"reset\"  value=\"Reset\">");


 		out.print("</form>");
 		out.print("</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String username=request.getParameter("us");
		String password=request.getParameter("ps");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		
		if(username!=null && username.length()>5 && password!=null && email!=null && mobile!=null && address!=null )
		{	
			
		try
		{  
			Connection con=ShopDAO.getConnection();  
			PreparedStatement ps=con.prepareStatement(
					"insert into users values(?,?,?,?,?)");
			
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,mobile);
			ps.setString(5,address);
				
			
			int n=ps.executeUpdate();
		    
			if(n>0)
			{
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html><body><b>");
				out.println("<br> REGISTRATION SUCCESSFUL<br>");
				out.println("<br> WELCOME TO<br> "+username);
				
				
				out.println("</b></body></html>");
				
			}
		    else
			{
		    	//response.sendRedirect("regval?msg=Fields are not entered");
		    	doGet(request,response);
		    	
		    	
			}
			
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
			//response.sendRedirect("regval?msg=Fields are not entered");
			doGet(request,response);
		}
		}
		else
		{
			doGet(request,response);
		}
			//response.sendRedirect("regval?msg=Fields are not entered");
	}

}
