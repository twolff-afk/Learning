package main;

import auction.AuctionHouse;
import auction.Bid;

public class Main {

    public static void main(String[] args) {
        Bid startBid = new Bid("", 1);
        AuctionHouse auctionHouse = new AuctionHouse(startBid);

        Bid bid = new Bid("A", 15);
        auctionHouse.checkRules(bid);

        Bid secondBid = new Bid("B", 20);
        auctionHouse.checkRules(secondBid);

        Bid thirdBid = new Bid("A", 17);
        auctionHouse.checkRules(thirdBid);
    }

}
