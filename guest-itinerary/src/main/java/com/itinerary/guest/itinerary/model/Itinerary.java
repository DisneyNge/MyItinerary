package com.itinerary.guest.itinerary.model;

import java.util.List;

import com.itinerary.guest.itinerary.model.entity.DiningReservation;
import com.itinerary.guest.itinerary.model.entity.ResortReservation;

/**
 * The Class Itinerary.
 */
public class Itinerary {
/** The dining list. */
private List<DiningReservation> diningList=null;
/** The resort list. */
private List<ResortReservation> resortList=null;
/**
* Gets the dining list.
*
* @return the dining list
*/
public final List<DiningReservation> getDiningList() {
return diningList;
}

/**
 * Sets the dining list.
 *
 * @param diningList1 the new dining list
 */
public final void setDiningList(final List<DiningReservation> diningList1) {
this.diningList = diningList1;
}
/**
* Gets the resort list.
*
* @return the resort list
*/
public final List<ResortReservation> getResortList() {
return resortList;
}

/**
 * Sets the resort list.
 *
 * @param resortList1 the new resort list
 */
public final void setResortList(final List<ResortReservation> resortList1) {
this.resortList = resortList1;
}
}
