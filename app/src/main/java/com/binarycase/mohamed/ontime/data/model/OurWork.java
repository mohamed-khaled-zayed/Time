package com.binarycase.mohamed.ontime.data.model;

public class OurWork {

    String name;
    String image;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public OurWork(String name,String image, String url, String description) {
        this.name = name;
        this.image = image;
        this.url = url;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    String description;

}
