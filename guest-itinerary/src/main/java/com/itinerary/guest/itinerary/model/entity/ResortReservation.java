package com.itinerary.guest.itinerary.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ResortReservation.
 */
@Entity
@Table(name = "ResortReservation")

public class ResortReservation {
    /**
     * This is logger.
     */
    static final Logger LOGGER = Logger.getLogger(ResortReservation.class);

    /**
     * reservationId.
     */
    @Id
    @GeneratedValue
    @Column(name = "ReservationId")
    private Long reservationId;

    /**
     * customerId.
     */
    @Column(name = "CustomerID")
    private Long customerId;
    
    /**
     * noofnights.
     */
    @Column(name = "NoOfNights")
    private int noofnights;

    /**
     * Gets the noofnights.
     *
     * @return noofnights
     */
    public final int getNoofnights() {
        return noofnights;
    }

    /**
     * Sets the noofnights.
     *
     * @param noofnights1 hh
     */
    public final void setNoofnights(final int noofnights1) {
        this.noofnights = noofnights1;
    }

    /***
     * roomType.
     */
    @Column(name = "RoomType")
    private String roomType;

    /**
     * arrivalDate.
     */
    @Column(name = "ArrivalDate")
    private Date arrivalDate;

    /**
     * departureDate.
     */
    @Column(name = "DepartureDate")
    private Date departureDate;

    /**
     * people.
     */
    @Column(name = "NoOfPeople")
    private int people;
    /***
     * status.
     */
    @Column(name = "Status")
    private String status;

    /**
     * createDate.
     */
    @Column(name = "CreatedDate", updatable = false)
    private Date createDate;

    /***
     * updatedate.
     */
    @Column(name = "UpdatedDate")
    private Date updatedate;

    /**
     * Gets the customer id.
     *
     * @return customerId
     */
    public final Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer id.
     *
     * @param customerId1            customerId1
     */
    public final void setCustomerId(final Long customerId1) {
        this.customerId = customerId1;
    }

    /**
     * Gets the reservation id.
     *
     * @return reservationId
     */
    public final Long getReservationId() {
        return reservationId;
    }

    /**
     * Sets the reservation id.
     *
     * @param reservationId1            reservationId1
     */
    public final void setReservationId(final Long reservationId1) {
        this.reservationId = reservationId1;
    }

    /**
     * Gets the room type.
     *
     * @return roomType
     */
    public final String getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type.
     *
     * @param roomType1            roomType1
     */
    public final void setRoomType(final String roomType1) {
        this.roomType = roomType1;
    }

    /**
     * Gets the arrival date.
     *
     * @return arrivalDate
     */
    public final Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the arrival date.
     *
     * @param arrivalDate1            arrivalDate1
     */
    public final void setArrivalDate(final Date arrivalDate1) {
        this.arrivalDate = arrivalDate1;
    }

    /**
     * Gets the departure date.
     *
     * @return departureDate
     */
    public final Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the departure date.
     *
     * @param departureDate1            departureDate1
     */
    public final void setDepartureDate(final Date departureDate1) {
        this.departureDate = departureDate1;
    }

    /**
     * Gets the people.
     *
     * @return people
     */
    public final int getPeople() {
        return people;
    }

    /**
     * Sets the people.
     *
     * @param people1            people1
     */
    public final void setPeople(final int people1) {
        this.people = people1;
    }

    /**
     * Gets the status.
     *
     * @return status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status1            status1
     */
    public final void setStatus(final String status1) {
        this.status = status1;
    }

    /**
     * Gets the creates the date.
     *
     * @return createDate
     */
    public final Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets the creates the date.
     *
     * @param createDate1            createDate
     */
    public final void setCreateDate(final Date createDate1) {
        this.createDate = createDate1;
    }

    /**
     * Gets the updatedate.
     *
     * @return updatedate
     */
    public final Date getUpdatedate() {
        return updatedate;
    }

    /**
     * Sets the updatedate.
     *
     * @param updatedate1            updatedate1
     */
    public final void setUpdatedate(final Date updatedate1) {
        this.updatedate = updatedate1;
    }

}
