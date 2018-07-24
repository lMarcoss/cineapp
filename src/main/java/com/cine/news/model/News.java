package com.cine.news.model;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private Date date;
    private String detail;
    private String status;

    public News() {
        this.date = new Date();
        this.status = "Active";
    }

    public News(int id, String title, Date date, String detail, String status) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.detail = detail;
        this.status = status;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", detail='" + detail + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
