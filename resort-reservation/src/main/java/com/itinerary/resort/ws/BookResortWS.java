package com.itinerary.resort.ws;

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
import org.springframework.stereotype.Component;

import com.itinerary.resort.model.ItineraryConstant;
import com.itinerary.resort.model.ResortReservationModel;
import com.itinerary.resort.model.ResponseStatus;
import com.itinerary.resort.service.resort.IResortService;

/**
 * BookResortWS class. starting.
 * class
 * @author akuma408
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component
public class BookResortWS {
    /**
     * code500.
     */
    private final Integer code500 = 500;
    /**
     * code200.
     */
    private final Integer code200 = 200;
    /**
     * code201.
     */
    private final Integer code201 = 201;
    /**
     * LOGGER.
     */
    static final Logger LOGGER = Logger.getLogger(BookResortWS.class);

    /**
     * resortservice autowired.
     */
    @Autowired
    private IResortService resortservice;

    /**
     * @return resortservice
     */
    public final IResortService getResortservice() {
        return resortservice;
    }

    /**
     * @param resortservice1
     *            resortservice1
     */
    public final void setResortservice(final IResortService resortservice1) {
        this.resortservice = resortservice1;
    }

    /**
     * @param model
     *            model
     * @return Response
     */
    @POST
    @Path("/book-reservation/")
    public Response bookResortReservation(final ResortReservationModel model) {
        LOGGER.info("inside webservice method");
        ResortReservationModel responceModel = null;
        try {
            responceModel = resortservice.bookResortReservation(model);
            return Response.status(code201).entity(ResponseStatus.
                    getResponseStatus(ItineraryConstant.STATUS_CODE_201,
                    ItineraryConstant.STATUS_SUCCESS, responceModel)).build();

        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(code500).entity(ResponseStatus.
                    getResponseStatus(ItineraryConstant.STATUS_CODE_500,
                    ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
        }

    }

    /**
     * @param guestID
     *            guestID
     * @return Response
     */
    @GET
    @Path("/resort-reservations/{guest_ID}/")
    public Response provideReservation(@PathParam("guest_ID")
    final Long guestID) {
        LOGGER.info("inside webservice method");
        try {
            List<ResortReservationModel> resortModel =
                    resortservice.provideResortReservation(guestID);

            if (resortModel != null && !resortModel.isEmpty()) {
                return Response.status(code200)
                        .entity(ResponseStatus.
                                getResponseStatus(
                                        ItineraryConstant.STATUS_CODE_200,
                                ItineraryConstant.
                                STATUS_RESPONSE_MESSAGE, resortModel)).build();
            } else {
                return Response.status(code201)
                        .entity(ResponseStatus.
                                getResponseStatus(ItineraryConstant.
                                        STATUS_CODE_400, ItineraryConstant.
                                STATUS_NO_RESERVATION, resortModel))
                        .build();
            }
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(code500).entity(ResponseStatus.
                    getResponseStatus(ItineraryConstant.STATUS_CODE_500,
                    ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
        }
    }

    /***
     * this method take the guestId and reservationId and send it to service.
     * layer for delete operation for cancel
     * cancel
     * @param model
     *            model
     * @return Response
     */
    @POST
    @Path("/cancel-reservation/")
    public Response cancelResort(final ResortReservationModel model) {
        LOGGER.info("inside webservice method");
        try {
            Long updatedrow = resortservice.cancelResortReservation(
                    model.getGuestID(),
                    model.getReservationId());
            if (updatedrow == 1) {
                return Response.status(code201)
                        .entity(ResponseStatus.getResponseStatus(
                                ItineraryConstant.STATUS_CODE_201,
                                ItineraryConstant.STATUS_DELETE_MESSAGE,
                                updatedrow))
                        .build();
            } else {
                return Response.status(code201)
                        .entity(ResponseStatus.getResponseStatus(
                                ItineraryConstant.STATUS_CODE_400,
                                ItineraryConstant.
                                STATUS_INVALID_INPUT_PARAMETER,
                                null)).build();
            }
        } catch (Exception exception) {
            LOGGER.error(exception);
            return Response.status(code500).entity(ResponseStatus.
                    getResponseStatus(
                    ItineraryConstant.STATUS_CODE_500,
                    ItineraryConstant.STATUS_SERVER_ERROR, null)).build();
        }
    }
}
