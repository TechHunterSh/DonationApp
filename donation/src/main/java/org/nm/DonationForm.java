package org.nm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

/**
 * Servlet implementation class DonationForm
 */
@WebServlet("/donationformSvlt")
public class DonationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonationForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter rp = response.getWriter();
		rp.print("<h1>Donations</h1>");
		rp.print("</br>");

		List<Entity> donors = getDonations();
		for (Entity entity : donors) {
			rp.print(entity.getKey());
			rp.print(entity.getProperty("name"));
			rp.print(entity.getProperty("date"));
			rp.print("</br>");

		}
		rp.print("</br>");
		rp.print("Total");
		rp.print(donors.size());
	}

	private List<Entity> getDonations() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Query q = new Query("donation").addSort("date", SortDirection.DESCENDING);

		PreparedQuery pq = datastore.prepare(q);
		return pq.asList(FetchOptions.Builder.withLimit(100));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String name = request.getParameter("uname");

		if (validatingInfo(name)) {

			Entity dEntity = new Entity("donation");
//			Entity dEntity = new Entity("donation", UUID.randomUUID().toString());
			dEntity.setProperty("name", name);
			dEntity.setProperty("date", new Date());

			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(dEntity);
			response.getWriter().append("donation saved for ").append(name);
		}
		else {
		response.getWriter().append("something went wrong please try again ");
		}

	}

	private boolean validatingInfo(String name) {
		if (name == null)
			return false;

		return name.trim().length() > 3;

//		String regx = "^[\\p{L} .'-]+$";
//		Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
//	    Matcher matcher = pattern.matcher(name);
//	    return matcher.find();

	}

}
