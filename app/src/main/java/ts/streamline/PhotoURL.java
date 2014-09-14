package ts.streamline;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class PhotoURL {
   private String Thumbnail;
    private String List;
    private String Medium;
    private  String Gallery;
    private  String  Large;
    private  String FullSize;
    private Integer PhotoId;

    public PhotoURL(String thumbnail, String list, String medium, String gallery, String large, String fullSize, Integer photoId) {
        Thumbnail = thumbnail;
        List = list;
        Medium = medium;
        Gallery = gallery;
        Large = large;
        FullSize = fullSize;
        PhotoId = photoId;
    }

    public Integer getPhotoId() {
        return PhotoId;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public String getList() {
        return List;
    }

    public String getMedium() {
        return Medium;
    }

    public String getGallery() {
        return Gallery;
    }

    public String getLarge() {
        return Large;
    }

    public String getFullSize() {
        return FullSize;
    }
}
