package ts.streamline;

import java.util.ArrayList;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Dealership {
   	Integer Id;
           	String Name;
            	String Address;
    String Suburb;
    String City;
    String PhoneNumber;
    String FaxNumber;
    String Website;
    String Logo;
    ArrayList<Dealer> Dealers;

    public Dealership(Integer id, String name, String address, String suburb, String city, String phoneNumber, String faxNumber, String website, String logo, ArrayList<Dealer> dealers) {
        Id = id;
        Name = name;
        Address = address;
        Suburb = suburb;
        City = city;
        PhoneNumber = phoneNumber;
        FaxNumber = faxNumber;
        Website = website;
        Logo = logo;
        Dealers = dealers;
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

    public ArrayList<Dealer> getDealers() {
        return Dealers;
    }
}
