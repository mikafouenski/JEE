<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="p" scope="request" class="beans.Person">
		<p>Nouvelle Personne !</p>
	</jsp:useBean>

	<form action="edition" method="POST">

		<label>Nom : </label>
		<input type="text" name="name" size="15" value="<jsp:getProperty name="p" property="name"/>"/> 
		<span style="color: red">${nameError}</span><br>
		
		<label>Prenom : </label>
		<input type="text" name="firstname" size="15" value="<jsp:getProperty name="p" property="firstname"/>"/><br>
		
		<label>Date d'anniversaire : </label>
		<input type="text" name="birthdate" value="<jsp:getProperty name="p" property="birthdate"/>"/><br>
		
		<label>Mail : </label>
		<input type="text" name="mail" value="<jsp:getProperty name="p" property="mail"/>"/>
		<span style="color: red">${emailError}</span><br>
		
		<input type="submit" name="boutonOK"value="Valider"/>

	</form>

</body>
</html>