package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getParkById_returns_correct_park() {
        Park parkFromDb = sut.getParkById(1);
        assertParksMatch(PARK_1, parkFromDb);
    }

    @Test
    public void getParkById_returns_null_when_id_not_found() {
        Park parkFromDb = sut.getParkById(1000);
        Assert.assertNull(parkFromDb);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parksByState = sut.getParksByState("AA");

        Assert.assertEquals(2, parksByState.size());
        assertParksMatch(PARK_1, parksByState.get(0));
        assertParksMatch(PARK_3, parksByState.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parksByState = sut.getParksByState("ZZ");

        Assert.assertEquals(0, parksByState.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {

        //Arrange
        Park myPark = new Park();
        myPark.setArea(10);
        myPark.setDateEstablished(LocalDate.now());
        myPark.setHasCamping(true);
        myPark.setParkName("My Park");

        //Act
        Park createdPark = sut.createPark(myPark);
        myPark.setParkId(createdPark.getParkId());

        //Assert
        assertParksMatch(myPark, createdPark);

        Park retrieved = sut.getParkById(createdPark.getParkId());
        assertParksMatch(myPark, retrieved);


    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {

        //Arrange
        Park parkToUpdate = sut.getParkById(1);

        parkToUpdate.setParkName("Park Update");
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setArea(0);
        parkToUpdate.setHasCamping(false);

        //Act
        Park updated = sut.updatePark(parkToUpdate);

        //Assert
        assertParksMatch(updated, parkToUpdate);

        Park retrieved = sut.getParkById(1);
        assertParksMatch(parkToUpdate, retrieved);

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deleteParkById(1);

        Park park1 = sut.getParkById(1);
        Assert.assertNull(park1);
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.linkParkState(PARK_1.getParkId(), "BB");

        List<Park> parksInStateB = sut.getParksByState("BB");

        Assert.assertEquals(2, parksInStateB.size());
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
       sut.unlinkParkState(3, "AA");

        List<Park> parksInStateA = sut.getParksByState("AA");

        Assert.assertEquals(1, parksInStateA.size());
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
