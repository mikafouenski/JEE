<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Person.Person" %>
<%@ page import="java.util.Collection" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="perM" scope="application" class="fr.myapp.bus.PersonManager" >
	</jsp:useBean> 
	<table>
		<tr>
			<td>Id</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>DateNaissance</td>
			<td>AdressMail</td>
		</tr>
		<%
			for(Person p : perM.findAll()) {
				out.println("<tr>");
				out.println("<td>"+ p.getId() + "</td>");
				out.println("<td><a href=\"edition?numero=" + p.getId() + "\"> "+ p.getNom() + "</a></td>");
				out.println("<td>"+ p.getPrenom() + "</td>");
				out.println("<td>"+ p.getDateNaissance() + "</td>");
				out.println("<td>"+ p.getAdressMail() + "</td>");
				out.println("<td><a href=\"supprimer?numero=" + p.getId() + "\"> supprimer</a></td>");
				out.println("</tr>");
			}
		%>
	</table>
	<a href="edition"> Ajouter une personne</a>
</body>
</html>