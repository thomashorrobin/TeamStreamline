package ts.streamline;

import java.util.ArrayList;
import org.joda.time.DateTime;
import java.lang.Integer;
/**
 * Created by CrystalJ on 14/09/2014.
 */
public class ListedItemDetail {
    Integer ListingId;
    String  Title;
    String Category;
    Double     StartPrice;
    Double  BuyNowPrice;
    	DateTime StartDate;
   DateTime  EndDate;
    Boolean IsFeatured;
    Boolean  HasGallery;
    Boolean IsBold;
    Boolean IsHighlighted;
    Boolean HasHomePageFeature;
    Double  MaxBidAmount;
    DateTime AsAt;
    String CategoryPath;
    Integer PhotoId;
    Boolean HasPayNow;
            Boolean IsNew;
    Integer  RegionId;
    String  Region;
    String Suburb;
    Integer BidCount;
    Integer ViewCount;
    Boolean IsReserveMet;
    Boolean  HasReserve;
    Boolean   HasBuyNow;
            DateTime NoteDate;
    String  CategoryName;
    enum ReserveState{
            None	(0),
    Met	(1),
            NotMet	(2),
    NotApplicable	(3);
        private int code;
        private ReserveState(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }
    }
    ArrayList<Attribute> Attributes;
    Boolean IsClassified;
    ArrayList<OpenHome> OpenHomes;
   Integer  RelistedItemId;
    String Subtitle;
    Integer ReservePrice;
    Boolean IsBuyNowOnly;
    Boolean HasMultiple;
    Integer Quantity;
    Boolean IsFlatShippingCharge;
    Integer RemainingGalleryPlusRelists;
   Double MinimumNextBidAmount;
    Boolean IsOnWatchList;
    GeographicLocation GeographicLocation;
            String PriceDisplay;
    Integer TotalReviewCount;
    Integer PositiveReviewCount;
    Boolean SendPaymentInstructions ;
    Boolean CanUsePayNowInstant	;
    String ExternalReferenceId	;
    Member	Member;
            String Body;
    BidCollection Bids;
    Questions	Questions;
    ArrayList<Photo> Photos;
    enum AllowsPickups{
    None	(0),
            Allow	(1),
            Demand	(2),
    Forbid	(3);

        private int code;
        private AllowsPickups(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }}
    ArrayList<ShippingOption> ShippingOptions;
    String PaymentOptions;
    Agency	Agency;
    ContactDetails	ContactDetails;
    Boolean IsOrNearOffer;
            Integer UnansweredQuestionCount;
    Boolean AuthenticatedMembersOnly;
    ArrayList<Sale> Sales;
    enum OfferStatus{
    None	(0),
    Active	(1),
    Withdrawn	(2),
    Expired	(3),
    Declined	(4),
    Accepted	(5);

        private int code;
        private OfferStatus(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }}
    FixedPriceOfferDetails PendingOffer;
    FixedPriceOfferDetails ClosedOffer;
    Boolean FirearmsLicenseRequiredToBuy;
    Boolean Over18DeclarationRequiredToBuy;
    Boolean CanOffer;
    Boolean    CanRelist;
    Boolean    WithdrawnBySeller;
    Charity DonationRecipient;
    boolean  IsInTradeProtected;
    boolean IsInCart;
    PromotionResponse CurrentShippingPromotion;
    OfferStatus OfferStatus;
    ReserveState ReserveState;
    AllowsPickups AllowsPickups;


