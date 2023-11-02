package com.digitalbd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTrain
 */
@WebServlet("/AddTrain")
public class AddTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String message = "";
		boolean isTrue = false;
		if(request.getParameter("createTrain") != null){
			trains trn = new trains();
			trn.name = (String) request.getParameter("name");
			trn.code = (String) request.getParameter("code");
			trn.type = (String) request.getParameter("coach");
//			String totalSeat = (String) request.getParameter("totalseat");
			trn.totalSeat = Integer.parseInt(request.getParameter("totalseat"));
			isTrue = trn.Save();
			
			
			
			if (isTrue == true) {

				message = "Train Created";
				request.setAttribute("message", message);
				
				RequestDispatcher dis = request.getRequestDispatcher("TrainList.jsp");
				dis.forward(request, response);
			} else {
				message = "Couldn't Create the Train";
				request.setAttribute("message", message);
				
				RequestDispatcher dis = request.getRequestDispatcher("TrainList.jsp");
				dis.forward(request, response);
			}
			
		}


	}

}
