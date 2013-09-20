package com.mambothief.pastryblog;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class TestForm extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");

		String url = req.getServletPath(); //relative url for display jsp page
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);


		resp.getWriter().println(req);
		resp.getWriter().println("Path info: " + req.getPathInfo());
		resp.getWriter().println("URI info: " + req.getRequestURI());
		resp.getWriter().println("Route info: " + req.getServletPath());

		// Get the q parameter
	    String qParam = req.getParameter("q");
	    resp.getWriter().println("Q?: " + (qParam != null ? qParam : "--null--"));

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println(req.getAttribute("q"));
	}
}
