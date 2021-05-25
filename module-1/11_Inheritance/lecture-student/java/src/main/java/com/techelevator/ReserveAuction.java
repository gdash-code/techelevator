package com.techelevator;

public class ReserveAuction extends Auction{

    private int reservePrice;
    private int totalBidCount;

    public int getTotalBidCount() {
        return totalBidCount;
    }

    public ReserveAuction(String itemForSale, int ReservePrice){
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid){

        boolean isCurrentWinningBid = false;

        if(offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        totalBidCount++;

        return isCurrentWinningBid;
    }

        public void reserveBarker(){
            System.out.println("If you don't have " + reservePrice + ", don't bother bidding");
        }

}
