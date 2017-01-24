package com.itinerary.guest.profile.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.itinerary.guest.profile.model.entity.EntityGuestprofile;

/**
 * GuestProfileDAOImpl.
 */
public class GuestProfileDAOImpl implements IGuestProfileDAO {

    /**
     * Logger.
     */
    static final Logger LOGGER = Logger.getLogger(GuestProfileDAOImpl.class);

    /**
     * @Autowired
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @return sessionFactory
     */
    public final SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory1
     *            **this is sessionFactory1 **
     */
    public final void setSessionFactory(final SessionFactory sessionFactory1) {
        sessionFactory = sessionFactory1;
    }

    /**
     * @param newguest
     *            **this is newguest ** * @return sessionFactory. this is method
     *            for guestID.
     * @throws DataAccessException
     *             DataAccessException
     */

    @Override
    public Long createGuest(final EntityGuestprofile newguest)
            throws DataAccessException {
        LOGGER.info("Inside create Guest Method");

        try {

            Long guestID = (Long) sessionFactory.getCurrentSession()
                    .save(newguest);

            return guestID;

        } catch (DataAccessException daoEx) {

            LOGGER.error(daoEx);

            throw daoEx;
        }
    }

    /**
     * @param emailId
     *            **this is emailId ** * @return sessionFactory
     * @throws DataAccessException
     *             DataAccessException
     */

    @Override
    public boolean checkGuestExist(final String emailId)
            throws DataAccessException {

        LOGGER.info("Inside check Guest Method");

        boolean isGuestExist = false;

        try {

            Query query = sessionFactory.getCurrentSession().createQuery(
                    "FROM EntityGuestprofile WHERE emailId = :emailId ");

            query.setString("emailId", emailId);

            List<EntityGuestprofile> guestlist = query.list();

            if (!guestlist.isEmpty()) {

                isGuestExist = true;
            }
        } catch (DataAccessException daoEx) {

            LOGGER.error(daoEx);

            throw (daoEx);
        }
        return isGuestExist;
    }

    /**
     * @param emailId
     *            **this is emailId **
     * @param password
     *            **this is password **
     * @return sessionFactory
     * @throws DataAccessException
     *             DataAccessException
     */
    @Override
    public EntityGuestprofile validateGuest(final String emailId,
            final String password) throws DataAccessException {

        LOGGER.info("Inside validate Guest Method");

        EntityGuestprofile entityGuestprofile = null;

        try {

            Query query = sessionFactory.getCurrentSession()
                    .createQuery("FROM EntityGuestprofile WHERE emailId = "
                            + ":emailId and password = :password ");

            query.setString("emailId", emailId);

            query.setString("password", password);

            List<EntityGuestprofile> guestlist = query.list();

            if (!guestlist.isEmpty()) {

                entityGuestprofile = guestlist.get(0);
            }
        } catch (DataAccessException daoEx) {

            LOGGER.error(daoEx);

            throw (daoEx);
        }
        return entityGuestprofile;
    }
}
