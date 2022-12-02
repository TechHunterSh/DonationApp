<%@page import="java.util.Map.Entry"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Donation Form</title>


<%  if(pageManager.hasValidationErrors()) {%>
<h1>පුණ්‍යානුමෝදනාව පත්‍රය - Please correct the following errors</h1><br>
<p><% 
for(Map.Entry entry: pageManager.errorMessage.entrySet())
	try {
		response.getWriter().append(entry.getValue().toString());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%></p>

<% } %>
<div class="container">
		<form action="donation.jsp" method="post">
		<h1>පුණ්‍යානුමෝදනාව පත්‍රය - Donation Form</h1><br>
			<p>Bank Account Details Bank Name Sampath Bank PLC Account Name
				Pragnawe Kalana Weta Punya Bharaya Account Number 000-160-005-300
				Branch City Branch, 55, D R Wijewardane Mawatha, Colombo 2 Swift
				Code BSAMLKLX Step 2: පුණ්‍යානුමෝදනා සිදුකිරීම පහසු කරගැනීමට පහත
				සඳහන් තොරතුරු අපවෙත එවීමට කාරුණිකවන්න. Please provide the following
				details for your donation.</p>

			<div class="form-group">
				<label for="name"> name <br />
				</label> <input type="text" name="uname" value=<%= pageManager.getParameter("uname") %>><br />
			</div>
			<div class="form-group">
				<label for="email"> Email (දැනුම් දීම සදහා - For receiving
					alerts)<br />
				</label> <input type="text" name="email" value=<%= pageManager.getParameter("email") %>><br />
			</div>

			<div class="form-group">
				<label for="telnumber"> දුරකථන අංකය - Tel no (දැනුම් දීම
					සදහා - For receiving alerts)<br />
				</label> <input type="text" name="telnumber" value=<%= pageManager.getParameter("telnumber") %>><br />
			</div>
			<div class="form-group">
				<label for="amount"> බැරකල මුදල - Deposit Amount*<br />
				</label> <input type="text" name="amount" value=<%= pageManager.getParameter("amount") %>> <br/>
			</div>
			<div class="form-group">
				<label for="recieptn" > රිසිට්පත් අංකය - Receipt No<br />
				</label> <input type="text" name="recieptn" value=<%= pageManager.getParameter("recieptn") %>><br />
			</div>
			<div class="form-group">
				<label for="dateDeposit"> මුදල් බැරකල දිනය - Deposit Date*<br />
				</label> <input type="date" name="dateDeposit" value=<%= pageManager.getParameter("dateDeposit") %>><br />
			</div>
			<div class="form-group">
				<label for="date"> දිනය - Date* </label> 
				<input type="date" name="date" value=<%= pageManager.getParameter("date") %>><br />
			</div>
			<div class="form-group">
				<label for="purpose"> අරමුණ - Purpose*<br />
				</label> 
				
				<%= pageManager.getRadio(DonationConstants.PURPOSE, "purpose", pageManager.getParameter("purpose")) %>
	<!-- 			<input type="radio" name="purpose" value="dhana"> එදිනෙදා දාන : Daily Dana<br/> 
				<input type="radio" name="purpose" value="meditaion"> භාවනා වැඩසටහන සඳහා : Meditation Program<br/>
				<input type="radio" name="purpose" value="Dhamma"> ශ්‍රී සද්ධර්ම සාකච්ඡා මාලාව: Dhamma Discussion Program<br/> <input
					type="radio"> Other: <input type="text" name="purpose"><br/> -->
				<br />
			</div>
			<div class="form-group">
				<label for="contributors"> දායක වු නම් - Contributors*<br />
				</label> <input type="text" name="contributors"><br />
			</div>
			<div class="form-group">
				<label for="blessingMessage"> සෙත් පැතීම් - Blessings* </label> <input
					type="text" name="blessingMessage"><br />
			</div>
			<div class="form-group">
				<label for="deceased"> මියගිය නෑදෑ හිත මිත්‍රආදි - Deceased
					friends &amp; family* </label> <input type="text" name="deceased"><br />
			</div>
			
			<input type="submit" value="submit">
		</form>
	</div>