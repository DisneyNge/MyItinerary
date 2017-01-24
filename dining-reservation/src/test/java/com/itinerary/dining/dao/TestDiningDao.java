package com.itinerary.dining.dao;

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

import com.itinerary.dining.model.entity.DiningReservation;

public class TestDiningDao {

	@Test
	public void bookDiningReservationTest() {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		DiningReservation dining = new DiningReservation();

		SessionFactory sessionFactory = EasyMock.createMock(SessionFactory.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		EasyMock.expect(sessionFactory.getCurrentSession()).andReturn(EasyMock.createMock(Session.class));

		EasyMock.replay(sessionFactory);

		diningDAOImpl.bookDiningReservation(dining);

	}

	@Test(expected = DataAccessException.class)
	public void bookDiningReservationTest1() {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		DiningReservation dining = new DiningReservation();

		SessionFactory sessionFactory = EasyMock.createMock(SessionFactory.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		EasyMock.expect(sessionFactory.getCurrentSession()).andThrow(EasyMock.createMock(DataAccessException.class));

		EasyMock.replay(sessionFactory);

		diningDAOImpl.bookDiningReservation(dining);

	}

	@Test
	public void provideDiningReservationTest() throws Exception {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		SessionFactory sessionFactory = PowerMock.createMock(SessionFactory.class);

		Session session = PowerMock.createMock(Session.class);

		Query queryMock = PowerMock.createMock(Query.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		PowerMock.expectPrivate(sessionFactory, "getCurrentSession").andReturn(session);

		PowerMock.expectPrivate(session, "createQuery", ("FROM DiningReservation where customerId = :customerId"))
				.andReturn(queryMock);

		EasyMock.expect(queryMock.setLong("customerId", 1l)).andReturn(queryMock);

		PowerMock.expectPrivate(queryMock, "list").andReturn(EasyMock.createMock(List.class));

		PowerMock.replay(sessionFactory, session, queryMock);

		WhiteboxImpl.setInternalState(diningDAOImpl, "sessionFactory", sessionFactory);

		WhiteboxImpl.invokeMethod(diningDAOImpl, "provideDiningReservation", 1l);

	}

	@Test(expected = DataAccessException.class)
	public void provideDiningReservationTest1() throws Exception {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		SessionFactory sessionFactory = PowerMock.createMock(SessionFactory.class);

		Session session = PowerMock.createMock(Session.class);

		Query queryMock = PowerMock.createMock(Query.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		PowerMock.expectPrivate(sessionFactory, "getCurrentSession").andReturn(session);

		PowerMock.expectPrivate(session, "createQuery", ("FROM DiningReservation where customerId = :customerId"))
				.andThrow(EasyMock.createMock(DataAccessException.class));

		PowerMock.replay(sessionFactory, session, queryMock);

		WhiteboxImpl.setInternalState(diningDAOImpl, "sessionFactory", sessionFactory);

		WhiteboxImpl.invokeMethod(diningDAOImpl, "provideDiningReservation", 1l);

	}

	@Test
	public void cancelDiningReservationTest() throws Exception {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		SessionFactory sessionFactory = PowerMock.createMock(SessionFactory.class);

		Session session = PowerMock.createMock(Session.class);

		Query queryMock = PowerMock.createMock(Query.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		Date date = PowerMock.createMock(Date.class);

		PowerMock.expectPrivate(sessionFactory, "getCurrentSession").andReturn(session);

		PowerMock
				.expectPrivate(session, "createQuery",
						("UPDATE DiningReservation set status = :status, " + "updatedDate = :updatedDate "
								+ "WHERE customerId = :customerId and reservationId = :reservationId"))
				.andReturn(queryMock);

		EasyMock.expect(queryMock.setString("status", "Cancelled")).andReturn(queryMock);

		EasyMock.expect(queryMock.setLong("customerId", 1l)).andReturn(queryMock);

		EasyMock.expect(queryMock.setLong("reservationId", 1l)).andReturn(queryMock);

		PowerMock.expectPrivate(System.class, "currentTimeMillis").andReturn(EasyMock.anyObject(Date.class));

		EasyMock.expect(queryMock.setDate("updatedDate", EasyMock.anyObject(Date.class))).andReturn(queryMock);

		EasyMock.expect(queryMock.executeUpdate()).andReturn(1);

		PowerMock.replay(sessionFactory, session, queryMock, date, System.class);

		WhiteboxImpl.setInternalState(diningDAOImpl, "sessionFactory", sessionFactory);

		WhiteboxImpl.invokeMethod(diningDAOImpl, "cancelDiningReservation", 1l, 1l);

	}

	@Test
	public void cancelDiningReservationTest2() throws Exception {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		SessionFactory sessionFactory = PowerMock.createMock(SessionFactory.class);

		Session session = PowerMock.createMock(Session.class);

		Query queryMock = PowerMock.createMock(Query.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		Date date = PowerMock.createMock(Date.class);

		PowerMock.expectPrivate(sessionFactory, "getCurrentSession").andReturn(session);

		PowerMock
				.expectPrivate(session, "createQuery",
						("UPDATE DiningReservation set status = :status, " + "updatedDate = :updatedDate "
								+ "WHERE customerId = :customerId and reservationId = :reservationId"))
				.andReturn(queryMock);

		EasyMock.expect(queryMock.setString("status", "Cancelled")).andReturn(queryMock);

		EasyMock.expect(queryMock.setLong("customerId", 1l)).andReturn(queryMock);

		EasyMock.expect(queryMock.setLong("reservationId", 1l)).andReturn(queryMock);

		PowerMock.expectPrivate(System.class, "currentTimeMillis").andReturn(EasyMock.anyObject(Date.class));

		EasyMock.expect(queryMock.setDate("updatedDate", EasyMock.anyObject(Date.class))).andReturn(queryMock);

		EasyMock.expect(queryMock.executeUpdate()).andReturn(2);

		PowerMock.replay(sessionFactory, session, queryMock, date, System.class);

		WhiteboxImpl.setInternalState(diningDAOImpl, "sessionFactory", sessionFactory);

		diningDAOImpl.cancelDiningReservation(1l, 1l);
	}

	@Test(expected = DataAccessException.class)
	public void cancelDiningReservationTest1() throws Exception {

		DiningDAOImpl diningDAOImpl = new DiningDAOImpl();

		SessionFactory sessionFactory = PowerMock.createMock(SessionFactory.class);

		Session session = PowerMock.createMock(Session.class);

		Query queryMock = PowerMock.createMock(Query.class);

		diningDAOImpl.setSessionFactory(sessionFactory);

		diningDAOImpl.getSessionFactory();

		Date date = PowerMock.createMock(Date.class);

		PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
				.andThrow(EasyMock.createMock(DataAccessException.class));

		PowerMock
				.expectPrivate(session, "createQuery",
						("UPDATE DiningReservation set status = :status, " + "updatedDate = :updatedDate "
								+ "WHERE customerId = :customerId and reservationId = :reservationId"))
				.andThrow(EasyMock.createMock(DataAccessException.class));

		PowerMock.replay(sessionFactory, session, queryMock, date, System.class);

		WhiteboxImpl.setInternalState(diningDAOImpl, "sessionFactory", sessionFactory);

		diningDAOImpl.cancelDiningReservation(1l, 1l);

	}

}
