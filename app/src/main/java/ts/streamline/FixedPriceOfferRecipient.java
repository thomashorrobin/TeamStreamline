package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class FixedPriceOfferRecipient {
    private Member Member;
    private enum Decision {NoDecision	(0), Declined	(1), Accepted	(2);
        private int code;
        private Decision(int c) {
            code = c;
        }
        public int getCode() {
            return code;
        }
    }
    Decision Decision;

    public FixedPriceOfferRecipient(Member Member, int d)
    {
        Decision = Decision.values()[d];
        Member = Member;
    }

    public Member getMember() {
        return Member;
    }
}
