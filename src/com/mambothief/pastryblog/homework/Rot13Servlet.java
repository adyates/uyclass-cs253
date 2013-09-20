package com.mambothief.pastryblog.homework;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Rot13Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher("/jsp/rot13.jsp");

	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			resp.getWriter().println(e);
		}
	}


	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher("/jsp/rot13.jsp");
	    String postData = req.getParameter("text");

	    StringBuilder rotated = new StringBuilder("");
	    for (int i = 0; i < postData.length(); i++) {
	    	rotated.append(rotate(postData.charAt(i)));
	    }

	    req.setAttribute("text", rotated);
	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			resp.getWriter().println(e);
		}
	}

	// Rotator!
	private char rotate(char letter){
		if ('a' <= letter && letter <= 'm') {
			return shiftChar(letter, 13);
		} else if ('A' <= letter && letter <= 'M') {
			return shiftChar(letter, 13);
		} else if ('n' <= letter && letter <= 'z') {
			return shiftChar(letter, -13);
		} else if ('N' <= letter && letter <= 'Z') {
			return shiftChar(letter, -13);
		} else {
			return letter;
		}
	}

	private char shiftChar(char letter, int value) {
		return (char)((int)letter + value);
	}

}
