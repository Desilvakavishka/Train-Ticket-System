// Dias D.D.K.S.
// IT21220760
// SE/OOP_MLB_WD_2022_S2_183

package com.digitalbd;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDestination
 */
@WebServlet("/UpdateDestination")
public class UpdateDestination extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
	  
	// declaring assigning variables
    String message = "";
    boolean isTrue = false;
    Destination dest = new Destination();

    // checking for button clicks
    if (request.getParameter("updateDestination") != null) {
    	
      // gathering values from input fields
      dest.time = (String) request.getParameter("jurny_time_up");
      dest.fare = (String) request.getParameter("fare_up");
      dest.total_seat = (String) request.getParameter("total_seat_up");
      dest.seat_range = (String) request.getParameter("seat_range_up");

      String delId = request.getParameter("upId");
      String from = request.getParameter("station_from");
      String train = request.getParameter("dst_train");
      
      // calling class method
      isTrue = dest.Update(delId);

      // error handling
      if (isTrue == true) {
        message = "Destination Updated";
        request.setAttribute("message", message);

        RequestDispatcher dis = request.getRequestDispatcher(
          "Destinations.jsp?dst_train=" +
          train +
          "&station_from=" +
          from +
          "&search=1"
        );
        dis.forward(request, response);
      } else {
        message = "Couldn't Update the Destination";
        request.setAttribute("message", message);

        RequestDispatcher dis = request.getRequestDispatcher(
          "Destinations.jsp?dst_train=" +
          train +
          "&station_from=" +
          from +
          "&search=1"
        );
        dis.forward(request, response);
      }
    }
  }
}
