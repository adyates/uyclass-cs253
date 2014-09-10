<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homework 2.2 - Welcome!</title>
	<style>
	.error {
		color : red;
	}
	</style>
</head>
	<body>
		<h1>Welcome to the site, <%= request.getParameter("name") %></h1>
	</body>
	<p>Curious about Udacity classes?  Check out the one for this class:
		<a href="//www.udacity.com/course/cs253">Web Development</a></p>
	<p>Or if you don't mind toying with some bonus Google Analytics tagging:
		<a href="//www.udacity.com/course/cs253?utm_medium=referral&utm_campaign=api">
			Web Development (GA)</a></p>
</html>
