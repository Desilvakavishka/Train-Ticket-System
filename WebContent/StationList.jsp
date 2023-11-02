<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="AllLayout.*,com.digitalbd.trains,com.digitalbd.Stations,java.util.ArrayList,java.util.Iterator" %>
<%@ include file="header.jsp" %>
<%
	Stations sts = new Stations();
	String tempId = null;

	
	boolean isUpdate = true;
	if(request.getParameter("updateClick") != null){
		isUpdate = false;
		String stsId = request.getParameter("hdnbt");
		tempId = stsId;
		
	}
	
	

	
	
	ArrayList<Station> stationList = sts.getAll();
	Iterator stationIterator = stationList.iterator();
	




%>
<% if(isUpdate){ %>

<div class="box successfully_purschase_ticket">
	
	<div class="box_title">
		<div class="row">
			<div class="col-xs-12 col-sm-4">
				Create New Station
			</div>
			<div class="col-xs-12 col-sm-8">
				All Stations
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			
			<form class="register_form" action="AddStation" method="post">
					<div class="rs_form_box" style="margin:15px; padding:0; border:0;">
						<div class="input-group">
							<label>Name</label>
							<input type="text" name="name" class="form-controller">
						</div>
						<div class="input-group">
							<label>Contact</label>
							<input type="text" name="contact" class="form-controller">
						</div>
						<div class="input-group">
							<label>Address</label>
							<input type="text" name="address" class="form-controller">
						</div>
						<div class="text-center">
							<div class="rs_btn_group">
								<button class="btn btn-default pull-left" name="createStation" value="submit" type="submit">Save</button>
							</div>
						</div>
					</div>
			</form>
		</div>
		<div class="col-xs-12 col-sm-8">
			<br>
			<table class="table table-bordered">
				<tr>
					<td>Name</td>
					<td>Contact</td>
					<td>Address</td>
					<td style="text-align:center;">Actions</td>
				</tr>
				<%
					while(stationIterator.hasNext()){
						Station st = (Station) stationIterator.next();
						%>
						<tr>
							<td><%= st.name %></td>
							<td><%= st.contact %></td>
							<td><%= st.address %></td>
							<td style="text-align:center;">
													<form style="display:inline;" method="post" action="DeleteStation">
						<input style="display:inline;" value="<%= st.id %>" type="hidden" name="hdnbt" />
						<button style="display:inline;" class="btn btn-sm btn-danger" type="submit" name="bt" >Delete</button>
					</form>
					<form style="display:inline;" method="post" action="StationList.jsp">
						<input style="display:inline;" value="<%= st.id %>" type="hidden" name="hdnbt" />
						<button style="display:inline;" class="btn btn-sm btn-success" value="updateClick" type="submit" name="updateClick" >Update</button>
					</form>
							</td>
						</tr>
						<%
					}
						
				%>
				
			</table>
			
	<div class="alert alert-info"><p>Action Status Updates: ${message}</p></div>

		</div>
		
		
	</div>
	
</div>
<% }else{ %>
<div class="signpage">

	<form class="register_form" action="UpdateStation" method="post">
		
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-sm-offset-3" style="margin: 0 auto;">
				<div class="rs_form_box">
					<h3 class="form_section_title">
						Station Information
					</h3>
					<div class="input-group">
						<label>Station Name</label>
						<input style="display:none;" value="<%= tempId %>" type="hidden" name="hdnbt" />
						<input type="text" name="name" class="form-controller">
					</div>
					<div class="input-group">
						<label>Address</label>
						<input type="text" name="address" class="form-controller">
					</div>
					<div class="input-group">
						<label>Contact</label>
						<input type="text" name="contact" class="form-controller">
					</div>

				</div>

			</div>
			<div class="col-xs-12 col-sm-12 text-center">
				<div class="rs_btn_group">
					<button class="btn btn-default pull-left" name="updateStation" type="submit">Update Station</button>
				</div>
			</div>
		</div>
	</form>
</div>

<%} %>
<%@ include file="footer.jsp" %>