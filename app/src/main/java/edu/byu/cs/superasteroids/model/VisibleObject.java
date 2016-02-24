package edu.byu.cs.superasteroids.model;

/**
 * Created by Azulius on 2/23/16.
 */
public class VisibleObject extends SuperObject {

    private String imagePath;
    private int imageWidth;
    private int imageHeight;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }
}
