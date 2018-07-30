package com.binarycase.mohamed.ontime.data.model;

public class Service {

    String id;

    public Service(String id, String title, String price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    String price;
}
