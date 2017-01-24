package com.itinerary.dining.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.itinerary.dining.model.entity.DiningReservation;

/**
 * The Class DiningDAOImpl.
 */
public class DiningDAOImpl implements IDiningDAO {

/** The Constant logger. */
static final Logger LOGGER = Logger.getLogger(DiningDAOImpl.class);

/** The session factory. */
@Autowired
private  SessionFactory sessionFactory;

/**
* Gets the session factory.
*
* @return the session factory
*/
public final SessionFactory getSessionFactory() {
return sessionFactory;
}

/**
 * Sets the session factory.
 *
 * @param sessionFactory1 the new session factory
 */
public final void setSessionFactory(final SessionFactory sessionFactory1) {
this.sessionFactory = sessionFactory1;
}

/**
* *
* This method book dining reservation and returns the end point.
*
* @param dining the dining
* @return the long
* @throws DataAccessException the data access exception
*/
@Override
public Long bookDiningReservation(
final DiningReservation dining) throws DataAccessException {
LOGGER.info("");
try {
Long reservationId1 = (Long) sessionFactory.getCurrentSession().save(dining);
return reservationId1;
} catch (DataAccessException exception) {
LOGGER.error(exception);
throw exception;
}

}

/**
* *
* This method provide the DiningReservation of the guest.
*
* @param customerId the customer id
* @return the list
*/
@Override
public List<DiningReservation> provideDiningReservation(final Long customerId) {
LOGGER.info("");
try {

Query query = sessionFactory.getCurrentSession()
.createQuery("FROM DiningReservation where customerId = :customerId");
query.setLong("customerId", customerId);
List<DiningReservation> diningReservation = query.list();
return diningReservation;
} catch (DataAccessException exception) {
LOGGER.error(exception);
throw exception;
}
}

/**
* *
* This method will cancel the Dining Reservation and change the status in
* CANCELLED.
*
* @param customerId the customer id
* @param reservationId1 the reservation id
* @return the long
* @throws DataAccessException the data access exception
*/
@Override
public Long cancelDiningReservation(
final Long customerId, final Long reservationId1)
throws DataAccessException {
LOGGER.info("");
try {
Query query = sessionFactory.getCurrentSession().createQuery(
"UPDATE DiningReservation set status = "
+ ":status, " + "updatedDate = :updatedDate "
+ "WHERE customerId = :customerId and reservationId = :reservationId");
query.setString("status", "Cancelled");
query.setLong("customerId", customerId);
query.setLong("reservationId", reservationId1);
query.setDate("updatedDate", new Date(System.currentTimeMillis()));
int upadatedrow = query.executeUpdate();
if (upadatedrow == 1) {
return new Long(1);
} else {
return new Long(0);
}

} catch (DataAccessException exception) {
LOGGER.error(exception);
throw exception;

}
}

}
