<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Connection" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="com.projectA.dao.UserDAO" %>
<%@ page import="util.DBManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DB 연결</h1>
<%
	UserDAO dao = UserDAO.getInstance();
	Connection conn = DBManager.getConnection();

	out.println("DB연결 성공");	
%>
<h1>DBCP 연결</h1>
</body>
</html>