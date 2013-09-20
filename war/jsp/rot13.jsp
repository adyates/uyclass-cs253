<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homework 2.1 - Rot 13</title>
</head>
	<body>
		<h1>Text today, for rotation today</h1>
		<form method="post">
			<textarea name="text">${fn:escapeXml(text)}</textarea><br />
			<button type="submit"> Rotate! </button>
		</form>
	</body>
</html>
