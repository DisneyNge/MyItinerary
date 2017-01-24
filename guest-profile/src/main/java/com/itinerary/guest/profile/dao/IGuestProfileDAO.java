package com.itinerary.guest.profile.dao;

import com.itinerary.guest.profile.model.entity.EntityGuestprofile;

/**
 * IGuestProfileDAO.
 */
public interface IGuestProfileDAO {

    /**
     * @param newguest
     *            newguest
     * @return Long
     */
    Long createGuest(EntityGuestprofile newguest);

    /**
     * @param emailId
     *            emailId
     * @return boolean
     */
    boolean checkGuestExist(String emailId);

    /**
     * @param emailId
     *            emailId
     * @param password
     *            password
     * @return EntityGuestprofile
     */
    EntityGuestprofile validateGuest(String emailId, String password);

}
