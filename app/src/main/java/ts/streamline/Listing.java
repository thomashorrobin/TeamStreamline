package ts.streamline;

import java.util.Date;

/**
 * Created by Thomas on 9/14/2014.
 */
public class Listing {

    private long ListingId;
    private String Title;
    private String Category;
    private int StartPrice;
    private Date StartDate;
    private Date EndDate;
    private int ListingLength;
    private Boolean IsFeatured;
    private Boolean HasGallery;
    private Boolean IsBold;
    private int MaxBidAmount;
    private Date AsAt;
    private String CategoryPath;
    private String PictureHref;
    private Boolean HasPayNow;
    private String Region;
    private String Suburb;
    private int BidCount;
    private Boolean IsReserveMet;
    private Date NoteDate;
    private int ReserveState;
    private String PriceDisplay;

    public Listing(long listingId, String title, String category, int startPrice, Date startDate, Date endDate, int listingLength, Boolean isFeatured, Boolean hasGallery, Boolean isBold, int maxBidAmount, Date asAt, String categoryPath, String pictureHref, Boolean hasPayNow, String region, String suburb, int bidCount, Boolean isReserveMet, Date noteDate, int reserveState, String priceDisplay) {
        ListingId = listingId;
        Title = title;
        Category = category;
        StartPrice = startPrice;
        StartDate = startDate;
        EndDate = endDate;
        ListingLength = listingLength;
        IsFeatured = isFeatured;
        HasGallery = hasGallery;
        IsBold = isBold;
        MaxBidAmount = maxBidAmount;
        AsAt = asAt;
        CategoryPath = categoryPath;
        PictureHref = pictureHref;
        HasPayNow = hasPayNow;
        Region = region;
        Suburb = suburb;
        BidCount = bidCount;
        IsReserveMet = isReserveMet;
        NoteDate = noteDate;
        ReserveState = reserveState;
        PriceDisplay = priceDisplay;
    }

    public long getListingId() {
        return ListingId;
    }

    public void setListingId(long listingId) {
        ListingId = listingId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getStartPrice() {
        return StartPrice;
    }

    public void setStartPrice(int startPrice) {
        StartPrice = startPrice;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public int getListingLength() {
        return ListingLength;
    }

    public void setListingLength(int listingLength) {
        ListingLength = listingLength;
    }

    public Boolean getIsFeatured() {
        return IsFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        IsFeatured = isFeatured;
    }

    public Boolean getHasGallery() {
        return HasGallery;
    }

    public void setHasGallery(Boolean hasGallery) {
        HasGallery = hasGallery;
    }

    public Boolean getIsBold() {
        return IsBold;
    }

    public void setIsBold(Boolean isBold) {
        IsBold = isBold;
    }

    public int getMaxBidAmount() {
        return MaxBidAmount;
    }

    public void setMaxBidAmount(int maxBidAmount) {
        MaxBidAmount = maxBidAmount;
    }

    public Date getAsAt() {
        return AsAt;
    }

    public void setAsAt(Date asAt) {
        AsAt = asAt;
    }

    public String getCategoryPath() {
        return CategoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        CategoryPath = categoryPath;
    }

    public String getPictureHref() {
        return PictureHref;
    }

    public void setPictureHref(String pictureHref) {
        PictureHref = pictureHref;
    }

    public Boolean getHasPayNow() {
        return HasPayNow;
    }

    public void setHasPayNow(Boolean hasPayNow) {
        HasPayNow = hasPayNow;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getSuburb() {
        return Suburb;
    }

    public void setSuburb(String suburb) {
        Suburb = suburb;
    }

    public int getBidCount() {
        return BidCount;
    }

    public void setBidCount(int bidCount) {
        BidCount = bidCount;
    }

    public Boolean getIsReserveMet() {
        return IsReserveMet;
    }

    public void setIsReserveMet(Boolean isReserveMet) {
        IsReserveMet = isReserveMet;
    }

    public Date getNoteDate() {
        return NoteDate;
    }

    public void setNoteDate(Date noteDate) {
        NoteDate = noteDate;
    }

    public int getReserveState() {
        return ReserveState;
    }

    public void setReserveState(int reserveState) {
        ReserveState = reserveState;
    }

    public String getPriceDisplay() {
        return PriceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        PriceDisplay = priceDisplay;
    }


//    public Listing(long id, String t){
//        ListingId = id;
//        Title = t;
//    }

}