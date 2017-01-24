package com.itinerary.dining.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.easymock.EasyMock;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.itinerary.dining.model.DiningReservationModel;
import com.itinerary.dining.service.IDiningService;

@PrepareForTest({ Response.class })
public class TestDiningWS {

	@Test
	public void bookDiningReservationTest() throws Exception {
		DiningWS diningWs = new DiningWS();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.bookDiningReservation(EasyMock.anyObject(DiningReservationModel.class)))
				.andReturn(diningReservationModel);
		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.bookDiningReservation(diningReservationModel);
	}

	@Test
	public void bookDiningReservation2Test() throws Exception {
		DiningWS diningWs = new DiningWS();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.bookDiningReservation(EasyMock.anyObject(DiningReservationModel.class)))
				.andThrow(new Exception());
		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.bookDiningReservation(diningReservationModel);
	}

	@Test
	public void showDiningReservationTest() throws Exception {
		DiningWS diningWs = new DiningWS();
		List<DiningReservationModel> diningList = new ArrayList<DiningReservationModel>();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		diningList.add(diningReservationModel);
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.provideDiningReservation(EasyMock.anyLong())).andReturn(diningList);

		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.showDiningReservation(21l);

	}

	@Test
	public void showDiningReservation2Test() throws Exception {
		DiningWS diningWs = new DiningWS();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.provideDiningReservation(EasyMock.anyLong())).andThrow(new Exception());

		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.showDiningReservation(21l);
	}

	@Test
	public void cancelDiningBookingTest() throws Exception {
		DiningWS diningWs = new DiningWS();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.cancelDiningReservation(EasyMock.anyLong(), EasyMock.anyLong())).andReturn(21l);

		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.cancelDiningBooking(diningReservationModel);

	}

	@Test
	public void cancelDiningBooking2Test() throws Exception {
		DiningWS diningWs = new DiningWS();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.cancelDiningReservation(EasyMock.anyLong(), EasyMock.anyLong()))
				.andThrow(new Exception());

		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.cancelDiningBooking(diningReservationModel);
	}
	
	@Test
	public void cancelDiningBooking3Test() throws Exception {
		DiningWS diningWs = new DiningWS();
		DiningReservationModel diningReservationModel = new DiningReservationModel();
		IDiningService iDiningService = EasyMock.createMock(IDiningService.class);
		PowerMock.mockStatic(Response.class);
		ResponseBuilder responBuilder = EasyMock.createMock(ResponseBuilder.class);
		EasyMock.expect(responBuilder.entity(Object.class)).andReturn(responBuilder);
		EasyMock.expect(Response.status(201)).andReturn(responBuilder);
		EasyMock.expect(iDiningService.cancelDiningReservation(EasyMock.anyLong(), EasyMock.anyLong())).andReturn(1l);

		EasyMock.replay(responBuilder, iDiningService);
		PowerMock.replay(Response.class);
		diningWs.setDiningService(iDiningService);
		diningWs.cancelDiningBooking(diningReservationModel);

	}
}
