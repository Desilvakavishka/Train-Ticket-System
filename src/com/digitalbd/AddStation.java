package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStation
 */
@WebServlet("/AddStation")
public class AddStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		int isTrue = 0;
		Stations sts = new Stations();

		if(request.getParameter("createStation") != null){
			sts.name = (String) request.getParameter("name");
			sts.contact = (String) request.getParameter("contact");
			sts.address = (String) request.getParameter("address");
			isTrue = sts.Save();
			
			if (isTrue != 0) {

				message = "Station Created";
				request.setAttribute("message", message);
				
				RequestDispatcher dis = request.getRequestDispatcher("StationList.jsp");
				dis.forward(request, response);
			} else {
				message = "Couldn't Create the Station";
				request.setAttribute("message", message);
				
				RequestDispatcher dis = request.getRequestDispatcher("StationList.jsp");
				dis.forward(request, response);
			}
			
		}
		}
		
	}

