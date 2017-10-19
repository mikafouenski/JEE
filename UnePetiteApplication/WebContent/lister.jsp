<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="manager" scope="application" class="metier.PersonManager"></jsp:useBean>

	<table>
		<tr>
			<td>ID</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Mail</td>
			<td>Date naissance</td>
		</tr>
		<%
		for (int k : manager.getPersons().keySet()) {
			Person p =  manager.getPersons().get(k);
			out.println("<tr>");
			out.println("<td>" + p.getId() + "</td>");
			out.println("<td>" + p.getName() + "</td>");
			out.println("<td>" + p.getFirstname() + "</td>");
			out.println("<td>" + p.getMail() + "</td>");
			out.println("<td>" + p.getBirthdate() + "</td>");
			out.println("<td><a href=\"edition?numero=" + p.getId() + "\">editier</a></td>");
			out.println("<td><a href=\"supprimer?numero=" + p.getId() + "\">supprimer</a></td>");
			out.println("</tr>");
		}
		%>
	</table>
	
	<a href="edition">Nouvelle personne</a>

</body>
</html>