package com.techelevator.auctions.dao;

import com.techelevator.auctions.model.Auction;

import java.util.List;

public interface AuctionDao {

    List<Auction> getAuctions();

    Auction getAuctionById(int id);

    Auction createAuction(Auction auction);

    List<Auction> getAuctionsByTitle(String searchTerm);

    List<Auction> getAuctionsByMaxBid(double maxBid);

    List<Auction> getAuctionsByTitleAndMaxBid(String searchTerm, double maxBid);
    List<Auction> getAuctionsByTitleAndCurrentBid(String searchTerm, double currentBid_lte);
}
