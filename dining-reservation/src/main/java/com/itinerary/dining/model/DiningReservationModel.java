package com.itinerary.dining.model;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * DiningReservationModel.
 */
public class DiningReservationModel {
	/**
	 * Logger.
	 */
	static final Logger LOGGER =
			Logger.getLogger(DiningReservationModel.class);

	/**
	 * @return reservationID1.
	 */
	public final Long getReservationID() {
		return reservationID;
	}
	/**
	 * @param reservationID1
	 *            reservationID1.
	 */
	public final void setReservationID(final Long reservationID1) {
		this.reservationID = reservationID1;
	}

/**
* @return guestID.
*/
public final Long getGuestID() {
		return guestID;
	}

	/**
	 * @param guestID1
	 *            guestID1.
	 */
	public final void setGuestID(final Long guestID1) {
		this.guestID = guestID1;
	}

	/**
	 * guestID.
	 */
	@JsonProperty(value = "reservation_ID")
	private Long reservationID;
	/**
	 * guestID.
	 */
	@JsonProperty(value = "guest_ID")
	private Long guestID;
	/**
	 * diningType.
	 */
	@JsonProperty(value = "dining_type")
	private String diningType;
	/**
	 * dineIndate.
	 */
	@JsonProperty(value = "dineIn_date")
	private String dineIndate;
	/**
	 * dineIntime.
	 */
	@JsonProperty(value = "dineIn_time")
	private String dineIntime;
	/**
	 * dineIntime.
	 */
	@JsonProperty(value = "no_Of_Guests")
	private int noOfGuests;

	/**
	 * @return dineIntime.
	 */
	public final String getDineIntime() {
		return dineIntime;
	}

	/**
	 * @param dineIntime1
	 *            dineIntime1.
	 */
	public final void setDineIntime(final String dineIntime1) {
		this.dineIntime = dineIntime1;
	}

	/**
	 * status.
	 */
	@JsonProperty(value = "status")
	private String status;

	/**
	 * @return status.
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * @param status1
	 *            status1.
	 */
	public final void setStatus(final String status1) {
		this.status = status1;
	}

	/**
	 * @return diningType.
	 */
	public final String getDiningType() {
		return diningType;
	}

	/**
	 * @param diningtype1
	 *            diningtype1.
	 */
	public final void setDiningType(final String diningtype1) {
		this.diningType = diningtype1;
	}

	/**
	 * @return noOfGuests.
	 */
	public final int getNoOfGuests() {
		return noOfGuests;
	}

	/**
	 * @param noOfGuests1
	 *            noOfGuests1.
	 */
	public final void setNoOfGuests(final int noOfGuests1) {
		this.noOfGuests = noOfGuests1;
	}

	/**
	 * @return dineIndate.
	 */
	public final String getDineIndate() {
		return dineIndate;
	}

	/**
	 * @param dineIndate1
	 *            dineIndate1.
	 */
	public final void setDineIndate(final String dineIndate1) {
		this.dineIndate = dineIndate1;
	}
}
