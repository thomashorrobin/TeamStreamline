package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Attribute {
    private String Name;
    private     String     DisplayName;
    private String Value;
    private enum Type{None	(0),
    Boolean	(1),
    Integer	(2),
    Decimal	(3),
    String	(4),
            DateTime	(5);
        private int code;
        private Type(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }

    }
    //AttributeRange Range
   //private ArrayList<AttributeOption> Options;
   private boolean IsRequiredForSell;
    Type Type;

    public Attribute(String Name, String displayName, String value,int t, boolean isRequiredForSell) {

        Name = Name;
        DisplayName = displayName;
        Value = value;
        IsRequiredForSell = isRequiredForSell;
        Type = Type.values()[t];
    }
}
