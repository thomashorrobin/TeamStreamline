package ts.streamline;

import java.util.ArrayList;

/**
 * Created by Thomas on 9/14/2014.
 */
public class SearchResult {

    private int TotalCount;
    private int Page;
    private int PageSize;

    public ArrayList<SearchParameter> getParameters() {
        return Parameters;
    }

    public void setParameters(ArrayList<SearchParameter> parameters) {
        Parameters = parameters;
    }

    public ArrayList<SearchParameter> Parameters;

    public ArrayList<FoundCategory> getFoundCategories() {
        return FoundCategories;
    }

    public void setFoundCategories(ArrayList<FoundCategory> foundCategories) {
        FoundCategories = foundCategories;
    }

    private ArrayList<FoundCategory> FoundCategories;

    public ArrayList<Listing> getList() {
        return List;
    }

    public void setList(ArrayList<Listing> list) {
        List = list;
    }

    private ArrayList<Listing> List;

    public SearchResult(int totalCount, int page, int pageSize) {
        TotalCount = totalCount;
        Page = page;
        PageSize = pageSize;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }
}
