package com.itinerary.guest.itinerary.ws;

import java.io.IOException;
import org.easymock.EasyMock;
import org.junit.Test;
import com.itinerary.guest.itinerary.model.Itinerary;
import com.itinerary.guest.itinerary.service.Service;

public class ShowItineraryWSTest {
	
	
	@Test
	public void getItineraryByCustomerIdTest() throws IOException {
		
		final ShowItineraryWS showItineraryWS = new ShowItineraryWS();
		final Service service = EasyMock.createMock(Service.class);
		showItineraryWS.setService(service);
		EasyMock.expect(service.getItinerary(1l)).andReturn(EasyMock.createMock(Itinerary.class));
		EasyMock.replay(service);
		showItineraryWS.getItineraryByCustomerId(1l);
	}
	
	
		@Test
		public void getItineraryByCustomerIdTest1() throws Exception {
			
			final ShowItineraryWS showItineraryWS = new ShowItineraryWS();
			final Service service = EasyMock.createMock(Service.class);
			showItineraryWS.setService(service);
			showItineraryWS.setService(service);
			EasyMock.expect(service.getItinerary(1l)).andThrow(new NullPointerException());
			EasyMock.replay(service);
			showItineraryWS.getItineraryByCustomerId(1l);
		}
}
