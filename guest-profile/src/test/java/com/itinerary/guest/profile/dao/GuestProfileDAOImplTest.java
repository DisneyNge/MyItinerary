package com.itinerary.guest.profile.dao;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.springframework.dao.DataAccessException;

import com.itinerary.guest.profile.model.entity.EntityGuestprofile;

/**
 * GuestProfileDAOImplTest.
 *
 */
public class GuestProfileDAOImplTest {

    /**
     * createGuesttest.
     */
    @Test
    public void createGuesttest() {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();
        Session sess = EasyMock.createMock(Session.class);

        EasyMock.expect(sessionFactory.getCurrentSession()).andReturn(sess);

        EasyMock.expect(sess.save(EasyMock.anyObject(EntityGuestprofile.class)))
                .andReturn(1L);

        EasyMock.replay(sessionFactory);

        guestProfileDAOImpl.createGuest(entityGuestprofile);
    }

    /**
     * createGuesttest1.
     */
    @Test(expected = DataAccessException.class)
    public void createGuesttest1() {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();
        Session sess = EasyMock.createMock(Session.class);

        EasyMock.expect(sessionFactory.getCurrentSession())
                .andThrow(EasyMock.createMock(DataAccessException.class));

        EasyMock.expect(sess.save(EasyMock.anyObject(EntityGuestprofile.class)))
                .andReturn(1L);

        EasyMock.replay(sessionFactory);

        guestProfileDAOImpl.createGuest(entityGuestprofile);
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void checkGuestExisttest() throws Exception {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();

        Session sess = EasyMock.createMock(Session.class);

        Query query = EasyMock.createMock(Query.class);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
                .andReturn(sess);

        PowerMock
                .expectPrivate(sess, "createQuery",
                        EasyMock.anyObject(EntityGuestprofile.class))
                .andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        List<EntityGuestprofile> guestlist = new ArrayList<>();

        entityGuestprofile.setAddress("abc");

        guestlist.add(entityGuestprofile);

        EasyMock.expect(query.list()).andReturn(guestlist);

        EasyMock.replay(sessionFactory, sess, query);

        guestProfileDAOImpl.checkGuestExist("hh");
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void checkGuestExisttest1() throws Exception {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();

        Session sess = EasyMock.createMock(Session.class);

        Query query = EasyMock.createMock(Query.class);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
                .andReturn(sess);

        PowerMock
                .expectPrivate(sess, "createQuery",
                        EasyMock.anyObject(EntityGuestprofile.class))
                .andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        List<EntityGuestprofile> guestlist = new ArrayList<>();

        EasyMock.expect(query.list()).andReturn(guestlist);

        EasyMock.replay(sessionFactory, sess, query);

        guestProfileDAOImpl.checkGuestExist("hh");
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test(expected = DataAccessException.class)
    public void checkGuestExisttest2() throws Exception {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();

        Session sess = EasyMock.createMock(Session.class);

        Query query = EasyMock.createMock(Query.class);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
                .andThrow(EasyMock.createMock(DataAccessException.class));

        PowerMock
                .expectPrivate(sess, "createQuery",
                        EasyMock.anyObject(EntityGuestprofile.class))
                .andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        List<EntityGuestprofile> guestlist = new ArrayList<>();

        entityGuestprofile.setAddress("abc");

        EasyMock.expect(query.list()).andReturn(guestlist);

        guestlist.add(entityGuestprofile);

        EasyMock.replay(sessionFactory, sess, query);

        guestProfileDAOImpl.checkGuestExist("hh");
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void validateGuesttest() throws Exception {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();

        Session sess = EasyMock.createMock(Session.class);

        Query query = EasyMock.createMock(Query.class);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
                .andReturn(sess);

        PowerMock
                .expectPrivate(sess, "createQuery",
                        EasyMock.anyObject(EntityGuestprofile.class))
                .andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        List<EntityGuestprofile> guestlist = new ArrayList<>();

        EasyMock.expect(query.list()).andReturn(guestlist);

        entityGuestprofile.setAddress("abc");

        guestlist.add(entityGuestprofile);

        EasyMock.replay(sessionFactory, sess, query);

        guestProfileDAOImpl.validateGuest("hh", "yyy");
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void validateGuesttest1() throws Exception {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();

        Session sess = EasyMock.createMock(Session.class);

        Query query = EasyMock.createMock(Query.class);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
                .andReturn(sess);

        PowerMock
                .expectPrivate(sess, "createQuery",
                        EasyMock.anyObject(EntityGuestprofile.class))
                .andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        List<EntityGuestprofile> guestlist = new ArrayList<>();

        EasyMock.expect(query.list()).andReturn(guestlist);

        EasyMock.replay(sessionFactory, sess, query);

        guestProfileDAOImpl.validateGuest("hh", "yyy");
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test(expected = DataAccessException.class)
    public void validateGuesttest2() throws Exception {

        GuestProfileDAOImpl guestProfileDAOImpl = new GuestProfileDAOImpl();

        SessionFactory sessionFactory = EasyMock
                .createMock(SessionFactory.class);

        guestProfileDAOImpl.setSessionFactory(sessionFactory);

        EntityGuestprofile entityGuestprofile = new EntityGuestprofile();

        Session sess = EasyMock.createMock(Session.class);

        Query query = EasyMock.createMock(Query.class);

        PowerMock.expectPrivate(sessionFactory, "getCurrentSession")
                .andThrow(EasyMock.createMock(DataAccessException.class));

        PowerMock
                .expectPrivate(sess, "createQuery",
                        EasyMock.anyObject(EntityGuestprofile.class))
                .andReturn(query);

        EasyMock.expect(query.setString(EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(query);

        List<EntityGuestprofile> guestlist = new ArrayList<>();

        EasyMock.expect(query.list()).andReturn(guestlist);

        entityGuestprofile.setAddress("abc");

        guestlist.add(entityGuestprofile);

        EasyMock.replay(sessionFactory, sess, query);

        guestProfileDAOImpl.validateGuest("abc", "php");
    }

}
