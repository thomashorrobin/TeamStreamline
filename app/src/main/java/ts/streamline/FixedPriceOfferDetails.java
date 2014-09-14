package ts.streamline;

import java.util.ArrayList;
import org.joda.time.DateTime;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class FixedPriceOfferDetails {
    private Integer OfferPrice;
    private DateTime OfferExpiryDate;
    private Integer Quantity;
    private ArrayList<FixedPriceOfferRecipient> Recipients;

    public FixedPriceOfferDetails(Integer offerPrice, DateTime offerExpiryDate, Integer quantity, ArrayList<FixedPriceOfferRecipient> recipients) {
        OfferPrice = offerPrice;
        OfferExpiryDate = offerExpiryDate;
        Quantity = quantity;
        Recipients = recipients;
    }

    public Integer getOfferPrice() {
        return OfferPrice;
    }

    public DateTime getOfferExpiryDate() {
        return OfferExpiryDate;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public ArrayList<FixedPriceOfferRecipient> getRecipients() {
        return Recipients;
    }
}
