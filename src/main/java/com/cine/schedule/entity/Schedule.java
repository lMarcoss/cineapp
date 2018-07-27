package com.cine.schedule.entity;

import com.cine.movie.entity.Movie;

import java.util.Date;

public class Schedule {
    private int id;
    private Date date;
    private String hour;
    private String room;
    private double price;
    private Movie movie;

    public Schedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", date=" + date +
                ", hour='" + hour + '\'' +
                ", room='" + room + '\'' +
                ", price=" + price +
                ", movie=" + movie +
                '}';
    }
}
