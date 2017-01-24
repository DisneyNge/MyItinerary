package com.itinerary.resort.service.resort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itinerary.resort.dao.IResortDao;
import com.itinerary.resort.model.DateConstant;
import com.itinerary.resort.model.ResortReservationModel;
import com.itinerary.resort.model.entity.ResortReservation;

/***
 * ResortServiceImpl CLASS.
 *
 * @author akuma408 Srevice layer
 */
@Transactional
@Service
public class ResortServiceImpl implements IResortService {
    /**
     * LOGGER.
     */
    static final Logger LOGGER = Logger.getLogger(ResortServiceImpl.class);

    /**
     * resortDao.
     */
    @Autowired
    private IResortDao resortDao;

    /**
     * @return resortDao
     */
    public final IResortDao getResortDao() {
        return resortDao;
    }

    /**
     * @param resortDao1
     *            resortDao1
     */
    public final void setResortDao(final IResortDao resortDao1) {
        this.resortDao = resortDao1;
    }

    /***
     * This method take the values from ResortReservationModel class, map with.
     * ResortReservation class and call the bookResortReservation dao class
     */
    @Transactional
    @Override
    public ResortReservationModel bookResortReservation(
           
            final ResortReservationModel model)throws Exception {
        LOGGER.info("inside webservice method");

        final ResortReservation resort = new ResortReservation();

        resort.setCustomerId(model.getGuestID());
        resort.setArrivalDate(DateConstant.getStringToDate(
                model.getCheckInDate()));
        resort.setDepartureDate(DateConstant.getStringToDate(
                model.getCheckoutDate()));
        resort.setPeople(model.getNoofguests());
        resort.setStatus("Booked");
        resort.setRoomType(model.getResortType());
        resort.setNoofnights(model.getNoofnights());
        resort.setCreateDate(new Date(System.currentTimeMillis()));
        resort.setUpdatedate(new Date(System.currentTimeMillis()));

        final Long customerId = resortDao.bookResortReservation(resort);
        model.setRreservationI(customerId);
        model.setStatus(resort.getStatus());
        /*
         * Long reservation_Id = resortDao.bookResortReservation(resort);
         * model.setReservation_Id(reservation_Id); model.setStatus();
         */
        return model;
    }

    /***
     * This method take the values from ResortReservation class, map with.
     * ResortReservationModel class and call the bookResortReservation of WS
     * class
     */
    @Transactional
    @Override
    public List<ResortReservationModel> provideResortReservation(
            final Long guestID) throws Exception {
        LOGGER.info("inside webservice method");
        List<ResortReservationModel> resortModellist = new
                ArrayList<ResortReservationModel>();
        List<ResortReservation> resort = resortDao.
                provideResortReservation(guestID);
        if (!resort.isEmpty()) {
            for (ResortReservation resortReservation : resort) {
                ResortReservationModel resortModel = new
                        ResortReservationModel();
                resortModel.setRreservationI(resortReservation.
                        getReservationId());
                resortModel.setGuestID(resortReservation.getCustomerId());
                resortModel.setResortType(resortReservation.getRoomType());
                resortModel.setCheckInDate(DateConstant.getDateToString(
                        resortReservation.getArrivalDate()));
                resortModel.setCheckoutDate(DateConstant.getDateToString(
                        resortReservation.getDepartureDate()));
                resortModel.setNoofguests(resortReservation.getPeople());
                resortModel.setStatus(resortReservation.getStatus());
                resortModel.setNoofnights(resortReservation.getNoofnights());

                resortModellist.add(resortModel);

            }}
            return resortModellist;

    }

    /***
     * This method take the guestId and reservationId and pass it into.
     * cancelResortReservation() method of DAO class
     */
    @Override
    public Long cancelResortReservation(final Long guestID,
            final Long reservationId) throws DataAccessException {
        LOGGER.info("inside webservice method");

        final Long updatedrow = resortDao.cancelResortReservation(
                guestID, reservationId);
        return updatedrow;
    }
}
