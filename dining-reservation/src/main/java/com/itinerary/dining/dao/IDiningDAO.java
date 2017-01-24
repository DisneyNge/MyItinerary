package com.itinerary.dining.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.itinerary.dining.model.entity.DiningReservation;

/**
 * The Interface IDiningDAO.
 */
public interface IDiningDAO {

/**
 * Book dining reservation.
 *
 * @param dining the dining
 * @return the long
 * @throws DataAccessException the data access exception
 */
Long bookDiningReservation(DiningReservation dining) throws DataAccessException;

/**
 * Provide dining reservation.
 *
 * @param guestId the guest id
 * @return the list
 * @throws DataAccessException the data access exception
 */
List<DiningReservation> provideDiningReservation(
Long guestId) throws DataAccessException;

/**
 * Cancel dining reservation.
 *
 * @param customerId the customer id
 * @param reservationId the reservation id
 * @return the long
 * @throws DataAccessException the data access exception
 */
Long cancelDiningReservation(
Long customerId, Long reservationId) throws DataAccessException;
}
