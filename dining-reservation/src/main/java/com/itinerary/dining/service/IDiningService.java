package com.itinerary.dining.service;

import java.util.List;

import com.itinerary.dining.model.DiningReservationModel;

/**
 * The Interface IDiningService.
 */

public interface IDiningService {

	/**
	 * Book dining reservation.
	 *
	 * @param model
	 *            the model
	 * @return the dining reservation model
	 * @throws Exception
	 *             the exception
	 */
	DiningReservationModel bookDiningReservation(
			DiningReservationModel model) throws Exception;

	/**
	 * Provide dining reservation.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	List<DiningReservationModel> provideDiningReservation(
			Long guestId) throws Exception;

	/**
	 * Cancel dining reservation.
	 *
	 * @param customerId
	 *            the customer id
	 * @param reservationId
	 *            the reservation id
	 * @return the long
	 * @throws Exception
	 *             the exception
	 */
	Long cancelDiningReservation(Long customerId,
			Long reservationId) throws Exception;
}
