package vaibhav;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputJDBCServlet
 */
@WebServlet("/OutputJDBCServlet")
public class OutputJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement stmt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OutputJDBCServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<html><head><style>\r\n" + 
				"table {\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"th, td {\r\n" + 
				"  text-align: left;\r\n" + 
				"  padding: 8px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr:nth-child(even){background-color: #AAAAAA}\r\n" + 
				"\r\n" + 
				"tr:nth-child(odd){background-color: #BFBFBF}\r\n" + 
				"\r\n" + 
				"th {\r\n" + 
				"  background-color: #4CAF50;\r\n" + 
				"  color: white;\r\n" + 
				"}\r\n" + 
				"</style></head><body bgcolor='black'>");
		out.write("<div ><center>");
		out.write("<table style='color:white; background:grey';><b><caption>Student Database</caption></b><tr><th>NAME</th><th>ROLL</th><th>AGE</th><th>COURSE</th></tr>");
		try { // Class.forName("oracle.jdbc.driver.oracledriver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle18c", "system", "password");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student order by roll ASC");

			while (rs.next()) {
				out.write("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getInt(2) + "</td><td>" + rs.getInt(3)
						+ "</td><td>" + rs.getString(4) + "</td></tr>");
			}
			con.close();
		} catch (Exception e) { // System.out.println(e);
			e.printStackTrace();

		}
		response.getWriter().write("</table><a href='index.html'><input  type='button' class='button' value='Go Home'/></a>");
		out.write("</center></div></body></html>");

	}
}