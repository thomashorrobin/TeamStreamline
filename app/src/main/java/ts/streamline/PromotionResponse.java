package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class PromotionResponse {
   private Integer Id;
    private Integer Threshold;
    private Integer ThresholdTypeId;
    private Integer ShippingPrice;
    private String ShippingDescription;
    private Integer ShippingOptionType;
    private Boolean IsActive;

    public PromotionResponse(Integer Id, Integer Threshold, Integer ThresholdTypeId, Integer ShippingPrice, String ShippingDescription, Integer ShippingOptionType, Boolean IsActive){
        this.Id = Id;
        this.Threshold = Threshold;
        this.ThresholdTypeId= ThresholdTypeId;
        this.ShippingPrice = ShippingPrice;
        this.ShippingDescription = ShippingDescription;
        this.ShippingOptionType =ShippingOptionType;
        this.IsActive =IsActive;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getThreshold() {
        return Threshold;
    }

    public Integer getThresholdTypeId() {
        return ThresholdTypeId;
    }

    public Integer getShippingPrice() {
        return ShippingPrice;
    }

    public String getShippingDescription() {
        return ShippingDescription;
    }

    public Integer getShippingOptionType() {
        return ShippingOptionType;
    }

    public Boolean getIsActive() {
        return IsActive;
    }
}
