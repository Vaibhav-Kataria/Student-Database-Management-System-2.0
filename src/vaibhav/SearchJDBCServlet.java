package vaibhav;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchJDBCServlet
 */
@WebServlet("/SearchJDBCServlet")
public class SearchJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
       Statement stmt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchJDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			int roll=Integer.parseInt(request.getParameter("search"));
		  	PrintWriter out = response.getWriter();
			out.write("<html><body>");
			out.write("<table border='2'><caption>Search Results</caption><tr><th>NAME</th><th>ROLL</th><th>AGE</th><th>COURSE</th></tr>");
			try { // Class.forName("oracle.jdbc.driver.oracledriver");
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle18c", "system", "password");
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from student where roll="+roll);//roll from line 38
				while (rs.next()) 
				{
					out.write("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getInt(2) + "</td><td>" + rs.getInt(3)
							+ "</td><td>" + rs.getString(4) + "</td></tr>");
				}
				con.close();
			} catch (Exception e) { // System.out.println(e);
				e.printStackTrace();
			}
			response.getWriter().write("</table><a href='index.html'><input  type='button' class='button' value='Go Home'/></a></body></html>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
