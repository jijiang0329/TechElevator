package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {

        //We'll declare the http headers and configure them to indicate we are sending JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //We'll declare a new Http request indicating that it holds a reservation and we will pass
        //our reservation object and the headers into its constructor
        HttpEntity<Auction> entity = new HttpEntity<>(newAuction, headers);
        Auction result = null;

        try {
            result = restTemplate.postForObject(API_BASE_URL, entity, Auction.class);
        }
        catch(RestClientResponseException ex){ //This is for when we find the server but it sends an error back (no permission, bad data, etc.)
            BasicLogger.log(ex.getRawStatusCode() + ":" + ex.getStatusText());
        }
        catch(ResourceAccessException ex){ //This is for when we cannot access the external server we are calling
            BasicLogger.log(ex.getMessage());
        }

        return result;
    }

    public boolean update(Auction updatedAuction) {
        String url = API_BASE_URL + updatedAuction.getId();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(updatedAuction, headers);

        boolean isSuccsess = false;
        try {
            restTemplate.put(url, entity);
            isSuccsess = true;
        }
        catch(RestClientResponseException ex){ //This is for when we find the server but it sends an error back (no permission, bad data, etc.)
            BasicLogger.log(ex.getRawStatusCode() + ":" + ex.getStatusText());
        }
        catch(ResourceAccessException ex){ //This is for when we cannot access the external server we are calling
            BasicLogger.log(ex.getMessage());
        }

        return isSuccsess;
    }

    public boolean delete(int auctionId) {
        String url = API_BASE_URL + auctionId;

        boolean isSuccsess = false;
        try {
            restTemplate.delete(url);
            isSuccsess = true;
        }
        catch(RestClientResponseException ex){ //This is for when we find the server but it sends an error back (no permission, bad data, etc.)
            BasicLogger.log(ex.getRawStatusCode() + ":" + ex.getStatusText());
        }
        catch(ResourceAccessException ex){ //This is for when we cannot access the external server we are calling
            BasicLogger.log(ex.getMessage());
        }

        return isSuccsess;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
