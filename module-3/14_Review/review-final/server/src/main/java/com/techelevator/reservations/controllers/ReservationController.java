package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="reservations")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationDao reservationDao ;


    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.getReservations();
    }


    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
        Reservation reservation = reservationDao.getReservationById(id);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found.");
        } else {
            return reservation;
        }
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {

        return reservationDao.createReservation(reservation);
    }

    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    public Reservation updateReservation(@PathVariable int id,@Valid @RequestBody Reservation reservation){
        try{
            reservation.setId(id);
            return reservationDao.updateReservation(reservation);
        }catch(DaoException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "We could find the reservation");
        }
    }

    //  @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int id){
        reservationDao.deleteReservationById(id);
    }
}
