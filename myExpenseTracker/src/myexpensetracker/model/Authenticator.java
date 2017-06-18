package myexpensetracker.model;


import java.sql.*;

import myexpensetracker.util.JDBCConnectionObject;

public class Authenticator {
 
	public boolean authenticate(String username, String password) {
		
		JDBCConnectionObject jdbc = new JDBCConnectionObject();
		Connection db = jdbc.getDB();
	    
	    try {
	    	Statement stmt = db.createStatement();
			String sql;
		    sql = "SELECT user_name, password FROM expense_user";
			ResultSet rs = stmt.executeQuery(sql);
			boolean userFound = false;
			while(rs.next()){
		    String db_username = rs.getString("user_name");
		    String db_password = rs.getString("password");
			    if(username.equals(db_username) && password.equals(db_password)) {
			    	userFound = true;
			    	break;
			    }
		    }
			return userFound;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}