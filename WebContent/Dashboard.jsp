<!-- 
// Dias D.D.K.S.
// IT21220760
// SE/OOP_MLB_WD_2022_S2_183
 -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.digitalbd.Helper,com.digitalbd.*,java.sql.ResultSet,AllLayout.*,java.util.*" %>

<%
	//creating station object
	Stations stations = new Stations();
	ArrayList<Station> allStations = stations.getAll();
	String tempId = null;
	
	//check for update button click
	boolean isUpdate = true;
	if(request.getParameter("updateClick") != null){
		isUpdate = false;
		String trnId = request.getParameter("hdnbt");
		tempId = trnId;
	}

%>

<!-- importing header section -->
<%@ include file="header.jsp" %>

<%
if(isUpdate){ 
String userId = null;
if(session.getAttribute("user_id") != null){
	userId = (String) session.getAttribute("user_id");
}
User user = new User(userId);
%>


<div class="dashboard">
<!-- personal details section begins-->
	<div class="box personal_info">
		<h2 class="box_title">Personal Information</h2>
		<table class="table table-bordered">
			<tr>
				<td><strong>Full Name</strong></td>
				<td><%= user.name %></td>
			</tr>
			<tr>
				<td><strong>Email Address</strong></td>
				<td><%= user.email %></td>
			</tr>
			<tr>
				<td><strong>Cell Phone Number</strong></td>
				<td><%= user.phone %></td>
			</tr>
			<tr>
				<td><strong>Address</strong></td>
				<td><%= user.address %></td>
			</tr>
		</table>
	</div>
	
	<!-- personal details section ends-->
	<!-- purchase details section begins-->
	<div class="box successfully_purschase_ticket">
		<h2 class="box_title">Successful Purchase Information</h2>
		<table class="table table-bordered">
			<tr style="background: #373e98; color:#fff;">
				<td>Train Name</td>
				<td>Coach/Class</td>
				<td>Purchase Date</td>
				<td>Journey Date</td>
				<td>Station From</td>
				<td>Station To</td>
				<td>Total Seat</td>
				<td style="text-align:center;">Option</td>
			</tr>
			<%
			//retrieving personal data
			Booking booking = new Booking();
			ResultSet bookedTicket = booking.FindByUser(user.id);
			while(bookedTicket.next()){
				Destination tempDestination = new Destination(bookedTicket.getString("destination_id"));
				trains trnTemp = new trains(tempDestination.train_id);
				Station stationFromTemp = new Stations().getStation(tempDestination.station_from);
				Station stationToTemp = new Stations().getStation(tempDestination.station_to);
				%>
				<tr>
					<td><%= trnTemp.name %></td>
					<td><%= trnTemp.type %></td>
					<td><%= bookedTicket.getString("booking_date") %></td>
					<td><%= bookedTicket.getString("journey_date") %></td>
					<td><%= stationFromTemp.name %></td>
					<td><%= stationToTemp.name %></td>
					<td style="text-align:center;"><%= bookedTicket.getString("number_of_seat") %></td>
					<td style="text-align:center;">
						<form style="display:inline;" method="post" action="DeleteBooking">
							<input style="display:inline;" value="<%= bookedTicket.getString("id") %>" type="hidden" name="hdnbt" />
							<button style="display:inline;" class="btn btn-sm btn-danger" type="submit" name="bt" >Delete</button>
						</form>
						<form style="display:inline;" method="post" action="Dashboard.jsp">
							<input style="display:inline;" value="<%= bookedTicket.getString("id") %>" type="hidden" name="hdnbt" />
							<button style="display:inline;" class="btn btn-sm btn-success" value="updateClick" type="submit" name="updateClick" >Update</button>
						</form>
					</td>
					
				</tr>
				<%
			}
			%>
			
		</table>
	</div>
	<!-- purchase details section ends-->
</div>

<% }else{ %>
<!-- update ticket section begins-->
<div class="signpage">
	<form class="register_form" style="max-width:400px;" action="UpdateBooking" method="post">
		<div class="rs_form_box">
			<h3 class="form_section_title">
				 Update Journey Date Date
			</h3>

			<input style="display:none;" value="<%= tempId %>" type="hidden" name="hdnbt" />
			<div class="form-group">
				<label>Journey Date :</label>
				<select class="form-control" name="journey_date" id="from_where_select">
					<%
					
					// retrieving journey dates
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DAY_OF_YEAR, 0);

					for(int i = 0; i< 10; i++){
					    cal.add(Calendar.DAY_OF_YEAR, 1);
					    String tempDtate = dateFormat.format(cal.getTime());
					    %>
					    <option value="<%= tempDtate %>"><%= tempDtate %></option>
					    <%
					}
					%>
					
				</select>
			</div>
			


		</div>
		<div class="text-center">
			<div class="rs_btn_group">
				<button class="btn btn-default" type="submit">Update Ticket</button>
			</div>
		</div>
	</form>
</div>
<!-- update ticket section ends-->

<%
		}
		%>
		
<!-- importing footer section -->
<%@ include file="footer.jsp" %>