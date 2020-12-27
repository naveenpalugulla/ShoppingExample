package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html> <body> <b>");
		
		//out.print(new Date());
		
		 //Date d=new Date();
		// out.print(d);
		 //int hour=d.getHours();
		Calendar c=Calendar.getInstance();
		Date d=c.getTime();
		 out.print(d);
		int hour=c.get(Calendar.HOUR_OF_DAY);
		
		 
		 if(hour<12)
			 out.println("Good Morning");
		 else 
			 if(hour<16)
				 out.println("Good Afternoon");
		 else
			 out.println("Good Evening");
		 
		 out.println("</b> </body></html>");
	
	}

	

}
