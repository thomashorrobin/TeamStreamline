package ts.streamline;

import org.joda.time.DateTime;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Member {
    private Integer MemberId;
    private String Nickname;
    private DateTime DateAddressVerified;
    private  DateTime DateJoined;
    private  String Email;
    private Integer UniqueNegative;
    private  Integer UniquePositive;
    private  Integer FeedbackCount;
    private  Boolean IsAddressVerified;
    private  String  Suburb;
    private  String Region;
    private  Boolean IsDealer;
    private Boolean IsAuthenticated;

    public Member(Integer memberId, String nickname, DateTime dateAddressVerified, DateTime dateJoined, String email, Integer uniqueNegative, Integer uniquePositive, Integer feedbackCount, Boolean isAddressVerified, String suburb, String region, Boolean isDealer, Boolean isAuthenticated) {
        MemberId = memberId;
        Nickname = nickname;
        DateAddressVerified = dateAddressVerified;
        DateJoined = dateJoined;
        Email = email;
        UniqueNegative = uniqueNegative;
        UniquePositive = uniquePositive;
        FeedbackCount = feedbackCount;
        IsAddressVerified = isAddressVerified;
        Suburb = suburb;
        Region = region;
        IsDealer = isDealer;
        IsAuthenticated = isAuthenticated;
    }

    public Integer getMemberId() {
        return MemberId;
    }

    public String getNickname() {
        return Nickname;
    }

    public DateTime getDateAddressVerified() {
        return DateAddressVerified;
    }

    public DateTime getDateJoined() {
        return DateJoined;
    }

    public String getEmail() {
        return Email;
    }

    public Integer getUniqueNegative() {
        return UniqueNegative;
    }

    public Integer getUniquePositive() {
        return UniquePositive;
    }

    public Integer getFeedbackCount() {
        return FeedbackCount;
    }

    public Boolean getIsAddressVerified() {
        return IsAddressVerified;
    }

    public String getSuburb() {
        return Suburb;
    }

    public String getRegion() {
        return Region;
    }

    public Boolean getIsDealer() {
        return IsDealer;
    }

    public Boolean getIsAuthenticated() {
        return IsAuthenticated;
    }
}
