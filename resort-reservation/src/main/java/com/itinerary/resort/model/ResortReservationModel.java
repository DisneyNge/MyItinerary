package com.itinerary.resort.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonProperty;

/***
 * @author akuma408
 *
 */
public class ResortReservationModel {
    /***
     * LOGGER.
     */
    static final Logger LOGGER = Logger.getLogger(ResortReservationModel.class);

    /**
     * guest_ID.
     */
    @JsonProperty(value = "guest_ID")
    private Long guestID;

    /**
     * resort_type.
     */
    @JsonProperty(value = "resort_type")
    private String resorType;

    /**
     * checkIn_date.
     */
    @JsonProperty(value = "checkIn_date")
    private String checkInDate;

    /**
     * checkout_date.
     */
    @JsonProperty(value = "checkout_date")
    private String checkoutDate;


    /**
     * no_of_nights.
     */
    @JsonProperty(value = "no_of_nights")
    private int noofnights;

    /**
     * no_of_guests.
     */
    @JsonProperty(value = "no_of_guests")
    private int noofguests;

    /**
     * status.
     */
    @JsonProperty(value = "status")
    private String status;

    /**
     * reservation_Id.
     */
    @JsonProperty(value = "reservation_Id")
    private Long reservationId;

    /**
     * @return reservation_Id
     */
    public final Long getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId1
     *            reservationId1
     */
    public final void setRreservationI(final Long reservationId1) {
        this.reservationId = reservationId1;
    }

    /**
     * @return status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * @param status1
     *            status1
     */
    public final void setStatus(final String status1) {
        this.status = status1;
    }

    /**
     * @return guest_ID
     */
    public final Long getGuestID() {
        return guestID;
    }

    /**
     * @param guestID1
     *            guestID1
     */
    public final void setGuestID(final Long guestID1) {
        this.guestID = guestID1;
    }

    /**
     * @return resort_type
     */
    public final String getResortType() {
        return resorType;
    }

    /**
     * @param resorType1
     *            resorType1
     */
    public final void setResortType(final String resorType1) {
        this.resorType = resorType1;
    }

    /**
     * @return checkIn_date
     */
    public final String getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate1
     *            checkInDate1
     */
    public final void setCheckInDate(final String checkInDate1) {
        this.checkInDate = checkInDate1;
    }

    /**
     * @return String checkoutDate
     */
    public final String getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * @param checkoutdate1
     *            checkoutdate1
     */
    public final void setCheckoutDate(final String checkoutdate1) {
        this.checkoutDate = checkoutdate1;
    }
    /**
     * @return no_of_nights
     */
    public final int getNoofnights() {
        return noofnights;
    }

    /**
     * @param noofnights1
     *            noofnights1
     */
    public final void setNoofnights(final int noofnights1) {
        this.noofnights = noofnights1;
    }

    /**
     * @return no_of_guests
     */
    public final int getNoofguests() {
        return noofguests;
    }

    /**
     * @param noofguests1
     *            noofguests1
     */
    public final void setNoofguests(final int noofguests1) {
        this.noofguests = noofguests1;
    }

}
