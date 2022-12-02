package org.nm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DonationPageManager {

	public static final String INPUT_STEP = "inputStep";
	public static final String REVIEW_STEP = "reviewStep";
	public static final String SUCCESS_STEP = "successStep";
	public Map<String, String> formInputs = new HashMap<String, String>();

	private HttpServletRequest request;
	private HttpServletResponse response;
	public Map<String, String> errorMessage = new HashMap<String, String>();
	private String step=INPUT_STEP;
	
	

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
		System.out.println(DonationPageManager.class.getProtectionDomain().getCodeSource().getLocation());

		if ("POST".equals(request.getMethod())) {
			System.out.println("I am here");
				
			validatingInfo(request);
			
			if(hasValidationErrors()) {
				step = INPUT_STEP;
			}
			else {
				step=REVIEW_STEP;
			}
//			if(!hasValidationErrors()) {
//	            request.getRequestDispatcher("donation2.jsp").forward(request, response);
//
//			}
		}
		// parameters
		// validate
		// save
//		formInputs.put(DonationConstants.UNAME, request.getParameter(DonationConstants.UNAME));
//		formInputs.put(DonationConstants.EMAIL, request.getParameter(DonationConstants.EMAIL));
//		formInputs.put(DonationConstants.TELNUMBER, request.getParameter(DonationConstants.UNAME));
//		formInputs.put(DonationConstants.AMOUNT, request.getParameter(DonationConstants.UNAME));
//		formInputs.put(DonationConstants.RECIEPTN, request.getParameter(DonationConstants.UNAME));
//		formInputs.put(DonationConstants.DATEDEPOSIT, request.getParameter(DonationConstants.DATEDEPOSIT));
//		formInputs.put("purpose", request.getParameter((String) (DonationConstants.PURPOSE).get("purpose")));
//		formInputs.put(DonationConstants.DATE, request.getParameter(DonationConstants.DATE));

	}

	public boolean hasValidationErrors() {
		return !errorMessage.isEmpty();
	}
	public Map<String, String> getValidationErrors() {
//		for(Map.Entry entry: errorMessage.entrySet())
//			try {
//				response.getWriter().append(entry.getValue().toString());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		return errorMessage;
		
	}

	private void setValidePage(Map<String, String> map) {
//		if (map.size() == 0)
//			getStep(1);
//		else
//			getStep(0);

	}

	private void validatingInfo(HttpServletRequest req) {
		errorMessage.clear();
		String name = req.getParameter(DonationConstants.UNAME);
		String email = req.getParameter(DonationConstants.EMAIL);
		String tel = req.getParameter(DonationConstants.TELNUMBER);
		String amount = req.getParameter(DonationConstants.AMOUNT);
		String dateDeposited = req.getParameter(DonationConstants.DATEDEPOSIT);
		String receipt = req.getParameter(DonationConstants.RECIEPTN);

		/* Validate name */
		if (name == null || name.trim().length() == 0) {
			errorMessage.put(DonationConstants.UNAME, "Please enter your name");
			// return false;
		}

		/* Server side form validation logic */
		// Validate name

		/* validate email */
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches())
			errorMessage.put(DonationConstants.EMAIL, "Please enter valid email");

		// validate telnumber
		Pattern p = Pattern.compile("^\\d{10}$");
		Matcher m = p.matcher(tel);
		if (null == tel || !m.matches())
			errorMessage.put(DonationConstants.TELNUMBER, "Please enter valid telephone number");

		// validate amount
		if (amount.isEmpty() || !amount.chars().allMatch(Character::isDigit) || amount.trim().length() == 0) {
			errorMessage.put(DonationConstants.AMOUNT, "Please enter amount deposited");
		}

		// validate dateDeposited
		if(name == null || name.trim().length() == 0) {
		
			errorMessage.put(DonationConstants.DATEDEPOSIT, "Please enter valid date");
		
		}else
			try {

				// ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
				LocalDate.parse(dateDeposited,
						DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));

				// valid = true;

			} catch (DateTimeParseException e) {
				e.printStackTrace();
				errorMessage.put(DonationConstants.DATEDEPOSIT, "Please enter valid date");
			}
			

		// validate receipt
		if (receipt.isEmpty() || receipt.equals(null)) {
			errorMessage.put(DonationConstants.RECIEPTN, "Please enter receipt number");
		}

		setValidePage(errorMessage);
	}

	public String getStep() {
		
		

		return step;

	}

	public String getParameter(String fieldName) {
		String value = request.getParameter(fieldName);
		if (value == null)
			return "";
		return value;
	}

	public String getRadio(Map<String, String> values, String inputName, String paramValue) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> value : values.entrySet()) {
			sb.append("<input type=\"radio\" name=\"").append(inputName).append("\" value=\"").append(value.getKey())
					.append("\"");

			if (value.getKey().equals(paramValue)) {
				sb.append("selected");
			}
			sb.append(">").append(value.getValue()).append("<br/>");
		}
		return sb.toString();
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * LocalDate ld= LocalDate.parse("11/11/2001",
	 * DateTimeFormatter.ofPattern("MM/dd/uuuu").withResolverStyle(ResolverStyle.
	 * STRICT));
	 * 
	 * System.out.println(ld); // valid = true; }
	 */
	
}
