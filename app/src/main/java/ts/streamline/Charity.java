package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Charity {
    private enum CharityType {ForestAndBird (1), Plunket (2);
        private int code;
        private CharityType(int c) {
            code = c;
        }

        public int getCode() {
            return code;
        }
    }

    private String ImageSource;


    private String Description;
    CharityType CharityType;

    public Charity(int c, String imageSource, String description) {
        CharityType = CharityType.values()[c];
        ImageSource = imageSource;
        Description = description;
    }


    public String getDescription() {
        return Description;
    }

    public String getImageSource() {
        return ImageSource;
    }
}
