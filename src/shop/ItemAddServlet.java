package shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemAddServlet
 */
@WebServlet("/add")
public class ItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAddServlet() {
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
		
		String sid=request.getParameter("id");
		 int id=Integer.parseInt(sid);  
		String name=request.getParameter("name");
		String sprice=request.getParameter("price");
		double price=Double.parseDouble(sprice);  
				
		Item it=new Item();
		it.setId(id);
		it.setName(name);
		it.setPrice(price);
				
		int status=ShopDAO.createItem(it);
		if(status>0)
		{
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("AddItem.html").include(request, response);
		}
		else
		{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
