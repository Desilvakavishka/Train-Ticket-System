<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.digitalbd.Helper,com.digitalbd.trains,java.util.ArrayList,AllLayout.Train,java.util.*" %>   
<%@ include file="header.jsp" %>
<%

	trains trn = new trains();
	String tempId = null;
	
	boolean isUpdate = true;
	if(request.getParameter("updateClick") != null){
		isUpdate = false;
		String trnId = request.getParameter("hdnbt");
		tempId = trnId;
	}


	ArrayList<Train> trainlist = new ArrayList<Train>();
	trainlist = trn.getAll();
	Iterator trnIt = trainlist.iterator();
	

%>
<% if(isUpdate){ %>
<div class="text-right">
	<a class="btn btn-success" href="Add.jsp">Create Train</a>
</div>
<br>
<div class="box successfully_purschase_ticket">
	<h2 class="box_title">All Train List</h2>
	<table class="table table-bordered">
		<tr style="background: #373e98; color:#fff;">
			<td wide="50">Train Code</td>
			<td>Name</td>
			<td>Coach</td>
			<td>Total Seat</td>
			<td style="text-align:center;">Actions</td>
		</tr>
		<%
		while(trnIt.hasNext()){
			Train trin = (Train) trnIt.next();
			
			%>
			<tr>
				<td><%= trin.code %></td>
				<td><%= trin.type %></td>
				<td><%= trin.name %></td>
				<td><%= trin.totalSeat %></td>
				<td style="text-align:center;">
					<form style="display:inline;" method="post" action="DeleteTrain">
						<input style="display:inline;" value="<%= trin.id %>" type="hidden" name="hdnbt" />
						<button style="display:inline;" class="btn btn-sm btn-danger" type="submit" name="bt" >Delete</button>
					</form>
					<form style="display:inline;" method="post" action="TrainList.jsp">
						<input style="display:inline;" value="<%= trin.id %>" type="hidden" name="hdnbt" />
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

<% }else{ %>
<div class="signpage">

	<form class="register_form" action="UpdateTrain" method="post">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-sm-offset-3" style="margin: 0 auto;">
				<div class="rs_form_box">
					<h3 class="form_section_title">
						Train Informations
					</h3>
					<div class="input-group">
						<label>Name</label>
						<input type="text" name="name" class="form-controller">
						<input style="display:none;" value="<%= tempId %>" type="hidden" name="hdnbt" />
					</div>
					<div class="input-group">
						<label>Code</label>
						<input type="text" name="code" class="form-controller">
					</div>
					<div class="input-group">
						<label>Total Seat</label>
						<input type="text" name="totalseat" class="form-controller">
					</div>
					<div class="input-group">
						<div class="form-group">
							<label>Class :</label>
							<select class="form-control" name="coach" >
							<%
							HashMap<String,String> coach = Helper.TrainsCoach();
							for(Map.Entry<String, String> temp:coach.entrySet()){
								%>
								<option value="<%= temp.getKey() %>"><%= temp.getValue() %></option>
								<%
							}
							%>
							</select>
						</div>
					</div>
				</div>

			</div>
			<div class="col-xs-12 col-sm-12 text-center">
				<div class="rs_btn_group">
					<button class="btn btn-default pull-left" name="updateTrain" value="submit" type="submit">Update Now</button>
				</div>
			</div>
		</div>
	</form>
</div>

<%
		}
		%>
<%@ include file="footer.jsp" %>