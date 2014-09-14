package ts.streamline;

import org.joda.time.DateTime;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class OpenHome {

    private DateTime Start;
    private DateTime End;

    public OpenHome(DateTime start, DateTime end) {
        Start = start;
        End = end;
    }

    public DateTime getStart() {
        return Start;
    }

    public DateTime getEnd() {
        return End;
    }
}
