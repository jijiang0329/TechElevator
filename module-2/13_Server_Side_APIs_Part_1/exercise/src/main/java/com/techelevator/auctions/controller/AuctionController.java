package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "", value = "title_like") String searchTerm,
                              @RequestParam(required = false, defaultValue = "0", value = "currentBid_lte") double maxBid) {
        if(searchTerm.length()==0 && maxBid ==0) return auctionDao.getAuctions();

        if(searchTerm.length() != 0 && maxBid !=0)
            return auctionDao.getAuctionsByTitleAndMaxBid(searchTerm,maxBid);
        else if(searchTerm.length() != 0 && maxBid == 0)
            return auctionDao.getAuctionsByTitle(searchTerm);
        else if(searchTerm.length() == 0 && maxBid != 0)
            return auctionDao.getAuctionsByMaxBid(maxBid);
        else
            return auctionDao.getAuctions();

    }



    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return auctionDao.getAuctionById(id);
    }
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction createAuction(@RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }

}
