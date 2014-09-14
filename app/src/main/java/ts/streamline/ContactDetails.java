package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class ContactDetails {
    private String ContactName;
    private String PhoneNumber;
    private String  MobilePhoneNumber;
    private  String BestContactTime;

    public ContactDetails(String contactName, String phoneNumber, String mobilePhoneNumber, String bestContactTime) {
        ContactName = contactName;
        PhoneNumber = phoneNumber;
        MobilePhoneNumber = mobilePhoneNumber;
        BestContactTime = bestContactTime;
    }

    public String getContactName() {
        return ContactName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return MobilePhoneNumber;
    }

    public String getBestContactTime() {
        return BestContactTime;
    }
}
