package com.itinerary.guest.profile.service.resort;

import org.easymock.EasyMock;
import org.junit.Test;

import com.itinerary.guest.profile.dao.GuestProfileDAOImpl;
import com.itinerary.guest.profile.dao.IGuestProfileDAO;
import com.itinerary.guest.profile.model.Guestprofile;
import com.itinerary.guest.profile.model.entity.EntityGuestprofile;

/**
 * GuestProfileServiceImplTest.
 *
 */
public class GuestProfileServiceImplTest {

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void testCreateguestprofile() throws Exception {
        GuestProfileServiceImpl serviceimpl = new GuestProfileServiceImpl();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        EntityGuestprofile entityGuestprofile = EasyMock
                .createMock(EntityGuestprofile.class);

        IGuestProfileDAO iGuestProfileDAO = EasyMock
                .createMock(GuestProfileDAOImpl.class);

        serviceimpl.setGuestProfileDAO(iGuestProfileDAO);

        guestprofile.setGuestemail("abcd");
        guestprofile.setGuestaddress("abc");
        guestprofile.setGuestfirstname("hh");
        guestprofile.setGuestlastname("ghgh");
        guestprofile.setGuestpwd("12");
        guestprofile.setGuestphoneno("12345");

        EasyMock.expect(iGuestProfileDAO
                .createGuest((EasyMock.anyObject(EntityGuestprofile.class))))
                .andReturn(1L);

        EasyMock.replay(guestprofile, entityGuestprofile, iGuestProfileDAO);

        serviceimpl.createguestprofile(new Guestprofile());

    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void testcheckGuestExist() throws Exception {
        GuestProfileServiceImpl serviceimpl = new GuestProfileServiceImpl();
        IGuestProfileDAO iGuestProfileDAO = EasyMock
                .createMock(GuestProfileDAOImpl.class);
        serviceimpl.setGuestProfileDAO(iGuestProfileDAO);
        EasyMock.expect(iGuestProfileDAO
                .checkGuestExist((EasyMock.anyObject(String.class))))
                .andReturn(true);

        EasyMock.replay(iGuestProfileDAO);
        serviceimpl.checkGuestExist("abc");
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void testvalidateGuest() throws Exception {
        GuestProfileServiceImpl serviceimpl = new GuestProfileServiceImpl();
        EntityGuestprofile guestprofile = new EntityGuestprofile();
        guestprofile.setAddress("add");
        EntityGuestprofile entityGuestprofile = EasyMock
                .createMock(EntityGuestprofile.class);
        IGuestProfileDAO iGuestProfileDAO = EasyMock
                .createMock(GuestProfileDAOImpl.class);
        EasyMock.expect(
                iGuestProfileDAO.validateGuest(EasyMock.anyObject(String.class),
                        EasyMock.anyObject(String.class)))
                .andReturn(guestprofile);
        serviceimpl.setGuestProfileDAO(iGuestProfileDAO);
        EasyMock.replay(entityGuestprofile, iGuestProfileDAO);

        serviceimpl.validateGuest("abc", "abgd");

    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void testvalidateGuest1() throws Exception {
        GuestProfileServiceImpl serviceimpl = new GuestProfileServiceImpl();
        EntityGuestprofile guestprofile = null;
        EntityGuestprofile entityGuestprofile = EasyMock
                .createMock(EntityGuestprofile.class);
        IGuestProfileDAO iGuestProfileDAO = EasyMock
                .createMock(GuestProfileDAOImpl.class);
        EasyMock.expect(
                iGuestProfileDAO.validateGuest(EasyMock.anyObject(String.class),
                        EasyMock.anyObject(String.class)))
                .andReturn(guestprofile);
        serviceimpl.setGuestProfileDAO(iGuestProfileDAO);
        EasyMock.replay(entityGuestprofile, iGuestProfileDAO);

        serviceimpl.validateGuest("abc", "abgd");

    }
}
