package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStation
 */
@WebServlet("/UpdateStation")
public class UpdateStation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String message = "";
		boolean isTrue = false;
		Stations sts = new Stations();
		
		if(request.getParameter("updateStation") != null){
			
			String stsId = request.getParameter("hdnbt");
			sts.name = (String) request.getParameter("name");
			sts.contact = (String) request.getParameter("contact");
			sts.address = (String) request.getParameter("address");
			isTrue = sts.Update(stsId);
		
				if (isTrue == true) {

					message = "Station Updated";
					request.setAttribute("message", message);
					
					RequestDispatcher dis = request.getRequestDispatcher("StationList.jsp");
					dis.forward(request, response);
				} else {
					message = "Couldn't Updated the Station";
					request.setAttribute("message", message);
					
					RequestDispatcher dis = request.getRequestDispatcher("StationList.jsp");
					dis.forward(request, response);
				}
			
		}
		
	}

}
