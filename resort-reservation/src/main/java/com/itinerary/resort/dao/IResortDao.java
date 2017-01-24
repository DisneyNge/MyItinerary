package com.itinerary.resort.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.itinerary.resort.model.entity.ResortReservation;

/***
 * interfaec for dao class.
 */
public interface IResortDao {
    /***
     * for logger.
     */
    Logger LOGGER = Logger.getLogger(IResortDao.class);

    /***
     * booking resort reservation.
     *
     * @param resort
     *            of reservation
     * @return generated valyue= customerId
     */
    Long bookResortReservation(ResortReservation resort);

    /***
     * for get reservations.
     *
     * @param guestID
     *            list of reservations
     * @return list of resrvations
     */
    List<ResortReservation> provideResortReservation(Long guestID);

    /***
     * cancel the reservation.
     *
     * @param reservationId
     *            reservationId
     * @param customerId
     *            customerId
     * @return return no of rows updated
     */
    Long cancelResortReservation(Long reservationId, Long customerId);
}
