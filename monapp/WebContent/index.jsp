
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Title</title>
</head>
<body>

	<p>Hello.</p>
	<%@page import="java.util.Date"%>

	<%!Date now = new Date();%>

	<p>
		Aujourd'hui :
		<%=now%></p>
	<%@page import="java.util.Date"%>

	<p>
		Aujourd'hui :
		<%=new Date()%>
	</p>
	

</body>
</html>