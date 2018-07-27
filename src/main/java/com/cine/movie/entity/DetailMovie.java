package com.cine.movie.entity;

public class DetailMovie {
    private int id;
    private String manager;
    private String actors;
    private String sinopsis;
    private String trailer;

    public DetailMovie() {
        this.manager = "manager";
        this.actors = "actors";
        this.sinopsis = "sinopsis";
        this.trailer = "trailer";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        return "DetailMovie{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", actors='" + actors + '\'' +
                ", sipnosis='" + sinopsis + '\'' +
                ", trailer='" + trailer + '\'' +
                '}';
    }
}
