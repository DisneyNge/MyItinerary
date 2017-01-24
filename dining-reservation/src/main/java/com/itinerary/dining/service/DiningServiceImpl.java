package com.itinerary.dining.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itinerary.dining.dao.IDiningDAO;
import com.itinerary.dining.model.DateConstant;
import com.itinerary.dining.model.DiningReservationModel;
import com.itinerary.dining.model.entity.DiningReservation;

/**
 * DiningServiceImpl.
 *
 */
@Service
public class DiningServiceImpl implements IDiningService {
	/**
	 * Logger.
	 **/
	static final Logger LOGGER = Logger.getLogger(DiningServiceImpl.class);

	/**
	 * @Autowired IDiningDAO
	 */
	@Autowired
	private IDiningDAO diningDAO;

	/**
	 * @return diningDAO
	 */
	public final IDiningDAO getDiningDAO() {
		return diningDAO;
	}

	/**
	 * @param diningDAO1
	 *            diningDAO1
	 */
	public final void setDiningDAO(final IDiningDAO diningDAO1) {
		diningDAO = diningDAO1;
	}

	/**
	 * @param model
	 *            model
	 * @throws Exception
	 *             Exception
	 */
	@Transactional
	@Override
	public DiningReservationModel bookDiningReservation(
			final DiningReservationModel model)throws Exception {
		DiningReservation dining = new DiningReservation();
		dining.setCustomerIdfinal(model.getGuestID());
		dining.setArrivalDate(DateConstant.getStringToDate(
				model.getDineIndate()));
//		dining.setArrivalTime(DateConstant.
//		getStringToDate(model.getDineIntime()));
		dining.setArrivalTime(
				model.getDineIntime());
//		dining.setArrivalTime(model.getDineIntime());
		dining.setDiningType(model.getDiningType());
		dining.setNoOfPeople(model.getNoOfGuests());
		dining.setStatus("Booked");
		dining.setCreatedDate(new Date(System.currentTimeMillis()));
		dining.setUpdatedDate(new Date(System.currentTimeMillis()));
		Long customerid = diningDAO.bookDiningReservation(dining);
		model.setReservationID(customerid);
		model.setStatus(dining.getStatus());
		return model;
	}
	/**
	 * @param customerId
	 *            customerId
	 *            @return showDiningReservation
	 * @throws Exception
	 *             Exception
	 */

	@Transactional
	@Override
	public List<DiningReservationModel> provideDiningReservation(
			final Long customerId)
					throws Exception {
		List<DiningReservation> diningReservation =
				diningDAO.provideDiningReservation(customerId);
		List<DiningReservationModel> showDiningReservation =
				new ArrayList<DiningReservationModel>();
		for (DiningReservation itr : diningReservation) {
			DiningReservationModel diningReservationModel =
					new DiningReservationModel();
			diningReservationModel.setReservationID(
					itr.getReservationId());
			diningReservationModel.setGuestID(
					itr.getCustomerId());
			diningReservationModel.setDiningType(
					itr.getDiningType());
			diningReservationModel.setDineIndate(DateConstant
					.getDateToString(itr.getArrivalDate()));
			diningReservationModel.setDineIntime(
					itr.getArrivalTime());
			diningReservationModel.setNoOfGuests(
					itr.getNoOfPeople());
			diningReservationModel.setStatus(itr.getStatus());

			showDiningReservation.add(diningReservationModel);

		}
		return showDiningReservation;
	}

	/**
	 *  * @param customerId
	 *            customerId
	 *    @param reservationId reservationId
	 *     *            @return diningDAO.cancelDiningReservation
	 * @throws Exception
	 *             Exception
	 */
	@Transactional
	@Override
	public Long cancelDiningReservation(
			final Long customerId, final Long reservationId)
					throws Exception {
		return diningDAO.cancelDiningReservation(
				customerId, reservationId);

	}

}
