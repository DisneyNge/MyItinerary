package com.itinerary.guest.profile.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EntityGuestprofile.
 *
 */
@Entity
@Table(name = "GuestProfile")
public class EntityGuestprofile {

    /**
     * guestId.
     */
    @Id
    @GeneratedValue
    @Column(name = "CustomerID")
    private Long guestId;

    /**
     * emailId.
     */
    @Column(name = "EMailID")
    private String emailId;

    /**
     * firstname.
     */
    @Column(name = "FirstName")
    private String firstname;

    /**
     * lastname.
     */
    @Column(name = "LastName")
    private String lastname;

    /**
     * address.
     */
    @Column(name = "Address")
    private String address;

    /**
     * phone.
     */
    @Column(name = "PhoneNumber")
    private String phone;

    /**
     * password.
     */
    @Column(name = "Password")
    private String password;

    /**
     * createddate.
     */
    @Column(name = "CreatedDate")
    private Date createddate;

    /**
     * updateddate.
     */
    @Column(name = "UpdatedDate")
    private Date updateddate;

    /**
     * @return guestId
     */
    public final Long getGuestId() {
        return guestId;
    }

    /**
     * @param guestId1
     *            guestId1
     */
    public final void setGuestId(final Long guestId1) {
        guestId = guestId1;
    }

    /**
     * @return emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId1
     *            emailId1
     */
    public final void setEmailId(final String emailId1) {
        emailId = emailId1;
    }

    /**
     * @return firstname
     */
    public final String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname1
     *            firstname1
     */
    public final void setFirstname(final String firstname1) {
        firstname = firstname1;
    }

    /**
     * @return lastname
     */
    public final String getLastname() {
        return lastname;
    }

    /**
     * @param lastname1
     *            lastname1
     */
    public final void setLastname(final String lastname1) {
        lastname = lastname1;
    }

    /**
     * @return address
     */
    public final String getAddress() {
        return address;
    }

    /**
     * @param address1
     *            address1
     */
    public final void setAddress(final String address1) {
        address = address1;
    }

    /**
     * @return phone
     */
    public final String getPhone() {
        return phone;
    }

    /**
     * @param phone1
     *            phone1
     */
    public final void setPhone(final String phone1) {
        phone = phone1;
    }

    /**
     * @return password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password1
     *            password1
     */
    public final void setPassword(final String password1) {
        password = password1;
    }

    /**
     * @return createddate
     */
    public final Date getCreateddate() {
        return createddate;
    }

    /**
     * @param date1
     *            date1
     */
    public final void setCreateddate(final Date date1) {
        createddate = date1;
    }

    /**
     * @return updateddate
     */
    public final Date getUpdateddate() {
        return updateddate;
    }

    /**
     * @param updateddate1
     *            updateddate1
     */
    public final void setUpdateddate(final Date updateddate1) {
        updateddate = updateddate1;
    }

    /**
     * default constructor.
     */
    public EntityGuestprofile() {
        // default constructor
    }
}
