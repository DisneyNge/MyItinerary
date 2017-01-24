package com.itinerary.resort.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.powermock.reflect.internal.WhiteboxImpl;
import org.springframework.dao.DataAccessException;

import com.itinerary.resort.model.entity.ResortReservation;
/**
 * TestResortDao test class.
 * @author akuma408
 *
 */
public class TestResortDao {

    /**
     * bookDiningReservationTest method of test class.
     */
    @Test
    public void bookDiningReservationTest() {
	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();
	ResortReservation resort = new ResortReservation();
	SessionFactory sessionFactory = EasyMock.createMock(
		SessionFactory.class);
	resortDaoImpl.setSessionFactory(sessionFactory);

	EasyMock.expect(sessionFactory.getCurrentSession()).andReturn(
		EasyMock.createMock(Session.class));

	EasyMock.replay(sessionFactory);

	resortDaoImpl.bookResortReservation(resort);

    }

    /**
     * bookDiningReservationTest test method.
     */
    @Test(expected = DataAccessException.class)
    public void bookResortReservationTest() {

	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();
	ResortReservation resort = new ResortReservation();
	SessionFactory sessionFactory = EasyMock.createMock(
		SessionFactory.class);
	resortDaoImpl.setSessionFactory(sessionFactory);

	EasyMock.expect(sessionFactory.getCurrentSession()).andThrow(
		EasyMock.createMock(DataAccessException.class));

	EasyMock.replay(sessionFactory);

	resortDaoImpl.bookResortReservation(resort);

    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void tetsprovideResortReservation() throws Exception {

	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();

	SessionFactory sessionFactory = PowerMock.createMock(
		SessionFactory.class);

	Session session = PowerMock.createMock(Session.class);

	Query queryMock = PowerMock.createMock(Query.class);

	resortDaoImpl.setSessionFactory(sessionFactory);

	PowerMock.expectPrivate(sessionFactory, "getCurrentSession").
	andReturn(session);

	PowerMock.expectPrivate(session, "createQuery", (""
		+ "FROM ResortReservation where customerId = :guestID"))
	.andReturn(queryMock);

	EasyMock.expect(queryMock.setLong("guestID", 1L)).
	andReturn(queryMock);

	PowerMock.expectPrivate(queryMock, "list").andReturn(
		EasyMock.createMock(List.class));

	PowerMock.replay(sessionFactory, session, queryMock);

	WhiteboxImpl.setInternalState(resortDaoImpl, ""
		+ "sessionFactory", sessionFactory);

	WhiteboxImpl.invokeMethod(resortDaoImpl, ""
		+ "provideResortReservation", 1L);

    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void tetsprovideResortReservation3() throws Exception {

	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();

	SessionFactory sessionFactory = PowerMock.
		createMock(SessionFactory.class);

	Session session = PowerMock.createMock(Session.class);

	Query queryMock = PowerMock.createMock(Query.class);

	resortDaoImpl.setSessionFactory(sessionFactory);

	PowerMock.expectPrivate(sessionFactory, "getCurrentSession").
	andReturn(session);

	PowerMock.expectPrivate(session, "createQuery", (""
		+ "FROM ResortReservation where customerId = :guestID"))
	.andReturn(queryMock);

	EasyMock.expect(queryMock.setLong("guestID", 1L)).andReturn(queryMock);

	List<ResortReservation> resortReservation = new ArrayList<>();
	PowerMock.expectPrivate(queryMock, "list").andReturn(resortReservation);

	PowerMock.replay(sessionFactory, session, queryMock);

	WhiteboxImpl.setInternalState(resortDaoImpl, ""
		+ "sessionFactory", sessionFactory);

	WhiteboxImpl.invokeMethod(resortDaoImpl, ""
		+ "provideResortReservation", 1L);

    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test(expected = DataAccessException.class)
    public void provideResortReservationTest1() throws Exception {

        ResortDaoImpl resortDaoImpl = new ResortDaoImpl();

        SessionFactory sessionFactory = PowerMock.
                createMock(SessionFactory.class);

        Session session = PowerMock.createMock(Session.class);

        Query queryMock = PowerMock.createMock(Query.class);

        resortDaoImpl.setSessionFactory(sessionFactory);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession").
        andReturn(session);

        PowerMock.expectPrivate(session, "createQuery", (""
        + "FROM ResortReservation where customerId = :guestID"))
                .andThrow(EasyMock.createMock(DataAccessException.class));

        PowerMock.replay(sessionFactory, session, queryMock);

        WhiteboxImpl.setInternalState(
                resortDaoImpl, "sessionFactory", sessionFactory);

        WhiteboxImpl.invokeMethod(
                resortDaoImpl, "" + "provideResortReservation", 1L);

    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void cancelResortReservationTest() throws Exception {

	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();

	SessionFactory sessionFactory = PowerMock.createMock(
		SessionFactory.class);

	Session session = PowerMock.createMock(Session.class);

	Query queryMock = PowerMock.createMock(Query.class);

	resortDaoImpl.setSessionFactory(sessionFactory);

	Date date = PowerMock.createMock(Date.class);

	PowerMock.expectPrivate(sessionFactory, "getCurrentSession").
	andReturn(session);

	PowerMock
	.expectPrivate(session, "createQuery",
		("UPDATE ResortReservation set status = :status, "
			+ "updatedate = :updatedate "
			+ "WHERE customerId = :customerId and reservationId ="
			+ " :reservationId"))
	.andReturn(queryMock);

	EasyMock.expect(queryMock.setString("status", "Cancelled")).
	andReturn(queryMock);

	EasyMock.expect(queryMock.setLong("customerId", 1L)).
	andReturn(queryMock);

	EasyMock.expect(queryMock.setLong("reservationId", 1L)).
	andReturn(queryMock);

	PowerMock.expectPrivate(System.class, "currentTimeMillis").
	andReturn(EasyMock.anyObject(Date.class));

	EasyMock.expect(queryMock.setDate("updatedDate",
		EasyMock.anyObject(Date.class))).andReturn(queryMock);

	EasyMock.expect(queryMock.executeUpdate()).andReturn(1);

	PowerMock.replay(sessionFactory, session, queryMock,
		date, System.class);

	WhiteboxImpl.setInternalState(resortDaoImpl,
		"sessionFactory", sessionFactory);

	WhiteboxImpl.invokeMethod(resortDaoImpl,
		"cancelResortReservation", 1L, 1L);

    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void cancelResortReservationTest2() throws Exception {

	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();

	SessionFactory sessionFactory = PowerMock.
		createMock(SessionFactory.class);

	Session session = PowerMock.createMock(Session.class);

	Query queryMock = PowerMock.createMock(Query.class);

	resortDaoImpl.setSessionFactory(sessionFactory);

	Date date = PowerMock.createMock(Date.class);

	PowerMock.expectPrivate(sessionFactory, "getCurrentSession").
	andReturn(session);

	PowerMock
	.expectPrivate(session, "createQuery",
		("UPDATE ResortReservation set status = :status, "
			+ "updatedate = :updatedate "
			+ "WHERE customerId = :customerId and reservationId ="
			+ " :reservationId"))
	.andReturn(queryMock);

	EasyMock.expect(queryMock.setString("status", "Cancelled")).
	andReturn(queryMock);

	EasyMock.expect(queryMock.setLong("customerId", 1L)).
	andReturn(queryMock);

	EasyMock.expect(queryMock.setLong("reservationId", 1L)).
	andReturn(queryMock);

	PowerMock.expectPrivate(System.class, "currentTimeMillis").
	andReturn(EasyMock.anyObject(Date.class));

	EasyMock.expect(queryMock.setDate("updatedDate", EasyMock.anyObject(
		Date.class))).andReturn(queryMock);


	EasyMock.expect(queryMock.executeUpdate()).andReturn(2);

	PowerMock.replay(sessionFactory, session, queryMock, date,
		System.class);

	WhiteboxImpl.setInternalState(resortDaoImpl, "sessionFactory",
		sessionFactory);

	resortDaoImpl.cancelResortReservation(1L, 1L);
    }

    /**
     * @throws Exception Exception
     */
    @Test(expected = DataAccessException.class)
    public void cancelResortReservationTest1() throws Exception {

	ResortDaoImpl resortDaoImpl = new ResortDaoImpl();

	SessionFactory sessionFactory = PowerMock.
		createMock(SessionFactory.class);

	Session session = PowerMock.createMock(Session.class);

	Query queryMock = PowerMock.createMock(Query.class);

	resortDaoImpl.setSessionFactory(sessionFactory);

	resortDaoImpl.getSessionFactory();

	Date date = PowerMock.createMock(Date.class);

	PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
	.andThrow(EasyMock.createMock(DataAccessException.class));

	PowerMock
	.expectPrivate(session, "createQuery",
		("UPDATE DiningReservation set status = :status, "
			+ "updatedDate = :updatedDate "
			+ "WHERE customerId = :customerId and reservationId ="
			+ " :reservationId"))
	.andThrow(EasyMock.createMock(DataAccessException.class));

	PowerMock.replay(sessionFactory, session, queryMock, date,
		System.class);

	WhiteboxImpl.setInternalState(resortDaoImpl, "sessionFactory",
		sessionFactory);

	resortDaoImpl.cancelResortReservation(1L, 1L);

    }

}


