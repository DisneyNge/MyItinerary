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
 * The Class ResortClient.
 */
public class ResortClient {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(DiningClient.class);

	/** The http client. */
	@Autowired
	HttpClient httpClient;

	/**
	 * Gets the http client.
	 *
	 * @return the http client
	 */
	public HttpClient getHttpClient() {
		return httpClient;
	}

	/** The resort rest endpoint. */
	private String resortRestEndpoint;

	/**
	 * Gets the resort rest endpoint.
	 *
	 * @return the resort rest endpoint
	 */
	public String getResortRestEndpoint() {
		return resortRestEndpoint;
	}

	/**
	 * Sets the resort rest endpoint.
	 *
	 * @param resortRestEndpoint the new resort rest endpoint
	 */
	public void setResortRestEndpoint(String resortRestEndpoint) {
		this.resortRestEndpoint = resortRestEndpoint;
	}

	/**
	 * Sets the http client.
	 *
	 * @param httpClient
	 *            the new http client
	 */
	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Gets the resort.
	 *
	 * @param customerId
	 *            the customer id
	 * @return the resort
	 * @throws IOException 
	 */
	public List getResort(final Long customerId) throws IOException {

		BufferedReader br =null;
		String output = "";
		List resortReservationList = new ArrayList<>();
		//resortReservationList = null;

		try {
			logger.info("Itinerary for resort");

			HttpGet getRequest = new HttpGet(resortRestEndpoint + customerId);

			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				//throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			 br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			while ((output = br.readLine()) != null) {
				resortReservationList.add(output);
			}
			return resortReservationList;

		} catch (ClientProtocolException e) {

			e.printStackTrace();
			logger.error(e);
			return resortReservationList;

		} catch (IOException e) {

			e.printStackTrace();
			logger.error(e);
			return resortReservationList;
		}
		finally{
//			br.close();
//			httpClient.getConnectionManager().closeExpiredConnections();
		}
	}
}
