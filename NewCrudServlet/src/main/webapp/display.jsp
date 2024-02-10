<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.newservlet.bean.User"%>
<%@ page import="java.util.List"%>
<%@ page import="com.newservlet.dao.UserDaoImpl"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>User List</h2>
    <% 
    	User user =new User();
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.fetch(user);
        request.setAttribute("userList", userList);
    %>
    <table>
        <tr>
        	<th>id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Password</th>
            <th>Action</th> <!-- Add a new column for the action button -->
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
            	<td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.phone_no}</td>
                <td>${user.password}</td>
                <td>
                    <form action="update.jsp" method="GET"> <!-- Redirect to update.jsp when button is clicked -->
                         <input type="hidden" name="userId" value="${user.id}" /> <!-- Pass user ID to update.jsp --> 
                        <button type="submit">Update</button>
                    </form>
                    <br>
              		 <form action="DeleteServlet" method="get"> <!-- Redirect to DeleteServlet when delete button is clicked -->
                        <input type="hidden" name="userId" value="${user.id}" /> <!-- Pass user ID to DeleteServlet --> 
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>   
</body>
</html>
