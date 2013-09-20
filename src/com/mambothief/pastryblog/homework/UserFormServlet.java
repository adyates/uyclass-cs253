package com.mambothief.pastryblog.homework;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class UserFormServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(UserFormServlet.class.getName());

	/**
	 * Regular expressions for use with form validation
	 */
	private final static String NAME = "^[a-zA-Z0-9_\\-]{3,20}$";
	private final static String EMAIL = "^[\\S]+@[\\S]+\\.[\\S]+$";
	private final static String PASSWORD = "^.{3,20}$";

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher("/jsp/userform.jsp");

	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			resp.getWriter().println(e);
		}
	}


	/**
	 * Do form validations!
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = null;

	    String name = req.getParameter("username");
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    String verify = req.getParameter("verify");
	    log.info(req.toString());
	    log.info(name + ":" + email + ":" + password + ":" + verify);
		boolean errorFree = Pattern.matches(NAME, name);
		errorFree = errorFree && (Pattern.matches(EMAIL, email) || email.length() == 0);
		errorFree = errorFree && Pattern.matches(PASSWORD, password);
		errorFree = errorFree && verify.equals(password);


		if (!errorFree) {
		    rd = sc.getRequestDispatcher("/jsp/userform.jsp");

		    // Add in some errors
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("name", Pattern.matches(NAME, name) ? "" : "Username is invalid");
			errorMap.put("password", Pattern.matches(PASSWORD, password) ? "" : "Password is invalid");
			errorMap.put("email", Pattern.matches(EMAIL, email) || email.length() == 0 ? "" : "Email is invalid");
			errorMap.put("verify", verify.matches(password) ? "" : "Passwords do not match");
		    req.setAttribute("errors", errorMap);
		    log.info(errorMap.toString());
		} else {
		    resp.sendRedirect("/jsp/welcome.jsp?name=" + name);
		    log.info("Success!");
		    return;
		}

	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			resp.getWriter().println(e);
		}
	}

}
