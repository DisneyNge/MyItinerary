package com.itinerary.guest.profile.service.resort;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itinerary.guest.profile.dao.IGuestProfileDAO;
import com.itinerary.guest.profile.model.Guestprofile;
import com.itinerary.guest.profile.model.entity.EntityGuestprofile;

/**
 * @author nadubey GuestProfileServiceImpl.
 *
 */
@Service
public class GuestProfileServiceImpl implements IGuestProfileService {

    /**
     * Logger.
     */
    static final Logger LOGGER = Logger
            .getLogger(GuestProfileServiceImpl.class);

    /**
     * Autowired IGuestProfileDAO.
     */
    @Autowired
    private IGuestProfileDAO guestProfileDAO;

    /**
     * @return guestProfileDAO
     */
    public final IGuestProfileDAO getGuestProfileDAO() {
        return guestProfileDAO;
    }

    /**
     * @param guestProfileDAO1
     *            guestProfileDAO1
     */
    public final void setGuestProfileDAO(
            final IGuestProfileDAO guestProfileDAO1) {
        guestProfileDAO = guestProfileDAO1;
    }

    /**
     * @param guestprofile
     *            guestprofile
     * @throws Exception
     *             Exception
     */
    @Transactional
    @Override
    public Guestprofile createguestprofile(final Guestprofile guestprofile)
            throws Exception {

        EntityGuestprofile newguest = new EntityGuestprofile();

        newguest.setEmailId(guestprofile.getGuestemail());
        newguest.setFirstname(guestprofile.getGuestfirstname());
        newguest.setLastname(guestprofile.getGuestlastname());
        newguest.setAddress(guestprofile.getGuestaddress());
        newguest.setPhone(guestprofile.getGuestphoneno());
        newguest.setPassword(guestprofile.getGuestpwd());
        newguest.setCreateddate(new Date(System.currentTimeMillis()));
        newguest.setUpdateddate(new Date(System.currentTimeMillis()));
        guestprofile.setGuestID(guestProfileDAO.createGuest(newguest));
        return guestprofile;
    }

    /**
     * @param emailId
     *            emailId
     * @return bl
     * @throws Exception
     *             Exception
     */
    @Transactional
    @Override
    public boolean checkGuestExist(final String emailId) throws Exception {
        boolean bl = guestProfileDAO.checkGuestExist(emailId);
        return bl;
    }

    /**
     * @param emailId
     *            emailId
     * @param password
     *            password
     * @return null
     * @throws Exception
     *             Exception
     */
    @Transactional
    @Override
    public Guestprofile validateGuest(final String emailId,
            final String password) throws Exception {

        Guestprofile guestprofile = new Guestprofile();
        EntityGuestprofile entityGuestProfile = guestProfileDAO
                .validateGuest(emailId, password);
        if (!(entityGuestProfile == null)) {
            guestprofile.setGuestID(entityGuestProfile.getGuestId());
            guestprofile.setGuestfirstname(entityGuestProfile.getFirstname());
            guestprofile.setGuestlastname(entityGuestProfile.getLastname());
            return guestprofile;
        } else {
            return null;
        }
    }
}
