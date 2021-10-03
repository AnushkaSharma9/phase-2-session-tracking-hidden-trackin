package com.simplilearn.webapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user-info")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public UserInfo() {
	        super();
	    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		
		if(!userId.equals("") && !userName.equals("")) {
			// create hidden form fields
			out.println("<form method='post' action='profile' >");
			out.println("<input type='hidden' name='userId' id='userId' value='"+userId+"'>");
			out.println("<input type='hidden' name='userName' id='userName' value='"+userName+"'>");
			out.println("<input type='hidden' name='token' id='token' value='"+UUID.randomUUID()+"'>");
			out.println("<input type='submit' value='Go to Profile'>");
			out.println("</form>");
			out.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
