package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice = 0;

    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid){

        boolean isWinner = false;

        if(offeredBid.getBidAmount() < buyoutPrice) {
            isWinner = super.placeBid(offeredBid);
        } else {
            if(offeredBid.getBidAmount() >= buyoutPrice //if I'm bidding the buyout price or more
                    && getHighBid().getBidAmount() < buyoutPrice){ //and someone else has not already won
                Bid maxBid = new Bid(offeredBid.getBidder(), buyoutPrice);
                isWinner = super.placeBid(maxBid);
            }
        }


        return isWinner;
    }
}
