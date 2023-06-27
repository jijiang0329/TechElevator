package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {

        String url = API_BASE_URL + "reservations";

        //We'll declare the http headers and configure them to indicate we are sending JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //We'll declare a new Http request indicating that it holds a reservation and we will pass
        //our reservation object and the headers into its constructor
        HttpEntity<Reservation> entity = new HttpEntity<>(newReservation, headers);
        Reservation result = null;

        try {
            result = restTemplate.postForObject(url, entity, Reservation.class);
        }
        catch(RestClientResponseException ex){ //This is for when we find the server but it sends an error back (no permission, bad data, etc.)
            BasicLogger.log(ex.getRawStatusCode() + ":" + ex.getStatusText());
        }
        catch(ResourceAccessException ex){ //This is for when we cannot access the external server we are calling
            BasicLogger.log(ex.getMessage());
        }

        return result;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation reservation) {

        String url = API_BASE_URL + "reservations/" + reservation.getId();


        HttpEntity<Reservation> entity = makeEntity(reservation);

        boolean success = false;
        try {
             restTemplate.put(url, entity);
             success = true;
        }
        catch(RestClientResponseException ex){ //This is for when we find the server but it sends an error back (no permission, bad data, etc.)
            BasicLogger.log(ex.getRawStatusCode() + ":" + ex.getStatusText());
        }
        catch(ResourceAccessException ex){ //This is for when we cannot access the external server we are calling
            BasicLogger.log(ex.getMessage());
        }

        return success;
    }

    public HttpEntity<Reservation> makeEntity(Reservation reservation){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers);

        return entity;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {

        String url = API_BASE_URL + "reservations/" + id;

        boolean success = false;
        try {
            restTemplate.delete(url);
            success = true;
        }
        catch(RestClientResponseException ex){ //This is for when we find the server but it sends an error back (no permission, bad data, etc.)
            BasicLogger.log(ex.getRawStatusCode() + ":" + ex.getStatusText());
        }
        catch(ResourceAccessException ex){ //This is for when we cannot access the external server we are calling
            BasicLogger.log(ex.getMessage());
        }

        return success;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}