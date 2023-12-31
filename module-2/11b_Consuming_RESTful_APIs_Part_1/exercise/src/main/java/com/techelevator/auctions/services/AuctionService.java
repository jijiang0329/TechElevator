package com.techelevator.auctions.services;

import org.apiguardian.api.API;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        // call api here
        Auction[] auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        return auctions;
    }

    public Auction getAuction(int id) {
        // call api here
        Auction auction = restTemplate.getForObject(API_BASE_URL + "/" +id, Auction.class);
        return auction;

    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        // call api here
        Auction[] auctions = restTemplate.getForObject(API_BASE_URL + "?title=" +title, Auction[].class);
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        // call api here
        Auction[] auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" +price, Auction[].class);
        return auctions;
    }

}
