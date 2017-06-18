package myexpensetracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myexpensetracker.domain.User;
import myexpensetracker.model.UserModel;

@WebServlet("/servlet/addUser")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = new UserModel();
	    PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(username, password);
		if(model.saveUser(user)){
			out.println("<html>");
			out.println("<head><title>User added</title></head>");
			out.println("<body><h1>User Added:</h1>");
			out.println("<br><b>Username:</b>");
			out.print("<i>" + user.getUsername() + "</i>");
			out.println("</body></html>");
		}
		else {
			
		}
		

	}
}
