package com.itinerary.dining.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.itinerary.dining.dao.DiningDAOImpl;
import com.itinerary.dining.dao.IDiningDAO;
import com.itinerary.dining.model.DiningReservationModel;
import com.itinerary.dining.model.entity.DiningReservation;

public class DiningServiceImplTest {

	@Test
	public void tesbookResortReservation() throws Exception {

		DiningServiceImpl diningServiceImpl = new DiningServiceImpl();

		DiningReservationModel diningReservationModel = new DiningReservationModel();

		DiningDAOImpl diningDao = EasyMock.createMock(DiningDAOImpl.class);

		diningServiceImpl.setDiningDAO(diningDao);

		diningReservationModel.setDineIndate("2010-12-13");
		diningReservationModel.setDineIntime("12:40");
		diningReservationModel.setGuestID(56l);
		
		EasyMock.expect(diningDao.bookDiningReservation(EasyMock.anyObject(DiningReservation.class)))
				.andReturn(new Long(123));
		
		EasyMock.replay(diningDao);
		
		diningServiceImpl.bookDiningReservation(diningReservationModel);
	}
	
	@Test
	public void testprovideResortReservation11() throws Exception {
		
		DiningServiceImpl diningServiceImpl = new DiningServiceImpl();
		DiningDAOImpl diningDao = EasyMock.createMock(DiningDAOImpl.class);
		diningServiceImpl.setDiningDAO(diningDao);
		DiningReservation diningReservation = new DiningReservation();
		
		List<DiningReservation> dininglist =new ArrayList<>();
		dininglist.add(diningReservation);
				
		EasyMock.expect(diningDao.provideDiningReservation(EasyMock.anyObject(Long.class))).andReturn(dininglist);
		 diningReservation.setReservationId(10l);
		 diningReservation.setCustomerIdfinal(34l);
		 diningReservation.setDiningType("ab");
		 diningReservation.setNoOfPeople(4);
		 diningReservation.setArrivalDate(new Date());
		EasyMock.replay(diningDao);
		diningServiceImpl.provideDiningReservation(10l);
	}

	@Test
	public void testcancelResortReservation() throws Exception {

		DiningServiceImpl diningServiceImpl = new DiningServiceImpl();
		DiningDAOImpl diningDao = EasyMock.createMock(DiningDAOImpl.class);
		diningServiceImpl.setDiningDAO(diningDao);
		EasyMock.expect(
				diningDao.cancelDiningReservation(EasyMock.anyObject(Long.class), EasyMock.anyObject(Long.class)))
				.andReturn(5l);
		EasyMock.replay(diningDao);
		diningServiceImpl.cancelDiningReservation(10l, 15l);
	}
}
