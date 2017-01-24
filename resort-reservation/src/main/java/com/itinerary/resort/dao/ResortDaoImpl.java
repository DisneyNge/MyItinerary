package com.itinerary.resort.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itinerary.resort.model.entity.ResortReservation;

/***
 * ResortDaoImpl class. used for dao implemention.
 *
 * @author akuma408 implementing IResortDao
 */
@Repository
public class ResortDaoImpl implements IResortDao {
    /**
     * this is for logger.
     */
    static final Logger LOGGER = Logger.getLogger(ResortDaoImpl.class);
    /***
     * sessionfactory is autowired.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @return sessionFactory.
     */
    public final SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /***
     * @param sessionFactory1
     *            sessionFactory
     */
    public final void setSessionFactory(final SessionFactory sessionFactory1) {
        this.sessionFactory = sessionFactory1;
    }

    /***
     * @return long
     * @param resort
     */
    @Transactional
    @Override
    public Long bookResortReservation(final ResortReservation resort)
            throws DataAccessException {
        LOGGER.info("you are in saveDetail method of DAO class");
        try {
            return (Long) sessionFactory.getCurrentSession().save(resort);

        } catch (DataAccessException exception) {
            LOGGER.error(exception);
            throw exception;
        }
    }

    /***
     * This method provide the resortReservationDetail for a guest.
     */
    @Transactional
    @Override
    public List<ResortReservation> provideResortReservation(final Long guestID)
            throws DataAccessException {
        LOGGER.info("you are in getDetail method of DAO class"+guestID);
        try {
            List<ResortReservation> resortReservation = null;
            Query query = sessionFactory.getCurrentSession()
                    .createQuery("FROM ResortReservation where customerId"
                            + " =" + " :guestID");
            query.setLong("guestID", guestID);
            resortReservation = query.list();
            LOGGER.info("you are in getDetail method of DAO class");
                return resortReservation;
        } catch (DataAccessException exception) {
            LOGGER.error(exception);
            throw exception;
        }
    }

    /***
     * This method cancel the resortReservation and make the status as.
     *
     * @param customerId
     *            customerId
     * @param reservationId
     *            reservationId
     */
    @Transactional
    @Override
    public Long cancelResortReservation(final Long customerId,
            final Long reservationId)throws DataAccessException {
        LOGGER.info("inside webservice method");
        try {
            Query query = sessionFactory.getCurrentSession()
                    .createQuery("UPDATE ResortReservation set status"
                            + " = :status, "
            + "updatedate = :updatedate "
                            + "WHERE customerId = :customerId and"
            + " reservationId =" + " :reservationId");

            query.setString("status", "Cancelled");
            query.setLong("customerId", customerId);
            query.setLong("reservationId", reservationId);
            query.setDate("updatedate", new Date(System.currentTimeMillis()));
            int upadatedrow = query.executeUpdate();

            if (upadatedrow == 1) {
                return new Long(1);
            } else {
                return new Long(0);
            }
        } catch (DataAccessException exception) {
            exception.printStackTrace();
            LOGGER.error(exception);
            throw exception;
        }
    }
}
