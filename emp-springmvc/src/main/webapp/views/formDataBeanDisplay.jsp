<%@page import="com.tyss.emp.dto.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% UserBean bean=(UserBean)request.getAttribute("userBean"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Id:<%=bean.getId() %><br>
	Password:<%=bean.getPassword() %>
</body>
</html>