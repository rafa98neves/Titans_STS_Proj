package CSW_HIS;

import java.sql.*;
import java.util.ArrayList;

public class Connect
{
   Connection conn = null;
   private void connection()
   {
       try
       {
           String url = "jdbc:mysql://192.168.0.247:3306/InternshipDB";
           Class.forName ("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection (url,"remoteuser","password");
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
   
   public ArrayList<User> GetInfo(String request) {
	   connection();
	   ResultSet stat = null;
	   ArrayList<User> information = new ArrayList<User>();
       try {
    	   Statement statment = conn.createStatement();
    	   stat = statment.executeQuery(request);
	       while(stat.next()) {
	    	   User novo = new User(stat.getInt("id"),stat.getString("name"), stat.getInt("age"),stat.getString("address"));
	    	   information.add(novo);
	       }
       }
       catch(Exception c) {
    	   System.out.println("Error getting data");
       };
       CloseConn();
       return information;
   }
   
}