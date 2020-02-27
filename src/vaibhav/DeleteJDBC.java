package vaibhav;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DeleteJDBC 
{
        Connection con;
        Statement stmt;
        String course,name; int age,roll;
        DeleteJDBC(int Roll)
        {
        	this.roll=Roll;
        	createConnect();	
        }
        void createConnect()
        {
                try{  String query="delete from Student where roll="+roll+"";
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