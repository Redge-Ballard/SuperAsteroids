package edu.byu.cs.superasteroids.model;

/**
 * Created by Azulius on 2/23/16.
 */
public class ImageObject extends DataObject {

    private String imagePath;
    private int imageHeight;
    private int imageWidth;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }
}
