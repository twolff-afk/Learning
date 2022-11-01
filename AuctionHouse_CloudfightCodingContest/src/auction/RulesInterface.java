package auction;

public interface RulesInterface {

    /*
    is new bid higher than current price and there is no other bidder, than
    set current bidder to highest bidder and maxBid

    if new bidder has a higher mxBid than previous bidder than set price to previous
    bidders maxBid + one euro and set new bidder to highest bidder

    if new bidders bid is lower than highest bidder maxBid, than set price
    to new bidders bid + one euro

    if new bidders bid is equal to previous bidders bid than nothing is happening
     */

    Bid getHighestBid();

    boolean firstBidder(Bid bid);
    boolean newBiddersBidIsHigher(Bid bid);
    boolean newBiddersBidIsLower(Bid bid);
    boolean newBiddersBidIsEqual(Bid bid);

}
