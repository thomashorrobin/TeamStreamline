package ts.streamline;

/**
 * Created by Thomas on 9/14/2014.
 */
public class AttributeOption {

    private String Value;
    private String Display;

    public AttributeOption(String value, String display) {
        Value = value;
        Display = display;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getDisplay() {
        return Display;
    }

    public void setDisplay(String display) {
        Display = display;
    }
}
