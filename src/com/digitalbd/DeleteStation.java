package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStation
 */
@WebServlet("/DeleteStation")
public class DeleteStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		boolean isTrue = false;
		Stations sts = new Stations();
		
		String stsId = (String) request.getParameter("hdnbt");
		isTrue = sts.Delete(stsId);

		if (isTrue == true) {
			message = "Station Deleted";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("StationList.jsp");
			dis.forward(request, response);
		} else {
			message = "Couldn't Delete the Station";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("StationList.jsp");
			dis.forward(request, response);
		}

	}

}
