<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <head>
    <title>Hello App Engine</title>
  </head>

  <body>
	<p>Curious about Udacity classes?  Check out the one for this class:
		<a href="//www.udacity.com/course/cs253">Web Development</a>
	</p>
			
	<form method="post">
		What is your birthday?
		<br>
		<label>Month <input type="text" name="month" /></label>
		<label>Day <input type="text" name="day" /></label>
		<label>Year <input type="text" name="year" /></label>
		<div style="color:red"></div>
		<br>
		<br>
		<input type="submit" />
	</form>
  </body>
</html>
