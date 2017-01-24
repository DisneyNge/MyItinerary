package com.itinerary.guest.profile.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.itinerary.guest.profile.model.Guestprofile;
import com.itinerary.guest.profile.model.ItineraryConstant;
import com.itinerary.guest.profile.model.ResponseStatus;
import com.itinerary.guest.profile.service.resort.IGuestProfileService;

/**
 * GuestprofileWS.
 *
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GuestprofileWS {

    /**
     * Logger.
     */
    static final Logger LOGGER = Logger.getLogger(GuestprofileWS.class);
    /**
     * Autowired IGuestProfileService.
     */
    @Autowired
    private IGuestProfileService guestProfileService;

    /**
     * @return guestProfileService
     */
    public final IGuestProfileService getGuestProfileService() {
        return guestProfileService;
    }

    /**
     * @param guestProfileService1
     *            guestProfileService1
     */
    public final void setGuestProfileService(
            final IGuestProfileService guestProfileService1) {
        guestProfileService = guestProfileService1;
    }

    /**
     * @param guestprofile
     *            guestprofile
     * @return Response
     */
    @POST
    @Path("/createguest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGuest(final Guestprofile guestprofile) {
        LOGGER.info("Inside createGuest  Method");
        final int value = 201;
        final int value1 = 403;
        final int value2 = 500;
        try {
            boolean isGuestExist = guestProfileService
                    .checkGuestExist(guestprofile.getGuestemail());
            if (!isGuestExist) {
                Guestprofile modelObj = guestProfileService
                        .createguestprofile(guestprofile);
                return Response.status(value)
                        .entity(ResponseStatus.getResponseStatus(
                                ItineraryConstant.STATUS_CODE_201,
                                ItineraryConstant.STATUS_ADDED_USER, modelObj))
                        .build();
            } else {
                return Response.status(value1)
                        .entity(ResponseStatus.getResponseStatus(
                                ItineraryConstant.STATUS_CODE_403,
                                ItineraryConstant.STATUS_INVALID_OR_EXIST_USER,
                                null))
                        .build();
            }
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(value2)
                    .entity(ResponseStatus.getResponseStatus(
                            ItineraryConstant.STATUS_CODE_500,
                            ItineraryConstant.STATUS_ERROR, null))
                    .build();
        }
    }

    /**
     * @param guestprofile
     *            guestprofile
     * @return Response
     */
    @POST
    @Path("/validateguest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateGuestProfile(final Guestprofile guestprofile) {
        LOGGER.info("Inside validate Guest Profile Method");
        final int value = 200;
        final int value1 = 403;
        final int value2 = 500;
        try {
            Guestprofile guestprofile1 = guestProfileService.validateGuest(
                    guestprofile.getGuestemail(), guestprofile.getGuestpwd());
            if (!(guestprofile1 == null)) {

                return Response.status(value)
                        .entity(ResponseStatus.getResponseStatus(
                                ItineraryConstant.STATUS_CODE_200,
                                ItineraryConstant.STATUS_SUCCESS,
                                guestprofile1))
                        .build();
            } else {
                return Response.status(value1)
                        .entity(ResponseStatus.getResponseStatus(
                                ItineraryConstant.STATUS_CODE_403,
                                ItineraryConstant.STATUS_INVALID_USER, null))
                        .build();
            }
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(value2)
                    .entity(ResponseStatus.getResponseStatus(
                            ItineraryConstant.STATUS_CODE_500,
                            ItineraryConstant.STATUS_ERROR, null))
                    .build();
        }

    }

}
