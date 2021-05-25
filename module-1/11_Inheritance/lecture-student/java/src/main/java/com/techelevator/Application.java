package com.techelevator;

import java.util.ArrayList;
import java.util.List;

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


        for(Bid bid :generalAuction.getAllBids()) {
            System.out.println(bid);
        }

        ReserveAuction reserveAuction = new ReserveAuction("Rare Beenie Baby", 50);

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 51));
        generalAuction.placeBid(new Bid("Rick Astley", 45));

        System.out.println(reserveAuction.getItemForSale() + ": current # of bids: " + reserveAuction.getTotalBidCount());

        for(Bid bid :generalAuction.getAllBids()) {
            System.out.println(bid);
        }

        // Create a new reserve auction
        System.out.println("Starting a buyout auction");
        System.out.println("-----------------");

        BuyoutAuction buyoutAuction = new BuyoutAuction("Super Rare Beenie Baby", 75);
        buyoutAuction.placeBid(new Bid("Josh", 1));
        buyoutAuction.placeBid(new Bid("Fonz", 51));
        buyoutAuction.placeBid(new Bid("Jerry", 86));
        buyoutAuction.placeBid(new Bid("Rick Astley", 45));
        buyoutAuction.placeBid(new Bid("Newman", 90));

        System.out.println(buyoutAuction.getItemForSale() + ": current # of bids: " + buyoutAuction.getTotalBidCount());

        for(Bid bid :buyoutAuction.getAllBids()) {
            System.out.println(bid);
        }


        //big moment for polymorphism
        List<Auction> allAuctions = new ArrayList<>();

        allAuctions.add(generalAuction);
        allAuctions.add(buyoutAuction);
        allAuctions.add(reserveAuction);

        System.out.println("\n---------------");
        System.out.println("Treating all specializations of");
        System.out.println("An auction generically as their Super type");
        System.out.println("---------------");

        for(Auction auction : allAuctions){
           // if(auction instanceof Auction){ //compares a classes type to another classes type and it's a boolean
              //  System.out.print("Auction");
          //  }

            if(auction instanceof ReserveAuction){
                System.out.println("as Reserve Auction");
            }else if(auction instanceof BuyoutAuction){
                System.out.println("as Buyout Auction");
            }else{
                System.out.println("Generic Auction");
            }

            System.out.println(auction.getHighBid());
        }
    }
}
