package com.cine.movie.service;

import com.cine.movie.entity.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> getAll();

    void save(Movie movie);

    Movie getById(int id);
}
