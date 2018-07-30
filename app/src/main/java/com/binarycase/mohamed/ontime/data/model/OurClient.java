package com.binarycase.mohamed.ontime.data.model;

public class OurClient {

    String image;

    public OurClient() {
    }

    String name;
    String review;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public OurClient(String name, String image, String review) {
        this.name = name;
        this.image = image;
        this.review = review;
    }

}
