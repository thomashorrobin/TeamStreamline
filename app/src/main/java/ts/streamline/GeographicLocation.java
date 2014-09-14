package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class GeographicLocation {

    private Integer Latitude;
    private Integer  Longitude;
    private Integer  Northing;
    private Integer Easting;
    enum Accuracy{None	(0), Address	(1),Street	(3), Suburb	(2);
       private int code;
       private Accuracy(int c) {
           code = c;
       }
       public int getCode() {
           return code;
       }
   }
    Accuracy Accuracy;

    public GeographicLocation(Integer latitude, Integer longitude, Integer northing, Integer easting, int a) {
        Accuracy =Accuracy.values()[a];
        Latitude = latitude;
        Longitude = longitude;
        Northing = northing;
        Easting = easting;
    }
}
