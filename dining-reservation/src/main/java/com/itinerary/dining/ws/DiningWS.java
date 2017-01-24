package com.itinerary.dining.ws;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.itinerary.dining.model.DiningReservationModel;
import com.itinerary.dining.model.ItineraryConstant;
import com.itinerary.dining.model.ResposeStatus;
import com.itinerary.dining.service.IDiningService;

/**
 * The Class DiningWS.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiningWS {

/** The Constant LOGGER. */
static final Logger LOGGER = Logger.getLogger(DiningWS.class);

/** The value 200. */
private final int value200 = 200;

/** The value 500. */
private final int value500 = 500;

/** The value 201. */
private final int value201 = 201;

/** The response model. */
private DiningReservationModel responseModel;

/** The dining service. */
@Autowired
private IDiningService diningService;

/**
 * Gets the dining service.
 *
 * @return the dining service
 */
public final IDiningService getDiningService() {
return diningService;
}

/**
 * Sets the dining service.
 *
 * @param diningService1 the new dining service
 */
public final void setDiningService(final IDiningService diningService1) {
this.diningService = diningService1;
}

/**
 * *
 * This is the POST method for Book reservation.
 *
 * @param model the model
 * @return the response
 */
@POST
@Path("/book_reservation")
public Response bookDiningReservation(final DiningReservationModel model) {
LOGGER.info("Inside create Guest Method");
try {

responseModel = diningService.bookDiningReservation(model);
return Response.status(value200).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_201,
ItineraryConstant.STATUS_SUCCESS, responseModel)).build();

} catch (Exception exception) {
LOGGER.error(exception);
return Response.status(value500).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_500,
ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
}
}

/**
 * *
 * This is the GET method to fetch Guest Dining reservation details.
 *
 * @param customerId the customer id
 * @return the response
 */
@GET
@Path("/dining-reservations/{guest_ID}")
public Response showDiningReservation(
@PathParam("guest_ID") final Long customerId) {
try {
List<DiningReservationModel> showDiningReservation =
diningService.provideDiningReservation(customerId);
return Response.status(value200).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_200,
ItineraryConstant.STATUS_RESPONSE_MESSAGE, showDiningReservation)).build();
} catch (Exception exception) {
LOGGER.error(exception);
return Response.status(value500).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_500,
ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
}
}

/**
 * *
 * This is the POST method to to cancel the dining reservation of the Guest.
 *
 * @param model the model
 * @return the response
 */
@POST
@Path("/cancel_reservation")
public Response cancelDiningBooking(
final DiningReservationModel model) {
try {
Long reservationId = diningService.cancelDiningReservation(
model.getGuestID(), model.getReservationID());
if (reservationId == 1) {
return Response.status(value201).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_200,
ItineraryConstant.STATUS_DELETE_MESSAGE, reservationId)).build();
} else {
return Response.status(value201).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_200,
ItineraryConstant.STATUS_INVALID_INPUT_PARAMETER, null)).build();
}

} catch (Exception exception) {
LOGGER.error(exception);
return Response.status(value500).entity(
ResposeStatus.getResponseStatus(ItineraryConstant.STATUS_CODE_500,
ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
}
}

}
