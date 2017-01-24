package com.itinerary.guest.profile.ws;

import org.easymock.EasyMock;
import org.junit.Test;

import com.itinerary.guest.profile.model.Guestprofile;
import com.itinerary.guest.profile.service.resort.GuestProfileServiceImpl;
import com.itinerary.guest.profile.service.resort.IGuestProfileService;

/**
 * GuestprofileWSTest.
 *
 */
public class GuestprofileWSTest {

    /**
     * @throws Exception
     *             Exception , createGuestTest
     */
    @Test
    public void createGuestTest() throws Exception {

        GuestprofileWS guestprofileWS = new GuestprofileWS();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        IGuestProfileService guestProfileService = EasyMock
                .createMock(GuestProfileServiceImpl.class);

        guestprofileWS.setGuestProfileService(guestProfileService);

        EasyMock.expect(guestprofile.getGuestemail()).andReturn("abc");

        EasyMock.expect(guestProfileService
                .checkGuestExist(EasyMock.anyObject(String.class)))
                .andReturn(true);

        EasyMock.replay(guestProfileService, guestprofile);

        guestprofileWS.createGuest(new Guestprofile());
    }

    /**
     * @throws Exception
     *             Exception, createGuestTest1
     */
    @Test
    public void createGuestTest1() throws Exception {

        GuestprofileWS guestprofileWS = new GuestprofileWS();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        IGuestProfileService guestProfileService = EasyMock
                .createMock(GuestProfileServiceImpl.class);

        guestprofileWS.setGuestProfileService(guestProfileService);

        EasyMock.expect(guestprofile.getGuestemail()).andReturn("abc");

        EasyMock.expect(guestProfileService
                .checkGuestExist(EasyMock.anyObject(String.class)))
                .andReturn(false);

        EasyMock.expect(guestProfileService.createguestprofile(guestprofile))
                .andReturn(guestprofile);

        EasyMock.replay(guestProfileService, guestprofile);

        guestprofileWS.createGuest(guestprofile);
    }

    /**
     * @throws Exception
     *             Exception ,createGuestTest2
     */
    @Test
    public void createGuestTest2() throws Exception {

        GuestprofileWS guestprofileWS = new GuestprofileWS();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        IGuestProfileService guestProfileService = EasyMock
                .createMock(GuestProfileServiceImpl.class);

        guestprofileWS.setGuestProfileService(guestProfileService);

        EasyMock.expect(guestprofile.getGuestemail()).andReturn("abc");

        EasyMock.expect(guestProfileService
                .checkGuestExist(EasyMock.anyObject(String.class)))
                .andThrow(new NullPointerException());

        EasyMock.expect(guestProfileService.createguestprofile(guestprofile))
                .andReturn(guestprofile);

        EasyMock.replay(guestProfileService, guestprofile);

        guestprofileWS.createGuest(guestprofile);
    }

    /**
     * @throws Exception
     *             Exception ,validateGuestProfileTest
     */
    @Test
    public void validateGuestProfileTest() throws Exception {

        GuestprofileWS guestprofileWS = new GuestprofileWS();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        IGuestProfileService guestProfileService = EasyMock
                .createMock(GuestProfileServiceImpl.class);

        guestprofileWS.setGuestProfileService(guestProfileService);

        EasyMock.expect(guestProfileService.validateGuest(
                EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(guestprofile);

        EasyMock.replay(guestProfileService, guestprofile);

        guestprofileWS.validateGuestProfile(new Guestprofile());
    }

    /**
     * @throws Exception
     *             Exception , validateGuestProfileTest1
     */
    @Test
    public void validateGuestProfileTest1() throws Exception {

        GuestprofileWS guestprofileWS = new GuestprofileWS();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        IGuestProfileService guestProfileService = EasyMock
                .createMock(GuestProfileServiceImpl.class);

        guestprofileWS.setGuestProfileService(guestProfileService);

        EasyMock.expect(guestProfileService.validateGuest(
                EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andReturn(null);

        EasyMock.replay(guestProfileService, guestprofile);

        guestprofileWS.validateGuestProfile(new Guestprofile());

    }

    /**
     * @throws Exception
     *             Exception, validateGuestProfileTest3
     */
    @Test
    public void validateGuestProfileTest3() throws Exception {

        GuestprofileWS guestprofileWS = new GuestprofileWS();

        Guestprofile guestprofile = EasyMock.createMock(Guestprofile.class);

        IGuestProfileService guestProfileService = EasyMock
                .createMock(GuestProfileServiceImpl.class);

        guestprofileWS.setGuestProfileService(guestProfileService);

        EasyMock.expect(guestProfileService.validateGuest(
                EasyMock.anyObject(String.class),
                EasyMock.anyObject(String.class))).andThrow(new Exception());

        EasyMock.replay(guestProfileService, guestprofile);

        guestprofileWS.validateGuestProfile(new Guestprofile());

    }
}
