package vaibhav;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("TEXT/HTML");
         PrintWriter out=response.getWriter();
         out.write("<html><body>");
         out.write("<h3 align='center'>My First Servlet Form</h3>");
         out.write("<form method='post'>"
                         + "<center>"
                         + "Value 1:- <input type='number' name='x' value='Enter a Value'/>"
                         + "<br><br>"
                         + "Value 2:-<input type='number' name='y' value='Enter a Value'/>"
                         + "<br><br>"
                         + "Add <input type='radio' name='r1' value='add'/><br><br>"
                         + "Del <input type='radio' name='r1' value='del'/><br><br>"
                         + "Mul <input type='radio' name='r1' value='mul'/>"
                         + "<br><br>"
                         + "<input type='submit' value='Calculate'/>"
                         + "</center>"
                         + "</form>");
         out.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
         int x=Integer.parseInt(request.getParameter("x"));
         int y=Integer.parseInt(request.getParameter("y"));
        // String manu=request.getParameter("r1");
         String manu="add";
         PrintWriter out=response.getWriter();
         out.write("<html><body>");
         if(manu.equalsIgnoreCase("add")) {
                 out.write("<h3 align='center'>"+"The Addition is :-"+(x+y)+"</h3>");
                 }
         else if(manu.equalsIgnoreCase("del")) {
                 out.write("<h3 align='center'>"+"The Substraction is :-"+(x-y)+"</h3>");
                 }
         else
         {
                 out.write("<h3 align='center'>"+"The Multiplication is :-"+(x*y)+"</h3>");
         }
         out.write("</body></html>");
       //  response.setContentType("Text/HTML");
       //  response.sendRedirect("Link is here");
	}

}
