<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acce</title>
</head>
<body>
	<jsp:useBean id="person" scope="session" class="Person.Person" >
	</jsp:useBean> 
	<table>
		<tr>
			<td>Id</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>DateNaissance</td>
			<td>AdressMail</td>
		</tr>
		<tr>
			<td><jsp:getProperty name="person" property="id" /></td>
			<td><jsp:getProperty name="person" property="nom"/></td>
			<td><jsp:getProperty name="person" property="prenom"/></td>
			<td><jsp:getProperty name="person" property="dateNaissance"/></td>
			<td><jsp:getProperty name="person" property="adressMail"/></td>
		</tr>
	</table>
</body>
</html>