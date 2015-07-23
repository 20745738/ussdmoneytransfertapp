package com.sifast.ussd.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.scripts.JS;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * Servlet implementation class USSDCustomer
 */
@WebServlet("/USSDCustomer")
public class USSDCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String host = "172.16.0.41";
	private String user = "root";
	private String password = "sifat**2015";
	private String command = "gsm-ussd --no-cleartext -m /dev/ttyUSB2 ";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public USSDCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String message = "";
		String exitStatus = "";
		if (req.getAttribute("message") != null) {
			message = req.getAttribute("message").toString();
		}
		if (req.getAttribute("exitStatus") != null) {
			exitStatus = req.getAttribute("exitStatus").toString();
		}

		StringBuilder response = new StringBuilder();
		response.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:ui=\"http://java.sun.com/jsf/facelets\" xmlns:h=\"http://java.sun.com/jsf/html\" xmlns:f=\"http://java.sun.com/jsf/core\">");
		response.append("<head></head>");
		response.append("<body>");

		response.append("<span>");
		response.append(message);
		response.append("</span>");
		response.append("<br /><br /><br /><br />");

		response.append("<form method=\"post\" action=\"/USSDApplication/USSDCustomer\">");
		response.append("<label>USSD</label>");
		response.append("<input type=\"text\" name=\"ussd\" />");
		response.append("<button type=\"submit\">Send</button>");
		response.append("</form></body></html>");

		PrintWriter out = resp.getWriter();
		out.println(response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OK");
		String param = request.getParameter("ussd").toString();
		System.out.println(request.getParameter("ussd").toString());
		String message = "";
		int exitStatus = -99;
		try {
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jSch = new JSch();
			
			Session session = jSch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);

			session.setConfig("PreferredAuthentications", "password");

			session.connect();
			System.out.println("Connected...");

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(new StringBuilder()
					.append(command).append(param).toString());

			InputStream in = channel.getInputStream();
			channel.connect();

			byte[] tmp = new byte[1024];

			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					message = new String(tmp, 0, i);
					System.out.print(message);
				}
				if (channel.isClosed()) {
					exitStatus = channel.getExitStatus();
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			request.setAttribute("message", message);
			request.setAttribute("exitStatus", exitStatus);

			System.out.println(channel == null);
			System.out.println(channel.getInputStream() == null);
			channel.disconnect();
			session.disconnect();

			System.out.println("DONE");
			doGet(request, response);

		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
