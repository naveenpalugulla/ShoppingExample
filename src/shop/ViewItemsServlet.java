package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewItemsServlet
 */
@WebServlet("/view")
public class ViewItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewItemsServlet() {
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
		out.println("<a href='AddItem.html'>Add New Item</a>");
		out.println("<h1>Items List</h1>");
		
		List<Item> list=ShopDAO.getAllItems();
		
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>Item Id</th><th>Item Name</th><th>Item Price</th><th>Edit</th><th>Delete</th></tr>");
		for(Item it:list){
			out.print("<tr><td>"+it.getId()+"</td><td>"+it.getName()+"</td><td>"+it.getPrice()+"</td><td><a href='EditServlet?id="+it.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+it.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
