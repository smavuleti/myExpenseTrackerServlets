package myexpensetracker.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import myexpensetracker.domain.Expense;
import myexpensetracker.util.JDBCConnectionObject;
import java.util.Date;


public class ExpenseModel {
	public boolean saveExpense(Expense expense) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		JDBCConnectionObject jdbc = new JDBCConnectionObject();
		Connection db = jdbc.getDB();
		String sql = "INSERT INTO expenses"
			+ "(expense_category, expense_date, expense_price, expense_comments) VALUES"
			+ "(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, expense.getCategory());
			Date date = null;
			try {
				date = formatter.parse(expense.getDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setDouble(3, expense.getPrice());
			preparedStatement.setString(4, expense.getComments());
			
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
