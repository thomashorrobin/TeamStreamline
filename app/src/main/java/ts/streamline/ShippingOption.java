package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class ShippingOption {
    enum Type {
        None(0), Unknown(0),Undecided(1),Pickup(2),Free(3),Custom(4);
        private int code;
        private Type(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }
        }
    private Integer Price;
    private  String Method;
    private  Integer ShippingId;
    Type Type;

    public ShippingOption(int t, Integer price, String method, Integer shippingId) {
        Type = Type.values()[t];
        Price = price;
        Method = method;
        ShippingId = shippingId;
    }
}
