package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTicket
 */
@WebServlet("/UpdateBooking")
public class UpdateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		Booking book = new Booking();
		
		String bookId = request.getParameter("hdnbt");
		book.journey_date = (String) request.getParameter("journey_date");

		boolean isTrue = book.Update(bookId);
		
		if (isTrue == true) {

			message = "Ticket Updated";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("Dashboard.jsp");
			dis.forward(request, response);
		} else {
			message = "Couldn't Update the Ticket";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("Dashboard.jsp");
			dis.forward(request, response);
		}
		
	}

}
