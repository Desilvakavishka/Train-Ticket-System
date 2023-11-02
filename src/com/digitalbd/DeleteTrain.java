package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteTrain
 */
@WebServlet("/DeleteTrain")
public class DeleteTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		boolean isTrue = false;
		trains trn = new trains();

		String trnId = request.getParameter("hdnbt");
		isTrue = trn.Delete(trnId);
		

		if (isTrue == true) {

			message = "Train Deleted";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("TrainList.jsp");
			dis.forward(request, response);
		} else {
			message = "Couldn't Delete the Train";
			request.setAttribute("message", message);
			
			RequestDispatcher dis = request.getRequestDispatcher("TrainList.jsp");
			dis.forward(request, response);
		}
		
	}

}
