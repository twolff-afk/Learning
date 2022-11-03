package auction;

public class AuctionHouse implements AuctionHouseInterface {

    private boolean result;
    private Bid highestBid;
    private Rules ruleChecker;

    public AuctionHouse(Bid startBid) {
        this.result = false;
        this.ruleChecker = new Rules(startBid);
    }

    public boolean checkRules(Bid currentBid) {

        boolean result = false;

        result = ruleChecker.firstBidder(currentBid);
        if (!result) {
            result = ruleChecker.newBiddersBidIsHigher(currentBid);
        }
        if (!result) {
            result = ruleChecker.newBiddersBidIsLower(currentBid);
        }







        Bid bid = ruleChecker.getHighestBid();
        return result;
    }
}
