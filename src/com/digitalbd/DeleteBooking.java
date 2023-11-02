package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBooking
 */
@WebServlet("/DeleteBooking")
public class DeleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		boolean isTrue = false;
		Booking book = new Booking();

		String bookId = request.getParameter("hdnbt");
		isTrue = book.Delete(bookId);
		System.out.print("Booking Id:" +bookId);
		

		if (isTrue == true) {

			message = "Train Deleted";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("Dashboard.jsp");
			dis.forward(request, response);
		} else {
			message = "Couldn't Delete the Train";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("Dashboard.jsp");
			dis.forward(request, response);
		}
		
	}

}
