package com.mamunsproject.allsocialmediaplatform.Model;



public class SocialModel {

    String textview;
    int imageView;

    public SocialModel(String textview, int imageView) {
        this.textview = textview;
        this.imageView = imageView;
    }


    public String getTextview() {
        return textview;
    }

    public void setTextview(String textview) {
        this.textview = textview;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
