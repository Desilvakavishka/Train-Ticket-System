package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTrain
 */
@WebServlet("/UpdateTrain")
public class UpdateTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		trains trn = new trains();
		String message = "";
		
		trn.name = (String) request.getParameter("name");
		trn.code = (String) request.getParameter("code");
		trn.type = (String) request.getParameter("coach");
		String trnId = request.getParameter("hdnbt");
		String totalSeat = (String) request.getParameter("totalseat");
		trn.totalSeat = Integer.parseInt(totalSeat);
		boolean isTrue = trn.Update(trnId);

		
			if (isTrue == true) {

				message = "Train Updated";
				request.setAttribute("message", message);
				
				RequestDispatcher dis = request.getRequestDispatcher("TrainList.jsp");
				dis.forward(request, response);
			} else {
				message = "Couldn't Update the Train";
				request.setAttribute("message", message);
				
				RequestDispatcher dis = request.getRequestDispatcher("TrainList.jsp");
				dis.forward(request, response);
			}
		
	}

}
