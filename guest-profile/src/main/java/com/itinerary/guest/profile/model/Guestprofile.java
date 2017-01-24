package com.itinerary.guest.profile.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author nadubey Guestprofile.
 */
public class Guestprofile {

    /**
     * annotaion for JsonProperty.
     */
    @JsonProperty(value = "guest_email")

    private String guestemail;

    /**
     * annotaion for JsonProperty.
     */
    @JsonProperty(value = "guest_pwd")

    private String guestpwd;

    /**
     * annotaion for JsonProperty.
     */
    @JsonProperty(value = "guest_first_name")

    private String guestfirstname;

    /**
     * annotaion for JsonProperty.
     */
    @JsonProperty(value = "guest_last_name")

    private String guestlastname;

    /**
     * annotaion for JsonProperty.
     */

    @JsonProperty(value = "guest_phone_no")

    private String guestphoneno;

    /**
     * annotaion for JsonProperty.
     */

    @JsonProperty(value = "guest_address")

    private String guestaddress;

    /**
     * guestID.
     */
    private Long guestID;

    /**
     * @return guestID.
     */
    public final Long getGuestID() {
        return guestID;
    }

    /**
     * @param guestID1
     *            **this is guestID of guest**
     */
    public final void setGuestID(final Long guestID1) {
        guestID = guestID1;
    }

    /**
     * @return guestemail.
     */
    public String getGuestemail() {
        return guestemail;
    }

    /**
     * @param guestemail1
     *            **this is guestemail of guest**
     */

    public final void setGuestemail(final String guestemail1) {
        guestemail = guestemail1;
    }

    /**
     * @return guestpwd.
     */
    public final String getGuestpwd() {
        return guestpwd;
    }

    /**
     * @param guestpwd1
     *            **this is guestemail of guest**
     */
    public final void setGuestpwd(final String guestpwd1) {
        guestpwd = guestpwd1;
    }

    /**
     * @return guestfirstname.
     */
    public final String getGuestfirstname() {
        return guestfirstname;
    }

    /**
     * @param guestfirstname1
     *            **this is guestemail of guest**
     */
    public final void setGuestfirstname(final String guestfirstname1) {
        guestfirstname = guestfirstname1;
    }

    /**
     * @return guestlastname.
     */
    public final String getGuestlastname() {
        return guestlastname;
    }

    /**
     * @param guestlastname1
     *            **this is guestemail of guest**
     */
    public final void setGuestlastname(final String guestlastname1) {
        guestlastname = guestlastname1;
    }

    /**
     * @return guestphoneno.
     */
    public final String getGuestphoneno() {
        return guestphoneno;
    }

    /**
     * @param guestphoneno1
     *            **this is guestemail of guest**
     */
    public final void setGuestphoneno(final String guestphoneno1) {
        guestphoneno = guestphoneno1;
    }

    /**
     * @return guestaddress.
     */
    public final String getGuestaddress() {
        return guestaddress;
    }

    /**
     * @param guestaddress1
     *            **this is guestemail of guest**
     */
    public final void setGuestaddress(final String guestaddress1) {
        guestaddress = guestaddress1;
    }

}
