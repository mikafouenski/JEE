<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="person" scope="session" class="Person.Person" >
</jsp:useBean> 
<jsp:useBean id="excep" scope="request" class="exception.ExceptionPersonInvalidate" >
</jsp:useBean> 

<form action="Edition" method="POST">

  <p style="color:red;"><jsp:getProperty name="excep" property="nomValide"/></p>
  <label>Nom : </label>
  <input type="text" name="nom" size="15" value=<jsp:getProperty name="person" property="nom"/>><br/>
  
  <label>Prénom : </label>
    <input type="text" name="prenom" size="15"
    value=<jsp:getProperty name="person" property="prenom" />><br/>

   <label>Date de naissance : </label>
    <input type="date" name="date" size="15" value=<jsp:getProperty name="person" property="dateNaissance"/>><br/>
  
  <p style="color:red;"><jsp:getProperty name="excep" property="emailValide"/></p>
  <label>Adresse Mail  : </label>
    <input type="text" name="mail" size="15" value=<jsp:getProperty name="person" property="adressMail"/>><br/>
  

  <input type="submit" name="boutonOK" value="Valider"/>

</form>
</body>
</html>