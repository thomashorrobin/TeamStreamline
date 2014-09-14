package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Dealer {

    private String FullName;
    private String  Position;
    private String  MobilePhoneNumber;
    private  String OfficePhoneNumber;
    private  String EMail;
    private  String FaxNumber;
    private  String HomePhoneNumber;

    public Dealer(String fullName, String position, String mobilePhoneNumber, String officePhoneNumber, String EMail, String faxNumber, String homePhoneNumber) {
        FullName = fullName;
        Position = position;
        MobilePhoneNumber = mobilePhoneNumber;
        OfficePhoneNumber = officePhoneNumber;
        this.EMail = EMail;
        FaxNumber = faxNumber;
        HomePhoneNumber = homePhoneNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public String getPosition() {
        return Position;
    }

    public String getMobilePhoneNumber() {
        return MobilePhoneNumber;
    }

    public String getOfficePhoneNumber() {
        return OfficePhoneNumber;
    }

    public String getEMail() {
        return EMail;
    }

    public String getFaxNumber() {
        return FaxNumber;
    }

    public String getHomePhoneNumber() {
        return HomePhoneNumber;
    }
}
