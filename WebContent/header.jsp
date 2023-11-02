<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.digitalbd.Helper,com.digitalbd.User" %>
<%
boolean isLogin = false;
if(session.getAttribute("isUserLogin") != null)
	isLogin = (boolean) session.getAttribute("isUserLogin");

//checking for existing sessions

String uri = request.getRequestURI();
String pageName = uri.substring(uri.lastIndexOf("/")+1);
		
if (session.getAttribute("isUserLogin") == null && 
	!pageName.equals("index.jsp") && 
	!pageName.equals("Register.jsp") && 
	!pageName.equals("Login.jsp")) 
{
	response.sendRedirect("Login.jsp");
}

%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/assets/owl.carousel.min.css"/>
    <link rel="stylesheet" href="css/assets/owl.theme.default.css"/>
    <link rel="stylesheet" href="css/main.css"/>
    <link rel="stylesheet" href="css/slider.css"/>
    <link rel="stylesheet" href="css/all.css"/>
    <link rel="icon" type="image/png" sizes="32x32" href="images/fav.png">

    
    
    

  </head>
  <body>
 
  	<div class="header header_content" style="background: #373e98; color:#fff; margin: 0 0 50px 0 ">
  		<div class="">
  			<div class="header_content " style="background: #2a2a2a; font-family:headerFont;">
  				<a href="<%= Helper.baseUrl %>index.jsp"  class="nav-item" style ="color:#ceb92c; text-decoration:none;">Online Train Ticketing System</a>
  			</div>
  			<div class="container header_nav"  >
  				<ul class="nav nav-pills pull-left "  >
  					<% if(isLogin){ 
  						String userId = (String) session.getAttribute("user_id");
  						User user = new User(userId);
  						if(user.rule.equals("admin")){
  							%>
  							<li  class="nav-item"><a href="<%= Helper.baseUrl %>Dashboard.jsp" class="nav-link">Dashboard</a></li>
							<li  class="nav-item"><a href="<%= Helper.baseUrl %>TrainList.jsp" class="nav-link">Trains</a></li>
							<li  class="nav-item"><a href="<%= Helper.baseUrl %>StationList.jsp" class="nav-link">Stations</a></li>
							<li  class="nav-item"><a href="<%= Helper.baseUrl %>Destinations.jsp" class="nav-link">Destinations</a></li>
							<li  class="nav-item"><a href="<%= Helper.baseUrl %>Purchase.jsp" class="nav-link">Purchase Ticket</a></li>
							<li class="nav-item"><a href="<%= Helper.baseUrl %>Logout"  class="nav-link">Logout</a></li>
  							<%
  						}
  						else{
  							%>
  							<li  class="nav-item"><a href="<%= Helper.baseUrl %>Dashboard.jsp" class="nav-link">Dashboard</a></li>
  							<li  class="nav-item"><a href="<%= Helper.baseUrl %>Purchase.jsp" class="nav-link">Purchase Ticket</a></li>
  							<li class="nav-item" ><a href="<%= Helper.baseUrl %>Logout" class="nav-link">Logout</a></li>
  							
  						<%
  						}
  					}
  					else{
  					%>
  						<li class="nav-item"><a href="<%= Helper.baseUrl %>Register.jsp" class="nav-link">Register</a></li>
  						<li class="nav-item"><a href="<%= Helper.baseUrl %>Login.jsp" class="nav-link">Login</a></li>
  					<% } %>
  				</ul>
  			</div>
  		</div>
  	</div>
  	<section class="main_contents" >
  		<div class="container">
  		<div class="main_contents_inner" style="background: #fff;">
