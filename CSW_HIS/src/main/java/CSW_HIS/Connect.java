package CSW_HIS;

import java.sql.*;
import javax.sql.*;

public class Connect
{
   Connection conn = null;
   private void connection()
   {
       try
       {
           String url = "jdbc:mysql://172.17.0.2:3306/test";
           Class.forName ("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection (url,"root","root");
           System.out.println ("Database connection established");
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }  
   }
   
   public void CloseConn() {
       if(conn != null) {
    	   try
		   {
		       conn.close ();
		       System.out.println ("Database connection terminated");
		   }
		   catch (Exception e) { /* ignore close errors */ }
       }
   }
   
   public void Insert(String request) {
       connection();
       try {
	       PreparedStatement statment = conn.prepareStatement(request);
	       statment.execute();	       
       }
       catch(Exception c) {
    	   System.out.println("Error inserting data");
       };
              
       CloseConn();
   }
   
   public ResultSet GetInfo(String request) {
	   connection();
	   ResultSet stat = null;
       try {
	       PreparedStatement statment = conn.prepareStatement(request);
	       statment.execute();
	       stat = statment.getResultSet();
       }
       catch(Exception c) {
    	   System.out.println("Error inserting data");
       };
       CloseConn();
       return stat;
   }
   
}