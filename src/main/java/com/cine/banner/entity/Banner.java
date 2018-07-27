package com.cine.banner.entity;

import com.cine.util.Util;

import java.text.ParseException;
import java.util.Date;

public class Banner {
    private int id;
    private String title;
    private Date dateCreation;
    private String picture;
    private String status;

    public Banner() {
        try {
            this.dateCreation = Util.getDateToday();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.status = "Active";
        this.picture = "cinema.png";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
