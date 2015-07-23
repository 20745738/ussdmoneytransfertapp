package com.sifast.ussd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class USSDAuthenticate
 */
@WebServlet("/USSDAuthenticate")
public class USSDAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "";
		String exitStatus = "";
		if (request.getAttribute("message") != null) {
			username = request.getAttribute("message").toString();
		}
		if (request.getAttribute("exitStatus") != null) {
			exitStatus = request.getAttribute("exitStatus").toString();
		}

		StringBuilder resp = new StringBuilder();
		resp.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:ui=\"http://java.sun.com/jsf/facelets\" xmlns:h=\"http://java.sun.com/jsf/html\" xmlns:f=\"http://java.sun.com/jsf/core\">");
		resp.append("<head></head>");
		resp.append("<body>");

		resp.append("<span>");
		resp.append(username);
		resp.append("</span>");
		resp.append("<br /><br /><br /><br />");

		resp.append("<form method=\"post\" action=\"/USSDApplication/USSDAuthenticate\">");
		resp.append("<label>USSD</label>");
		resp.append("<input type=\"text\" name=\"username\" />");
		resp.append("<input type=\"text\" name=\"password\" />");
		resp.append("<button type=\"submit\">Connect</button>");
		resp.append("</form></body></html>");

		PrintWriter out = response.getWriter();
		out.println(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
