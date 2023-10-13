package com.example.musicstore;

import java.io.Serializable;

public class drums implements Serializable {

    private String name;
    private String seri;
    private String price;
    private String about;
    private String image;

    public drums(){

    }

    public drums(String name, String seri, String price, String about, String image) {
        this.name = name;
        this.seri = seri;
        this.price = price;
        this.about = about;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
