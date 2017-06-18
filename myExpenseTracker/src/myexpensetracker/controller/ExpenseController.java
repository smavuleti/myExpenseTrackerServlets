package myexpensetracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myexpensetracker.domain.Expense;
import myexpensetracker.model.ExpenseModel;

@WebServlet("/servlet/expense")
public class ExpenseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExpenseModel model = new ExpenseModel();
	    PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String category = request.getParameter("category");
		String expenseDate = request.getParameter("date");
		double price = Double.parseDouble(request.getParameter("price"));
		String comments = request.getParameter("comments");

		Expense expenseObject = new Expense();
		expenseObject.setCategory(category);
		expenseObject.setDate(expenseDate);
		expenseObject.setPrice(price);
		expenseObject.setComments(comments);
		if(model.saveExpense(expenseObject)){
			out.println("<html>");
			out.println("<head><title>Expense added</title></head>");
			out.println("<body><h1>");
			out.println("<br> <font color='brown'> <b>Category:</b>");
			out.print("<i>" + expenseObject.getCategory() + "</i></font>");
			out.println("<br><font color='blue'> <b> Date:</b>");
			out.print("<i>" + expenseObject.getDate() + "</i></front>");
			out.println("<br> <font color='red'> <b>Price:</b>");
			out.print("<i>" + expenseObject.getPrice() + "</i></front>");
			out.println("<br> <font color='yellow'> <b>Comments:</b>");
			out.print("<i>" + expenseObject.getComments()+ "</i></front>");
			out.println("</h1>");
			out.println("</body></html>");
		}
		else {
			
		}
		

	}
}
