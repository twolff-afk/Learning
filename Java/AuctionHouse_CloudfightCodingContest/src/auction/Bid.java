package auction;

public class Bid {

    private String nameOfBidder;
    private int bid;

    public Bid(String nameOfBidder, int bid) {
        this.nameOfBidder = nameOfBidder;
        this.bid = bid;
    }

    public String getNameOfBidder() {
        return nameOfBidder;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
