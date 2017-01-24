package com.itinerary.guest.itinerary.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.itinerary.guest.itinerary.clients.DiningClient;
import com.itinerary.guest.itinerary.clients.ResortClient;
import com.itinerary.guest.itinerary.model.Itinerary;

/**
 * The Class ServiceImpl.
 */
public class ServiceImpl implements Service {
/** The Constant logger. */
static final Logger LOGGER = Logger.getLogger(ServiceImpl.class);
/** The dining client. */
@Autowired(required = true)
private DiningClient diningClient;
/** The resort client. */
@Autowired(required = true)
private ResortClient resortClient;
/** The itinerary. */
@Autowired(required = true)
private Itinerary itinerary;
/**
* Gets the dining client.
*
* @return the dining client
*/
public final DiningClient getDiningClient() {
return diningClient;
}

/**
 * Sets the dining client.
 *
 * @param diningClient1 the new dining client
 */
public final void setDiningClient(final DiningClient diningClient1) {
diningClient = diningClient1;
}
/**
* Gets the resort client.
*
* @return the resort client
*/
public final ResortClient getResortClient() {
return resortClient;
}

/**
 * Sets the resort client.
 *
 * @param resortClient1 the new resort client
 */
public final void setResortClient(final ResortClient resortClient1) {
resortClient = resortClient1;
}
/**
* Gets the itinerary.
*
* @return the itinerary
*/
public final Itinerary getItinerary() {
return itinerary;
}

/**
 * Sets the itinerary.
 *
 * @param itinerary1 the new itinerary
 */
public final void setItinerary(final Itinerary itinerary1) {
itinerary = itinerary1;
}
/*
* (non-Javadoc)
*
* @see
* com.itinerary.guest.itinerary.service.Service#getItinerary(java.lang.
* Long)
*/
@Override
public final Itinerary getItinerary(final Long customerId) {
try {
LOGGER.info("Itinerary for customerId" + customerId);
itinerary.setDiningList(diningClient.getDining(customerId));
itinerary.setResortList(resortClient.getResort(customerId));
return itinerary;
} catch (Exception e) {
e.printStackTrace();
LOGGER.error("In Itinerary" + e);
return itinerary;
}
}
}

