package com.itinerary.guest.itinerary.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The Class DiningClient.
 *
 * @author deeprk
 */
public class DiningClient {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(DiningClient.class);

	/** The http client. */
	@Autowired
	HttpClient httpClient;
	
	private String diningRestEndpoint;
	
		public String getDiningRestEndpoint() {
		return diningRestEndpoint;
	}

	public void setDiningRestEndpoint(final String diningRestEndpoint) {
		this.diningRestEndpoint = diningRestEndpoint;
	}

	/**
	 * Gets the http client.
	 *
	 * @return the http client
	 */
	public HttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * Sets the http client.
	 *
	 * @param httpClient
	 *            the new http client
	 */
	public void setHttpClient(final HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Gets the dining.
	 *
	 * @param customerId
	 *            the customer id
	 * @return the dining
	 * @throws IOException 
	 */
	public List getDining(final Long customerId) throws IOException {
		BufferedReader br = null;

		String output="";
		List diningReservationList = new ArrayList<>();
		//diningReservationList = null;

		try {
			logger.info("Itinerary for Dining");

			final HttpGet getRequest = new HttpGet(diningRestEndpoint + customerId);

			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

		 	br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			while ((output = br.readLine()) != null) {
				diningReservationList.add(output);
			}
			return diningReservationList;

		} catch (ClientProtocolException e) {

			e.printStackTrace();
			logger.error(e);
			return diningReservationList;

		} catch (IOException e) {

			e.printStackTrace();
			logger.error(e);
			return diningReservationList;
		}
		finally{
			//br.close();
			//httpClient.getConnectionManager().closeExpiredConnections();
		}
	}
}
