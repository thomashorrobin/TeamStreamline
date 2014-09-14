package ts.streamline;

import java.util.ArrayList;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Questions {
    private Integer TotalCount;
    private Integer Page;
    private  Integer PageSize;
    private  ArrayList<Question> List;

    public Questions(Integer totalCount, Integer page, Integer pageSize, ArrayList<Question> list) {
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

    public ArrayList<Question> getList() {
        return List;
    }
}
