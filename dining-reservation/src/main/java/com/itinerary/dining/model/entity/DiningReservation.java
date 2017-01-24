package com.itinerary.dining.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * DiningReservation.
 *
 */
@Entity(name = "DiningReservation")
@Table(name = "DiningReservation")
public class DiningReservation {
/**
* Logger.
*/
static final Logger LOGGER = Logger.getLogger(DiningReservation.class);

/**
* reservationId.
* */
@Id
@GeneratedValue
@Column(name = "ReservationID")
private Long reservationId;

/**
* customerId.
*/
@Column(name = "CustomerID")
private Long customerId;

/**
* diningType.
*/
@Column(name = "DiningType")
private String diningType;

/**
*arrivalDate.
*/
@Column(name = "ArrivalDate")
private Date arrivalDate;

/**
* arrivalTime.
*/
@Column(name = "ArrivalTime")
private String arrivalTime;

/**
*noOfPeople.
*/
@Column(name = "NoOfPeople")
private int noOfPeople;

/**
* status.
*/
@Column(name = "Status")
private String status;
/**
* createdDate.
*/
@Column(name = "CreatedDate")
private Date createdDate;
/**
* updatedDate.
*/
@Column(name = "UpdatedDate")
private Date updatedDate;

/**
* @return reservationId
*/
public Long getReservationId() {
return reservationId;
}

/**
* @param reservationId1 reservationId1
 */
public final void setReservationId(final Long reservationId1) {
reservationId = reservationId1;
}

/**
* @return arrivalTime
*/
public final String getArrivalTime() {
return arrivalTime;
}

/**
* @param date arrivalTime1
*/
public final void setArrivalTime(final String date) {
arrivalTime = date;
}
/**
* @return customerId
*/
public final Long getCustomerId() {
return customerId;
}

/**
* @param customerId1 customerId1
 */
public final void setCustomerIdfinal(final Long customerId1) {
customerId = customerId1;
}

/**
* @return diningType
*/
public final String getDiningType() {
return diningType;
}

/**
 * @param diningType1 diningType1
 */
public final void setDiningType(final String diningType1) {
diningType = diningType1;
}

/**
 * @return arrivalDate
 */
public final Date getArrivalDate() {
return arrivalDate;
}

/**
 * @param arrivalDate1 arrivalDate1
 */
public final void setArrivalDate(final Date arrivalDate1) {
arrivalDate = arrivalDate1;
}

/**
 * @return noOfPeople
 */
public final int getNoOfPeople() {
return noOfPeople;
}

/**
 * @param noOfPeople1 noOfPeople1
 */
public final void setNoOfPeople(final int noOfPeople1) {
noOfPeople = noOfPeople1;
}

/**
 * @return status
 */
public final String getStatus() {
return status;
}

/**
 * @param status1 status1
 */
public final void setStatus(final String status1) {
status = status1;
}

/**
 * @return createdDate
 */
public final Date getCreatedDate() {
return createdDate;
}

/**
 * @param createdDate1 createdDate1
 */
public final void setCreatedDate(final Date createdDate1) {
createdDate = createdDate1;
}

/**
 * @return updatedDate
 */
public final Date getUpdatedDate() {
return updatedDate;
}

/**
 * @param updatedDate1 updatedDate1
 */
public final void setUpdatedDate(final Date updatedDate1) {
updatedDate = updatedDate1;
}
}
