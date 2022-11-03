package auction;

public class Rules implements RulesInterface {

    private Bid highestBid;

    public Rules(Bid startBid) {
        this.highestBid = startBid;
    }

    @Override
    public Bid getHighestBid() {
        return this.highestBid;
    }

    @Override
    public boolean firstBidder(Bid bid) {

        boolean result = false;

        if (highestBid.getNameOfBidder() == "") {
            this.highestBid = bid;
            result = true;
        }

        return result;
    }

    @Override
    public boolean newBiddersBidIsHigher(Bid bid) {

        boolean result = false;

        if(highestBid.getBid() < bid.getBid()) {
            highestBid = bid;
            result = true;
        }

        return result;
    }

    @Override
    public boolean newBiddersBidIsLower(Bid bid) {

        boolean result = false;

        if(highestBid.getBid() > bid.getBid()) {
            highestBid.setBid(bid.getBid() + 1);
            result = true;
        }

        return result;

    }

    @Override
    public boolean newBiddersBidIsEqual(Bid bid) {
        return false;
    }
}
