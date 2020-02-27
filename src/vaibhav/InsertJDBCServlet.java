package vaibhav;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertJDBCServlet
 */
@WebServlet("/InsertJDBCServlet")
public class InsertJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
    public InsertJDBCServlet() throws ClassNotFoundException, SQLException {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int roll=Integer.parseInt(request.getParameter("roll"));
        int age=Integer.parseInt(request.getParameter("age"));
        String name=request.getParameter("fname")+" "+request.getParameter("lname");
        String course=request.getParameter("course");
        response.setContentType("TEXT/HTML");
       // PrintWriter out=response.getWriter();
        try{  
        	 Class.forName("oracle.jdbc.driver.OracleDriver");  
        	 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle18c","system","password");
       	PreparedStatement stmt1;
       	stmt1=con.prepareStatement("insert into student values(?,?,?,?)");
       	stmt1.setString(1, name);
       	stmt1.setInt(2, roll);
       	stmt1.setInt(3,age);
       	stmt1.setString(4, course);
        stmt1.executeUpdate();        
        con.close();
          }
       catch(Exception e){ System.out.println(e+"  vxgxdtg");
           } 	  response.setContentType("Text/HTML");
           response.sendRedirect("index.html");   
	}
}