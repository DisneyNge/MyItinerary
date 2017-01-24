package com.itinerary.resort.service.resort;

import java.util.List;

import javax.ws.rs.Path;

import org.apache.log4j.Logger;

import com.itinerary.resort.model.ResortReservationModel;

/***
 * IResortService.
 *
 * @author akuma408
 */
@Path("/resort")
public interface IResortService {
    /**
     * iresortService Interface.
     */
    Logger LOGGER = Logger.getLogger(IResortService.class);

    /**
     * @param model
     *            model
     * @return ResortReservationModel
     * @throws Exception
     *             Exception
     */
    ResortReservationModel bookResortReservation(
            ResortReservationModel model) throws Exception;

    /**
     * @param guestID
     *            guestId
     * @return ResortReservationModel
     * @throws Exception
     *             Exception
     */
    List<ResortReservationModel> provideResortReservation(
            Long guestID) throws Exception;

    /**
     * @param guestID
     *            guestID
     * @param reservationId
     *            reservationId
     * @return Long
     * @throws Exception
     *             Exception
     */
    Long cancelResortReservation(Long guestID,
            Long reservationId) throws Exception;
}
