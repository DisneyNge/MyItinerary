package com.itinerary.resort.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.easymock.EasyMock;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itinerary.resort.model.ResortReservationModel;
import com.itinerary.resort.service.resort.IResortService;
/**
 * TestResortWS test class.
 * @author akuma408
 *
 */
@PrepareForTest({ Response.class })
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Test-ApplicationContext.xml" })

public class TestResortWS {
    /**
     * value.
     */
    private final Integer value = 200;
    /**
     * value.
     */
    private final Integer value1 = 201;
    /**
     * value.
     */
    private final Long value2 = (long) 21;

    /**
     * resortservice autorired.
     */
    @Autowired
    private BookResortWS bookResortWebService;

    /**
     * @throws Exception Exception
     */
    @Test
    @SuppressWarnings("PMD.LawOfDemeter")
    public void bookResortReservationTest() throws Exception {
	BookResortWS resortWS = new BookResortWS();
	ResortReservationModel resortReservationModel = new
		ResortReservationModel();

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value)).andReturn(
		responBuilder);

	EasyMock.expect(iResortService.bookResortReservation(EasyMock.anyObject(
		ResortReservationModel.class)))

	.andReturn(resortReservationModel);

	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.bookResortReservation(resortReservationModel);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void bookResortReservation2Test() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	ResortReservationModel resortReservationModel = new
		ResortReservationModel();

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value1)).andReturn(
		responBuilder);

	EasyMock.expect(iResortService.bookResortReservation(EasyMock.anyObject(
		ResortReservationModel.class)))

	.andThrow(new Exception());

	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.bookResortReservation(resortReservationModel);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void provideReservationTest() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	List<ResortReservationModel> resortlist = new
		ArrayList<ResortReservationModel>();

	ResortReservationModel resortReservationModel = new
		ResortReservationModel();

	resortlist.add(resortReservationModel);

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value1)).
	andReturn(responBuilder);


	EasyMock.expect(iResortService.provideResortReservation(
		EasyMock.anyLong())).
	andReturn(resortlist);

	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.provideReservation(value2);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void provideReservationTest1() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	List<ResortReservationModel> diningList = new
		ArrayList<ResortReservationModel>();

	ResortReservationModel diningReservationModel = new
		ResortReservationModel();

	diningList.add(diningReservationModel);

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value1)).andReturn(
		responBuilder);

	EasyMock.expect(iResortService.provideResortReservation(
		EasyMock.anyLong())).
	andReturn(null);

	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.provideReservation(value2);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void provideReservationTest2() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).andReturn(
		responBuilder);

	EasyMock.expect(Response.status(value1)).andReturn(
		responBuilder);

	EasyMock.expect(iResortService.provideResortReservation(
		EasyMock.anyLong())).
	andThrow(new Exception());

	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.provideReservation(value2);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void cancelResortTest() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	ResortReservationModel resortReservationModel = new
		ResortReservationModel();

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value1)).
	andReturn(
		responBuilder);

	EasyMock.expect(iResortService.cancelResortReservation(EasyMock.
		anyLong(), EasyMock.anyLong())).andReturn(value2);


	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.cancelResort(resortReservationModel);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void cancelResortTest2() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	ResortReservationModel resortReservationModel = new
		ResortReservationModel();

	IResortService iResortService = EasyMock.createMock(
		IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value1)).
	andReturn(
		responBuilder);

	EasyMock.expect(iResortService.cancelResortReservation(
		EasyMock.anyLong(), EasyMock.anyLong()))

	.andThrow(new Exception());

	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.cancelResort(resortReservationModel);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void cancelResortTest3() throws Exception {

	BookResortWS resortWS = new BookResortWS();

	ResortReservationModel resortReservationModel = new
		ResortReservationModel();

	IResortService iResortService = EasyMock.
		createMock(IResortService.class);

	PowerMock.mockStatic(Response.class);

	ResponseBuilder responBuilder = EasyMock.createMock(
		ResponseBuilder.class);

	EasyMock.expect(responBuilder.entity(Object.class)).
	andReturn(responBuilder);

	EasyMock.expect(Response.status(value1)).
	andReturn(responBuilder);

	EasyMock.expect(iResortService.cancelResortReservation(EasyMock.
		anyLong(), EasyMock.anyLong())).andReturn(1L);


	EasyMock.replay(responBuilder, iResortService);

	PowerMock.replay(Response.class);

	resortWS.setResortservice(iResortService);

	resortWS.cancelResort(resortReservationModel);
    }
}
