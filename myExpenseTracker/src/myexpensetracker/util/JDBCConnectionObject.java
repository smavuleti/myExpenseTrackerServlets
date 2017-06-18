package myexpensetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionObject {
	
	public Connection con;

	final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    final String DB_URL="jdbc:mysql://localhost/expense_tracker";
	
//  Database credentials
      final String USER = "expense_user";
      final String PASS = "expensetracker";

      public JDBCConnectionObject() {
    	  con = null;
      }
      
      public Connection getDB() {
    	  if(con!=null) {
    		  return con;
    	  }
    	  else {
    		  try {
        		  Class.forName("com.mysql.jdbc.Driver");
        		  con = DriverManager.getConnection("jdbc:mysql://localhost/expense_tracker", "expense_user", "expensetracker");
        		  System.out.println(con);
        	  }
        	  catch(SQLException e) {
        		  e.printStackTrace();
        	  } catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	  return con;
    	  }
    	  
    	  
      }
}
