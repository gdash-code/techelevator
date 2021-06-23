package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Auction;

public class AuctionService {

    public static final String BASE_URL = "http://localhost:3000/auctions";
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();


    public Auction[] listAllAuctions() {
        return restTemplate.getForObject(BASE_URL, Auction[].class);
    }

    public Auction listDetailsForAuction(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Auction.class);
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        return restTemplate.getForObject(BASE_URL + "?title_like=" + title, Auction[].class);
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        return restTemplate.getForObject(BASE_URL + "?currentBid_lte=" + price, Auction[].class);
    }

}
