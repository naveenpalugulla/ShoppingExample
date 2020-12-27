package shop;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewDataServlet
 */
@WebServlet("/viewdata")
public class ViewDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    
		
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        String username=request.getParameter("us");  
	                  
		      
		    	out.println("<html><body>");
				out.println("<br> LOGIN SUCCESSFUL <br>");
				out.println("<br> WELCOME TO <br>"+username);
				out.println("</body></html>");
				
				
				
				          
   }

}