    public ListedItemDetail(Integer listingId, String title, String category, Double startPrice, Double buyNowPrice, DateTime startDate, DateTime endDate, Boolean isFeatured, Boolean hasGallery, Boolean isBold, Boolean isHighlighted, Boolean hasHomePageFeature, Double maxBidAmount, DateTime asAt, String categoryPath, Integer photoId, Boolean hasPayNow, Boolean isNew, Integer regionId, String region, String suburb, Integer bidCount, Integer viewCount, Boolean isReserveMet, Boolean hasReserve, Boolean hasBuyNow, DateTime noteDate, String categoryName, int RS, ArrayList<Attribute> attributes, Boolean isClassified, ArrayList<OpenHome> openHomes, Integer relistedItemId, String subtitle, Integer reservePrice, Boolean isBuyNowOnly, Boolean hasMultiple, Integer quantity, Boolean isFlatShippingCharge, Integer remainingGalleryPlusRelists, Double minimumNextBidAmount, Boolean isOnWatchList, GeographicLocation geographicLocation, String priceDisplay, Integer totalReviewCount, Integer positiveReviewCount, Boolean sendPaymentInstructions, Boolean canUsePayNowInstant, String externalReferenceId, Member member, String body, BidCollection bids, Questions questions, ArrayList<Photo> photos, int AP, ArrayList<ShippingOption> shippingOptions, String paymentOptions, Agency agency, ContactDetails contactDetails, Boolean isOrNearOffer, Integer unansweredQuestionCount, Boolean authenticatedMembersOnly, ArrayList<Sale> sales, int OS, FixedPriceOfferDetails pendingOffer, FixedPriceOfferDetails closedOffer, Boolean firearmsLicenseRequiredToBuy, Boolean over18DeclarationRequiredToBuy, Boolean canOffer, Boolean canRelist, Boolean withdrawnBySeller, Charity donationRecipient, boolean isInTradeProtected, boolean isInCart, PromotionResponse currentShippingPromotion) {
      OfferStatus = OfferStatus.values()[OS];
        ReserveState = ReserveState.values()[RS];
        AllowsPickups = AllowsPickups.values()[AP];
        ListingId = listingId;
        Title = title;
        Category = category;
        StartPrice = startPrice;
        BuyNowPrice = buyNowPrice;
        StartDate = startDate;
        EndDate = endDate;
        IsFeatured = isFeatured;
        HasGallery = hasGallery;
        IsBold = isBold;
        IsHighlighted = isHighlighted;
        HasHomePageFeature = hasHomePageFeature;
        MaxBidAmount = maxBidAmount;
        AsAt = asAt;
        CategoryPath = categoryPath;
        PhotoId = photoId;
        HasPayNow = hasPayNow;
        IsNew = isNew;
        RegionId = regionId;
        Region = region;
        Suburb = suburb;
        BidCount = bidCount;
        ViewCount = viewCount;
        IsReserveMet = isReserveMet;
        HasReserve = hasReserve;
        HasBuyNow = hasBuyNow;
        NoteDate = noteDate;
        CategoryName = categoryName;
        Attributes = attributes;
        IsClassified = isClassified;
        OpenHomes = openHomes;
        RelistedItemId = relistedItemId;
        Subtitle = subtitle;
        ReservePrice = reservePrice;
        IsBuyNowOnly = isBuyNowOnly;
        HasMultiple = hasMultiple;
        Quantity = quantity;
        IsFlatShippingCharge = isFlatShippingCharge;
        RemainingGalleryPlusRelists = remainingGalleryPlusRelists;
        MinimumNextBidAmount = minimumNextBidAmount;
        IsOnWatchList = isOnWatchList;
        GeographicLocation = geographicLocation;
        PriceDisplay = priceDisplay;
        TotalReviewCount = totalReviewCount;
        PositiveReviewCount = positiveReviewCount;
        SendPaymentInstructions = sendPaymentInstructions;
        CanUsePayNowInstant = canUsePayNowInstant;
        ExternalReferenceId = externalReferenceId;
        Member = member;
        Body = body;
        Bids = bids;
        Questions = questions;
        Photos = photos;
        ShippingOptions = shippingOptions;
        PaymentOptions = paymentOptions;
        Agency = agency;
        ContactDetails = contactDetails;
        IsOrNearOffer = isOrNearOffer;
        UnansweredQuestionCount = unansweredQuestionCount;
        AuthenticatedMembersOnly = authenticatedMembersOnly;
        Sales = sales;
        PendingOffer = pendingOffer;
        ClosedOffer = closedOffer;
        FirearmsLicenseRequiredToBuy = firearmsLicenseRequiredToBuy;
        Over18DeclarationRequiredToBuy = over18DeclarationRequiredToBuy;
        CanOffer = canOffer;
        CanRelist = canRelist;
        WithdrawnBySeller = withdrawnBySeller;
        DonationRecipient = donationRecipient;
        IsInTradeProtected = isInTradeProtected;
        IsInCart = isInCart;
        CurrentShippingPromotion = currentShippingPromotion;
    }
}
