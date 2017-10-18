<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="p" scope="request" class="beans.Person"></jsp:useBean>
	
	<table>
		<tr>
			<td>ID</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Mail</td>
			<td>Date naissance</td>
		</tr>
		<tr>
			<td><%= p.getId() %></td>
			<td><%= p.getName() %></td>
			<td><%= p.getFirstname() %></td>
			<td><%= p.getMail() %></td>
			<td><%= p.getBirthdate() %></td>
		</tr>
	</table>

</body>
</html>