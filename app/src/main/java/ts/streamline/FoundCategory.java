package ts.streamline;

/**
 * Created by Thomas on 9/14/2014.
 */
public class FoundCategory {

    private int Count;
    private String Category;
    private String Name;

    public FoundCategory(int count, String category, String name) {
        Count = count;
        Category = category;
        Name = name;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
