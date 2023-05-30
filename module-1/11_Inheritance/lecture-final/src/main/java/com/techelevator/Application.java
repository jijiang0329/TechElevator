package com.techelevator;

import com.techelevator.avengers.IronMan;

public class Application {

    public static void main(String[] args) {


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        Bid winner = generalAuction.getHighBid();
        System.out.println(winner.getBidder() + " won with bid of " + winner.getBidAmount());


        BuyoutAuction ba = new BuyoutAuction("1st Edition Spiderman", 1000);
        ba.placeBid(new Bid("Josh", 10));
        ba.placeBid(new Bid("Joe", 100));
        ba.placeBid(new Bid("Jill", 2000));
        ba.placeBid(new Bid("Christopher", 1000));

        winner = ba.getHighBid();
        System.out.println(winner.getBidder() + " won with bid of " + winner.getBidAmount());

    }
}
