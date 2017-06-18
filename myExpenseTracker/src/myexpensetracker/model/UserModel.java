package myexpensetracker.model;

import java.sql.*;
import java.text.ParseException;
import java.util.Date;

import myexpensetracker.domain.User;
import myexpensetracker.util.JDBCConnectionObject;

public class UserModel {
	
	public boolean saveUser(User user) {
		JDBCConnectionObject jdbc = new JDBCConnectionObject();
		Connection db = jdbc.getDB();
		String sql = "INSERT INTO expense_user"
			+ "(user_name, password) VALUES"
			+ "(?,?)";
		
		try {
			PreparedStatement preparedStatement = db.prepareStatement(sql);

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
