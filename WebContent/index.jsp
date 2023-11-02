<!-- 
// Dias D.D.K.S.
// IT21220760
// SE/OOP_MLB_WD_2022_S2_183
 -->
 
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- Importing header section -->
<%@ include file="header.jsp" %>

	<!-- index page content begins -->
      <main role="main" class="inner cover">
      	<img src="images/logo.png" class="img-fluid" alt="Responsive image">
        <h1 class="cover-heading" style="font-family:headerFont; margin-top:20px;">Welcome to Train.Co</h1>
        <p class="lead" style="font-size: 15px">Train.Co , Srilanka's leading travel portal is the best way to book train tickets online.<br /> No matter where you are in the country, make a hassle-free railway reservation from us using your <br /> computer or smartphone...</p>
        <p class="lead">
          <a href="<%= Helper.baseUrl %>Login.jsp" class="btn btn-lg btn-secondary">Login / Register</a>
        </p>
      </main>
      <!-- index page content ends -->
      
<!-- Importing footer section -->
<%@ include file="footer.jsp" %>