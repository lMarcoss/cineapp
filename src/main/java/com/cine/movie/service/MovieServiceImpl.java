package com.cine.movie.service;

import com.cine.movie.entity.Movie;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    private static final Logger LOG = Logger.getLogger(MovieServiceImpl.class);

    private List<Movie> listMovies;

    public MovieServiceImpl() {
        LOG.info("Create instance MovieServiceImpl");
        listMovies = getMovies();
    }

    @Override
    public List<Movie> getAll() {
        return listMovies;
    }

    @Override
    public void save(Movie movie) {
        listMovies.add(movie);
    }

    @Override
    public Movie getById(int id) {
        for (Movie movie : listMovies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public List<String> getGenres() {
        List<String> listGenres = new ArrayList<>();
        listGenres.add("Action");
        listGenres.add("Aventure");
        listGenres.add("Classical");
        listGenres.add("Romantic");
        listGenres.add("Drama");
        listGenres.add("Terror");
        listGenres.add("Childish");
        listGenres.add("Action and aventure");

        return listGenres;
    }

    private List<Movie> getMovies() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<Movie> listMovies = new LinkedList<>();
        try {
            Movie movie = new Movie();
            movie.setId(1);
            movie.setTitle("Infinitiy war");
            movie.setDuration(136);
            movie.setClasification("B");
            movie.setGenre("Action");
            movie.setDate(simpleDateFormat.parse("02-08-2018"));

            Movie movie1 = new Movie();
            movie1.setId(2);
            movie1.setTitle("Deadpool 2");
            movie1.setDuration(120);
            movie1.setClasification("B");
            movie1.setGenre("Action");
            movie1.setDate(simpleDateFormat.parse("01-09-2018"));

            Movie movie2 = new Movie();
            movie2.setId(3);
            movie2.setTitle("Black Panther");
            movie2.setDuration(110);
            movie2.setClasification("B");
            movie2.setGenre("Action");
            movie2.setDate(simpleDateFormat.parse("25-07-2018"));

            Movie movie3 = new Movie();
            movie3.setId(4);
            movie3.setTitle("Tomb Raider");
            movie3.setDuration(90);
            movie3.setClasification("B");
            movie3.setGenre("Action");
            movie3.setDate(simpleDateFormat.parse("28-07-2018"));

            Movie movie4 = new Movie();
            movie4.setId(5);
            movie4.setTitle("Ready Player One");
            movie4.setDuration(80);
            movie4.setClasification("B");
            movie4.setGenre("Action");
            movie4.setDate(simpleDateFormat.parse("01-01-2019"));

            Movie movie5 = new Movie();
            movie5.setId(6);
            movie5.setTitle("The beauty and the best");
            movie5.setDuration(85);
            movie5.setClasification("B");
            movie5.setGenre("Action");
            movie5.setPicture("estreno6.png");
            movie5.setDate(simpleDateFormat.parse("05-05-2019"));

            Movie movie6 = new Movie();
            movie6.setId(7);
            movie6.setTitle("Kong");
            movie6.setDuration(85);
            movie6.setClasification("B");
            movie6.setGenre("Action");
            movie6.setPicture("estreno4.png");
            movie6.setDate(simpleDateFormat.parse("06-05-2019"));
            movie6.setStatus("Inactive");

            listMovies.add(movie);
            listMovies.add(movie1);
            listMovies.add(movie2);
            listMovies.add(movie3);
            listMovies.add(movie4);
            listMovies.add(movie5);
            listMovies.add(movie6);
            return listMovies;
        } catch (ParseException e) {
            LOG.error(e.getMessage());
            return null;
        }

    }
}
