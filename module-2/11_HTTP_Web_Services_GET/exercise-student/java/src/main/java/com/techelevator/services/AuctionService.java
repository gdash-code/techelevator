package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Auction;

public class AuctionService {

    public static final String BASE_URL = "http://localhost:3000/auctions";
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();


    public Auction[] listAllAuctions() {
        // api code here
        return null;
    }

    public Auction listDetailsForAuction(int id) {
        // api code here
        return null;
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        // api code here
        return null;
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        // api code here
        return null;
    }

}
