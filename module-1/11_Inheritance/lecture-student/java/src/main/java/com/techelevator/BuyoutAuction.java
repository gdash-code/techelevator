package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;
    private int totalBidCount;

    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        totalBidCount++;
        if (getHighBid().getBidAmount() < buyoutPrice) {


            //only counting bids that matter as soon as buyout is met we stop counting

            if (offeredBid.getBidAmount() >= buyoutPrice) {
                //If the offered bid amount is greater than buyoutPrice, set bid to buyout
            offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
        }
        isCurrentWinningBid = super.placeBid(offeredBid);
    }
        return isCurrentWinningBid;
    }
    public int getTotalBidCount(){
        return totalBidCount;
    }
}
