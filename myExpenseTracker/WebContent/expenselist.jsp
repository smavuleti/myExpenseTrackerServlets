<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/expense_tracker"
        user="expense_user" password="expensetracker"
    />
     
    <sql:query var="listExpenses"   dataSource="${myDS}">
        SELECT * FROM expenses;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Expenses</h2></caption>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Date</th>
                <th>Price</th>
                <th>Comments</th>
            </tr>
            <c:forEach var="expense" items="${listExpenses.rows}">
                <tr>
                    <td><c:out value="${expense.expense_id}" /></td>
                    <td><c:out value="${expense.expense_category}" /></td>
                    <td><c:out value="${expense.expense_date}" /></td>
                    <td><c:out value="${expense.expense_price}" /></td>
                    <td><c:out value="${expense.expense_comments}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>