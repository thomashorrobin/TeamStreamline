package ts.streamline;

import java.util.ArrayList;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class BidCollection {
    private Integer TotalCount;
    private Integer Page;
    private Integer   PageSize;
    private ArrayList<Bid> List;

    public BidCollection(Integer totalCount, Integer page, Integer pageSize, ArrayList<Bid> list) {
        TotalCount = totalCount;
        Page = page;
        PageSize = pageSize;
        List = list;
    }

    public Integer getTotalCount() {
        return TotalCount;
    }

    public Integer getPage() {
        return Page;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public ArrayList<Bid> getList() {
        return List;
    }
}
