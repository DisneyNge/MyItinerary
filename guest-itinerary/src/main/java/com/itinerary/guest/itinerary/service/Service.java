package com.itinerary.guest.itinerary.service;
import java.io.IOException;

import com.itinerary.guest.itinerary.model.Itinerary;
/**
 * The Interface Service.
 */
public interface Service {
/**
* Gets the itinerary.
*
* @param customerId the customer id
* @return the itinerary
* @throws IOException Signals that an I/O exception has occurred.
*/
Itinerary getItinerary(Long customerId) throws IOException;
}
