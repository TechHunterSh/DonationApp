<%@page import="org.nm.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.io.IOException"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	
	DonationPageManager pageManager = new DonationPageManager();
	pageManager.service(request, response);
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Donation Form</title>
</head>
<body>


<%  String step = pageManager.getStep(); %>

<% if( pageManager.INPUT_STEP.equals(step)){ %>
	<%@include file="donation-form.jsp" %>
	
<%}else if( pageManager.REVIEW_STEP.equals(step)){ %>
	<%@include file="donation2.jsp" %>

<%}  else{ %>
	<%@include file="donation-form.jsp" %>

<%} %>

	
</body>
</html>