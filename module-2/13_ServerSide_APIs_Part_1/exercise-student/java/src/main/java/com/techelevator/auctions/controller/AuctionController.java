package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    //return a list
     /*@RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list() {
        return dao.list();
    }*/

    //to return a specific auction based on the value passed to it.
    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    //to add the auction that's passed to it.
    @RequestMapping( path = "/auctions", method = RequestMethod.POST)
    public Auction addAuction(@RequestBody Auction auction) {
        return dao.create(auction);
    }

    @RequestMapping(path="/auctions", method=RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte){
        if(  !title_like.equals("") && currentBid_lte != 0){
            return dao.searchByTitleAndPrice(title_like,currentBid_lte);
        }
        if(  !title_like.equals("")){
            return dao.searchByTitle(title_like);
        }
        if( currentBid_lte != 0){
            return dao.searchByPrice(currentBid_lte);
        }
        return dao.list();
    }


}
