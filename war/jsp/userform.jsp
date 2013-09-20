<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homework 2.2 - User Form</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Hey buddy. Who are you?</h1>
	<form method="post">
		Name <input type="text" name="username" />
		<span class="error">${errors.name}</span><br>
		Password <input type="password" name="password" />
		<span class="error">${errors.password}</span><br>
		Verify Password <input type="password" name="verify" />
		<span class="error">${errors.verify}</span><br>
		Email <input type="text" name="email" />
		<span class="error">${errors.email}</span><br>
		<button type="submit">Sign up!</button>
	</form>
</body>
</html>
