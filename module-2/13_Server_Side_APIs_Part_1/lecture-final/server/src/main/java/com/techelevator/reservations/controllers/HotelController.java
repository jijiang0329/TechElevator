package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(required=false, defaultValue="") String state,
                            @RequestParam(required=false, defaultValue="") String city,
                            @RequestParam(defaultValue="0") double doubleValue
    ) {
        return hotelDao.getHotelsByStateAndCity(state, city);
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.getHotelById(id);
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservations(){
        return reservationDao.getReservations();
    }

    @RequestMapping(path="/reservations", method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationDao.createReservation(reservation);
    }

    @RequestMapping(path="/reservations/{reservationId}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable int reservationId){
        return reservationDao.getReservationById(reservationId);
    }


    @RequestMapping(path="/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsByHotel(@PathVariable int id){
        return reservationDao.getReservationsByHotel(id);
    }


}
