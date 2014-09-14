package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Photo {
    private Integer PhotoId;
    private PhotoURL Value;

    public Photo(Integer photoId, PhotoURL value) {
        PhotoId = photoId;
        Value = value;
    }

    public Integer getPhotoId() {
        return PhotoId;
    }

    public PhotoURL getValue() {
        return Value;
    }
}
