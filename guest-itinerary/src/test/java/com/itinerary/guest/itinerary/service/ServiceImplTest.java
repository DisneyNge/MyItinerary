package com.itinerary.guest.itinerary.service;

import java.io.IOException;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import com.itinerary.guest.itinerary.clients.DiningClient;
import com.itinerary.guest.itinerary.clients.ResortClient;
import com.itinerary.guest.itinerary.model.Itinerary;

public class ServiceImplTest {

	@Test
	public void getItinerarytest1() throws IOException {

		ServiceImpl serviceImpl=new ServiceImpl();

		Itinerary itinerary=EasyMock.createMock(Itinerary.class);
		serviceImpl.setItinerary(itinerary);

		DiningClient diningClientMock=EasyMock.createMock(DiningClient.class);
		serviceImpl.setDiningClient(diningClientMock);

		EasyMock.expect(diningClientMock.getDining(1l)).andReturn(EasyMock.createMock(List.class));

		ResortClient resortClientMock=EasyMock.createMock(ResortClient.class);
		serviceImpl.setResortClient(resortClientMock);

		EasyMock.expect(resortClientMock.getResort(1l)).andThrow(new NullPointerException());

		EasyMock.replay(diningClientMock,resortClientMock);

		serviceImpl.getItinerary(1l);
	}

	@Test
	public void getItinerarytest2() throws IOException {

		ServiceImpl serviceImpl=new ServiceImpl();

		Itinerary itinerary=EasyMock.createMock(Itinerary.class);
		serviceImpl.setItinerary(itinerary);

		DiningClient diningClientMock=EasyMock.createMock(DiningClient.class);
		serviceImpl.setDiningClient(diningClientMock);

		EasyMock.expect(diningClientMock.getDining(1l)).andThrow(new NullPointerException());

		ResortClient resortClientMock=EasyMock.createMock(ResortClient.class);
		serviceImpl.setResortClient(resortClientMock);

		EasyMock.expect(resortClientMock.getResort(1l)).andReturn(EasyMock.createMock(List.class));

		EasyMock.replay(diningClientMock,resortClientMock);

		serviceImpl.getItinerary(1l);
	}

	@Test
	public void getItinerarytest5() throws IOException {

		ServiceImpl serviceImpl=new ServiceImpl();

		DiningClient diningClientMock=EasyMock.createMock(DiningClient.class);

		ResortClient resortClientMock=EasyMock.createMock(ResortClient.class);

		Itinerary itinerary=EasyMock.createMock(Itinerary.class);

		serviceImpl.setDiningClient(diningClientMock);

		serviceImpl.setResortClient(resortClientMock);

		serviceImpl.setItinerary(itinerary);

		serviceImpl.getDiningClient();
		serviceImpl.getResortClient();

		EasyMock.expect(diningClientMock.getDining(1l)).andReturn(EasyMock.createMock(List.class));

		EasyMock.expect(resortClientMock.getResort(1l)).andReturn(EasyMock.createMock(List.class));

		EasyMock.replay(diningClientMock,resortClientMock);

		serviceImpl.getItinerary(1l);
	}
}
