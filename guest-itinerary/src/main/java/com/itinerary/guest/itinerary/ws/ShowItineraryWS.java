package com.itinerary.guest.itinerary.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.itinerary.guest.itinerary.model.Itinerary;
import com.itinerary.guest.itinerary.model.ItineraryConstant;
import com.itinerary.guest.itinerary.model.ResponseModel;
import com.itinerary.guest.itinerary.service.Service;

/**
 * The Class ShowItineraryWS.
 */
public class ShowItineraryWS {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(ShowItineraryWS.class);

	/** The service. */
	@Autowired(required = true)
	private Service service;

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * Gets the itinerary by customer id.
	 *
	 * @param customerId the customer id
	 * @return the itinerary by customer id
	 */
	@GET
	@Path("/itinerary/{guest_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getItineraryByCustomerId(@PathParam("guest_ID") final Long customerId) {
		try {
			
			Itinerary itinerary = service.getItinerary(customerId);
			
			logger.info("Itinerary for" + customerId);
			
			return Response.status(200).entity(ResponseModel.getResponseStatus(ItineraryConstant.STATUS_CODE_200,
					ItineraryConstant.STATUS_RESPONSE_MESSAGE, itinerary)).build();
			
		} catch (Exception ex) {
			
			logger.error(ex);
			
			return Response.status(500).entity(ResponseModel.getResponseStatus(ItineraryConstant.STATUS_CODE_500,
					ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
		}

	}
}
