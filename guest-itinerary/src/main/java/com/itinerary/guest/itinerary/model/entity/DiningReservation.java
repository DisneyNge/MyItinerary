package com.itinerary.guest.itinerary.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * The Class DiningReservation.
 */
@Entity(name = "DiningReservation")
@Table(name = "DiningReservation")
public class DiningReservation {
/** The Constant logger. */
static final Logger LOGGER = Logger.getLogger(DiningReservation.class);

/** The reservation id. */
@Id
@GeneratedValue
@Column(name = "ReservationID")
private Long reservationId;

/** The customer id. */
@Column(name = "CustomerID")
private Long customerId;

/** The dining type. */
@Column(name = "DiningType")
private String diningType;

/** The arrival date. */
@Column(name = "ArrivalDate")
private Date arrivalDate;

/** The arrival time. */
@Column(name = "ArrivalTime")
private String arrivalTime;

/** The no of people. */
@Column(name = "NoOfPeople")
private int noOfPeople;

/** The status. */
@Column(name = "Status")
private String status;

/** The created date. */
@Column(name = "CreatedDate")
private Date createdDate;

/** The updated date. */
@Column(name = "UpdatedDate")
private Date updatedDate;

/**
* Gets the reservation id.
*
* @return the reservation id
*/
public final Long getReservationId() {
return reservationId;
}


/**
 * Sets the reservation id.
 *
 * @param reservationId1 the new reservation id
 */
public final void setReservationId(final Long reservationId1) {
this.reservationId = reservationId1;
}

/**
* Gets the arrival time.
*
* @return the arrival time
*/
public final String getArrivalTime() {
return arrivalTime;
}


/**
 * Sets the arrival time.
 *
 * @param arrivalTime1 the new arrival time
 */
public final void setArrivalTime(final String arrivalTime1) {
this.arrivalTime = arrivalTime1;
}

/**
* Gets the customer id.
*
* @return the customer id
*/
public final Long getCustomerId() {
return customerId;
}


/**
 * Sets the customer id.
 *
 * @param customerId1 the new customer id
 */
public final void setCustomerId(final Long customerId1) {
this.customerId = customerId1;
}

/**
* Gets the dining type.
*
* @return the dining type
*/
public final String getDiningType() {
return diningType;
}


/**
 * Sets the dining type.
 *
 * @param diningType1 the new dining type
 */
public final void setDiningType(final String diningType1) {
this.diningType = diningType1;
}

/**
* Gets the arrival date.
*
* @return the arrival date
*/
public final Date getArrivalDate() {
return arrivalDate;
}


/**
 * Sets the arrival date.
 *
 * @param arrivalDate1 the new arrival date
 */
public final void setArrivalDate(final Date arrivalDate1) {
this.arrivalDate = arrivalDate1;
}

/**
* Gets the no of people.
*
* @return the no of people
*/
public final int getNoOfPeople() {
return noOfPeople;
}


/**
 * Sets the no of people.
 *
 * @param noOfPeople1 the new no of people
 */
public final void setNoOfPeople(final int noOfPeople1) {
this.noOfPeople = noOfPeople1;
}

/**
* Gets the status.
*
* @return the status
*/
public final String getStatus() {
return status;
}

/**
 * Sets the status.
 *
 * @param status1 the new status
 */
public final void setStatus(final String status1) {
this.status = status1;
}

/**
* Gets the created date.
*
* @return the created date
*/
public final Date getCreatedDate() {
return createdDate;
}

/**
 * Sets the created date.
 *
 * @param createdDate1 the new created date
 */
public final void setCreatedDate(final Date createdDate1) {
this.createdDate = createdDate1;
}

/**
* Gets the updated date.
*
* @return the updated date
*/
public final Date getUpdatedDate() {
return updatedDate;
}



/**
 * Sets the updated date.
 *
 * @param updatedDate1 the new updated date
 */
public final void setUpdatedDate(final Date updatedDate1) {
this.updatedDate = updatedDate1;
}
}

