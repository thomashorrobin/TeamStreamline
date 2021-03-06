package ts.streamline;

import java.util.ArrayList;

/**
 * Created by Thomas on 9/14/2014.
 */
public class SearchParameter {

    private String DisplayName;
    private String Name;
    private String Type;

    public ArrayList<AttributeOption> getOptions() {
        return Options;
    }

    public void setOptions(ArrayList<AttributeOption> options) {
        Options = options;
    }

    private ArrayList<AttributeOption> Options;

    public SearchParameter(String displayName, String name, String type) {
        DisplayName = displayName;
        Name = name;
        Type = type;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
