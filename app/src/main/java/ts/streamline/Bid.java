package ts.streamline;

import org.joda.time.DateTime;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Bid {

    private String Account;
    private Double  BidAmount;
    private  Boolean IsByMobile;
    private  Boolean IsByProxy;
    private  DateTime BidDate;
    private  Boolean IsBuyNow;
    private  Member Bidder;

    public Bid(String account, Double bidAmount, Boolean isByMobile, Boolean isByProxy, DateTime bidDate, Boolean isBuyNow, Member bidder) {
        Account = account;
        BidAmount = bidAmount;
        IsByMobile = isByMobile;
        IsByProxy = isByProxy;
        BidDate = bidDate;
        IsBuyNow = isBuyNow;
        Bidder = bidder;
    }

    public String getAccount() {
        return Account;
    }

    public Double getBidAmount() {
        return BidAmount;
    }

    public Boolean getIsByMobile() {
        return IsByMobile;
    }

    public Boolean getIsByProxy() {
        return IsByProxy;
    }

    public DateTime getBidDate() {
        return BidDate;
    }

    public Boolean getIsBuyNow() {
        return IsBuyNow;
    }

    public Member getBidder() {
        return Bidder;
    }
}
