<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
 
	Welcome ${requestScope['user'].username}. 
	<br>
	<br>
	<button type="button" onclick="location = 'myExpenseTrackerMain.html'">Add Expense</button>
	<br>
	<button type="button" onclick="location = 'expenselist.jsp'">List Expenses</button>
 	<br>
 	<button type="button" onclick="location = 'addUser.html'">Add User</button>
</body>
</html>