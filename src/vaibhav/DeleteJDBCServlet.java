package vaibhav;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteJDBCServlet
 */
@WebServlet("/DeleteJDBCServlet")
public class DeleteJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Connection con;
      Statement stmt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String filter=request.getParameter("filter");
		String query;
		try
		{ 
		if(filter.equals("Name")||filter.equals("Course"))
		{
			String filterValue=request.getParameter("filterValue");
			query="delete from Student where "+filter+"='"+filterValue+"'";
		}
		else
		{
			int filterValue=Integer.parseInt(request.getParameter("filterValue"));
			query="delete from Student where "+filter+"='"+filterValue+"'";
		}
		
  	  	  System.out.println(query);
          Class.forName("oracle.jdbc.driver.OracleDriver");  
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle18c","system","password");  
          stmt=con.createStatement();  
          stmt.executeUpdate(query);
          stmt.executeUpdate("commit");
          //con.close();
	     }
	  catch(Exception e){ System.out.println(e+"");} 
		   response.setContentType("Text/HTML");
	        response.sendRedirect("Login.html");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
