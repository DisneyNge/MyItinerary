package com.itinerary.resort.service.resort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.easymock.EasyMock;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itinerary.resort.dao.IResortDao;
import com.itinerary.resort.dao.ResortDaoImpl;
import com.itinerary.resort.model.ResortReservationModel;
import com.itinerary.resort.model.entity.ResortReservation;

/**
 * TestResortService.
 */
@ContextConfiguration(locations = { "classpath:Test-ApplicationContext.xml" })
@PrepareForTest({ Response.class })
// @RunWith(SpringJUnit4ClassRunner.class)
public class TestResortService {
    /**
     * nights and guests provide.
     */
    private final int nights = 4;
    /**
     * value.
     */
    private final Long value = (long) 50;

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void tesbookResortReservation() throws Exception {
        ResortServiceImpl resortServiceImpl = new ResortServiceImpl();
        ResortReservationModel resortReservationModel =
                new ResortReservationModel();
        IResortDao resortDao = EasyMock.createMock(ResortDaoImpl.class);
        ResortReservation resortReservation =
                EasyMock.createMock(ResortReservation.class);

        resortServiceImpl.setResortDao(resortDao);
        // EasyMock.expect(resortReservationModel.getGuest_ID()).andReturn(10l);
        resortReservationModel.setResortType("DELUXE");
        resortReservationModel.setNoofguests(nights);
        resortReservationModel.setNoofnights(nights);
        resortReservationModel.setCheckInDate("2010-12-13");
        resortReservationModel.setCheckoutDate("2010-12-18");
        resortReservationModel.setGuestID(value);
        EasyMock.expect(resortDao.bookResortReservation(
                EasyMock.anyObject(ResortReservation.class))).andReturn(value);
        EasyMock.replay(resortDao, resortReservation);
        resortServiceImpl.bookResortReservation(resortReservationModel);
    }

    /**
     * @throws Exception
     *             Exception
     */
    @Test
    public void testprovideResortReservation() throws Exception {
        ResortServiceImpl resortServiceImpl = new ResortServiceImpl();
        IResortDao resortDao = EasyMock.createMock(ResortDaoImpl.class);
        ResortReservation resortReservation = new ResortReservation();
        List<ResortReservation> resortlist = new ArrayList<>();
        resortlist.add(resortReservation);
        resortServiceImpl.setResortDao(resortDao);

        EasyMock.expect(resortDao.provideResortReservation(
                EasyMock.anyObject(Long.class))).andReturn(resortlist);
        resortReservation.setStatus("ab");
        resortReservation.setRoomType("bn");
        resortReservation.setReservationId(value);
        resortReservation.setPeople(nights);
        resortReservation.setCustomerId(value);
        resortReservation.setArrivalDate(new Date(System.currentTimeMillis()));
        resortReservation.setDepartureDate(new
                Date(System.currentTimeMillis()));
        EasyMock.replay(resortDao);
        resortServiceImpl.provideResortReservation(value);
    }

    /**
     * @throws Exception
     *             Exception
     */
    /*  @Test 
      public void testprovideResortReservation1() throws Exception {
      ResortServiceImpl resortServiceImpl = new ResortServiceImpl(); 
      IResortDao resortDao = EasyMock.createMock(ResortDaoImpl.class);
      resortServiceImpl.setResortDao(resortDao); 
      ResortReservation resortReservation = new ResortReservation(); 
      List<ResortReservation> resortlist = new ArrayList<>();
      resortlist.add(resortReservation); 
      EasyMock.expect(resortDao.provideResortReservation(EasyMock.anyObject(Long.class))).andReturn(null); 
      EasyMock.replay(resortDao);
      resortServiceImpl.provideResortReservation(6L);
      }*/
     
    /**
     * @throws DataAccessException
     *             DataAccessException
     */
    @Test
    public void testcancelResortReservation() throws DataAccessException {
        ResortServiceImpl resortServiceImpl = new ResortServiceImpl();
        IResortDao resortDao = EasyMock.createMock(ResortDaoImpl.class);
        resortServiceImpl.setResortDao(resortDao);
        EasyMock.expect(
                resortDao.cancelResortReservation(EasyMock.anyObject(
                        Long.class), EasyMock.anyObject(Long.class)))
                .andReturn(value);

        EasyMock.replay(resortDao);
        resortServiceImpl.cancelResortReservation(1L, value);
    }
}
