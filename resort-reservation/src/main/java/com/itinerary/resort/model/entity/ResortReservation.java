package com.itinerary.resort.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * @author akuma408 class name is ResortReservation.
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
     * @return noofnights
     */
    public int getNoofnights() {
        return noofnights;
    }

    /**
     * @param noofnights1 hh
     */
    public void setNoofnights(int noofnights1) {
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
     * @return customerId
     */
    public final Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId1
     *            customerId1
     */
    public final void setCustomerId(final Long customerId1) {
        this.customerId = customerId1;
    }

    /**
     * @return reservationId
     */
    public final Long getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId1
     *            reservationId1
     */
    public final void setReservationId(final Long reservationId1) {
        this.reservationId = reservationId1;
    }

    /**
     * @return roomType
     */
    public final String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType1
     *            roomType1
     */
    public final void setRoomType(final String roomType1) {
        this.roomType = roomType1;
    }

    /**
     * @return arrivalDate
     */
    public final Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate1
     *            arrivalDate1
     */
    public final void setArrivalDate(final Date arrivalDate1) {
        this.arrivalDate = arrivalDate1;
    }

    /**
     * @return departureDate
     */
    public final Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate1
     *            departureDate1
     */
    public final void setDepartureDate(final Date departureDate1) {
        this.departureDate = departureDate1;
    }

    /**
     * @return people
     */
    public final int getPeople() {
        return people;
    }

    /**
     * @param people1
     *            people1
     */
    public final void setPeople(final int people1) {
        this.people = people1;
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
     * @return createDate
     */
    public final Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate1
     *            createDate
     */
    public final void setCreateDate(final Date createDate1) {
        this.createDate = createDate1;
    }

    /**
     * @return updatedate
     */
    public final Date getUpdatedate() {
        return updatedate;
    }

    /**
     * @param updatedate1
     *            updatedate1
     */
    public final void setUpdatedate(final Date updatedate1) {
        this.updatedate = updatedate1;
    }

}
