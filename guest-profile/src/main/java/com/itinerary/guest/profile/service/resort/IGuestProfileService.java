package com.itinerary.guest.profile.service.resort;

import com.itinerary.guest.profile.model.Guestprofile;

/**
 * IGuestProfileService.
 */
public interface IGuestProfileService {

    /**
     * @param guestprofile
     *            guestprofile
     * @return Guestprofile
     * @throws Exception
     *             Exception
     */
    Guestprofile createguestprofile(Guestprofile guestprofile) throws Exception;

    /**
     * @param emailId1
     *            emailId1
     * @return Guestprofile
     * @throws Exception
     *             Exception
     */
    boolean checkGuestExist(String emailId1) throws Exception;

    /**
     * @param emailId1
     *            emailId1
     * @param password
     *            password
     * @return Guestprofile
     * @throws Exception
     *             Exception
     */
    Guestprofile validateGuest(String emailId1, String password)
            throws Exception;

}
