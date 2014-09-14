package ts.streamline;

import java.util.ArrayList;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Agency {
    private Integer Id;
    private      String Name;
    private String    Address;
    private  String Suburb;
    private String City;
    private   String  PhoneNumber;
    private  String FaxNumber;
    private String Website;
    private String Logo;
    private ArrayList<Agent> Agents;
    private  boolean IsRealEstateAgency;
    private boolean IsJobAgency;
    private boolean IsLicensedPropertyAgency;

    public Agency(Integer id, String name, String address, String suburb, String city, String phoneNumber, String faxNumber, String website, String logo, ArrayList<Agent> agents, boolean isRealEstateAgency, boolean isJobAgency, boolean isLicensedPropertyAgency) {
        Id = id;
        Name = name;
        Address = address;
        Suburb = suburb;
        City = city;
        PhoneNumber = phoneNumber;
        FaxNumber = faxNumber;
        Website = website;
        Logo = logo;
        Agents = agents;
        IsRealEstateAgency = isRealEstateAgency;
        IsJobAgency = isJobAgency;
        IsLicensedPropertyAgency = isLicensedPropertyAgency;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getSuburb() {
        return Suburb;
    }

    public String getCity() {
        return City;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getFaxNumber() {
        return FaxNumber;
    }

    public String getWebsite() {
        return Website;
    }

    public String getLogo() {
        return Logo;
    }

    public ArrayList<Agent> getAgents() {
        return Agents;
    }

    public boolean isRealEstateAgency() {
        return IsRealEstateAgency;
    }

    public boolean isJobAgency() {
        return IsJobAgency;
    }

    public boolean isLicensedPropertyAgency() {
        return IsLicensedPropertyAgency;
    }
}
