package ts.streamline;

import org.joda.time.DateTime;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Sale {

    private  Integer  PurchaseId;
    private  String ReferenceNumber;
    private  DateTime SoldDate;
    private  enum Method{ Auction	(0),BuyNow	(1),Offer	(2);
        private int code;
        private Method(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }

    }

    private   String SelectedShipping;
    private  Integer  ShippingPrice;
    private   enum ShippingType{    None	(0), Unknown	(0),Undecided	(1), Pickup	(2),Free	(3),Custom	(4);
        private int code;
        private ShippingType(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }
    }

    private  Member Buyer;
    private  Integer QuantitySold;
    private  Integer Price;
    private  Integer SubtotalPrice;
    private  Integer TotalShippingPrice;
    private  Integer TotalSalePrice;
    private  boolean HasSellerPlacedFeedback;
    private  boolean HasBuyerPlacedFeedback;
    private  boolean DeliveryDetailsSent;
    private  Address DeliveryAddress;
    private  String MessageFromBuyer;
    private  String PaymentInstructions;
    private  boolean  HasPaidByCreditCard;
    private DateTime CreditCardPaymentDate;
    private 	String CreditCardType;
    private  String CreditCardLastFourDigits;
    private  Integer OrderId;
    ShippingType ShippingType;
    Method Method;

    public Sale(Integer purchaseId, String referenceNumber, DateTime soldDate, int m, String selectedShipping, Integer shippingPrice, int s, Member buyer, Integer quantitySold, Integer price, Integer subtotalPrice, Integer totalShippingPrice, Integer totalSalePrice, boolean hasSellerPlacedFeedback, boolean hasBuyerPlacedFeedback, boolean deliveryDetailsSent, Address deliveryAddress, String messageFromBuyer, String paymentInstructions, boolean hasPaidByCreditCard, DateTime creditCardPaymentDate, String creditCardType, String creditCardLastFourDigits, Integer orderId) {
        ShippingType = ShippingType.values()[s];
        Method = Method.values()[m];
        PurchaseId = purchaseId;
        ReferenceNumber = referenceNumber;
        SoldDate = soldDate;
        SelectedShipping = selectedShipping;
        ShippingPrice = shippingPrice;
        Buyer = buyer;
        QuantitySold = quantitySold;
        Price = price;
        SubtotalPrice = subtotalPrice;
        TotalShippingPrice = totalShippingPrice;
        TotalSalePrice = totalSalePrice;
        HasSellerPlacedFeedback = hasSellerPlacedFeedback;
        HasBuyerPlacedFeedback = hasBuyerPlacedFeedback;
        DeliveryDetailsSent = deliveryDetailsSent;
        DeliveryAddress = deliveryAddress;
        MessageFromBuyer = messageFromBuyer;
        PaymentInstructions = paymentInstructions;
        HasPaidByCreditCard = hasPaidByCreditCard;
        CreditCardPaymentDate = creditCardPaymentDate;
        CreditCardType = creditCardType;
        CreditCardLastFourDigits = creditCardLastFourDigits;
        OrderId = orderId;
    }

    public Integer getPurchaseId() {
        return PurchaseId;
    }

    public String getReferenceNumber() {
        return ReferenceNumber;
    }

    public DateTime getSoldDate() {
        return SoldDate;
    }

    public String getSelectedShipping() {
        return SelectedShipping;
    }

    public Integer getShippingPrice() {
        return ShippingPrice;
    }

    public Member getBuyer() {
        return Buyer;
    }

    public Integer getQuantitySold() {
        return QuantitySold;
    }

    public Integer getPrice() {
        return Price;
    }

    public Integer getSubtotalPrice() {
        return SubtotalPrice;
    }

    public Integer getTotalShippingPrice() {
        return TotalShippingPrice;
    }

    public Integer getTotalSalePrice() {
        return TotalSalePrice;
    }

    public boolean isHasSellerPlacedFeedback() {
        return HasSellerPlacedFeedback;
    }

    public boolean isHasBuyerPlacedFeedback() {
        return HasBuyerPlacedFeedback;
    }

    public boolean isDeliveryDetailsSent() {
        return DeliveryDetailsSent;
    }

    public Address getDeliveryAddress() {
        return DeliveryAddress;
    }

    public String getMessageFromBuyer() {
        return MessageFromBuyer;
    }

    public String getPaymentInstructions() {
        return PaymentInstructions;
    }

    public boolean isHasPaidByCreditCard() {
        return HasPaidByCreditCard;
    }

    public DateTime getCreditCardPaymentDate() {
        return CreditCardPaymentDate;
    }

    public String getCreditCardType() {
        return CreditCardType;
    }

    public String getCreditCardLastFourDigits() {
        return CreditCardLastFourDigits;
    }

    public Integer getOrderId() {
        return OrderId;
    }
}
