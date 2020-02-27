package vaibhav;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ModifyJDBC 
{
        Connection con;
        Statement stmt;
        String name,course; int roll;
        ModifyJDBC(int Roll, String Name, String Course)
        {
        	this.roll=Roll;
        	this.name=Name;
        	this.course=Course;
        	createConnect();	
        }
        void createConnect()
        {
                try{  String query="update Student set name='"+name+"',course='"+course+"' where roll="+roll;
                	  System.out.println(query);
                        Class.forName("oracle.jdbc.driver.OracleDriver");  
                        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle18c","system","password");  
                        stmt=con.createStatement();  
                        stmt.executeUpdate(query);
                        stmt.executeUpdate("commit");
                        //con.close();
                   }
                catch(Exception e){ System.out.println(e+"");} 
        }
}