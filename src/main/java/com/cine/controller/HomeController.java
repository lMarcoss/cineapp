package com.cine.controller;

import com.cine.model.Movie;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome() {
        return "home";
    }

    @GetMapping("/")
    public String showHome(Model model) {
        List<Movie> listMovies = getMovies();
        model.addAttribute("listMovies", listMovies);
        return "home";
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

            listMovies.add(movie);
            listMovies.add(movie1);
            listMovies.add(movie2);
            listMovies.add(movie3);
            listMovies.add(movie4);
            return listMovies;
        } catch (ParseException e) {
            LOG.error(e.getMessage());
            return null;
        }

    }

    @RequestMapping(value = "/detail")
    public String mostrarDetalle(Model model) {
        String titleMovie = "Fast and furious";
        int duration = 136;
        long price = 50;
        model.addAttribute("titleMovie", titleMovie);
        model.addAttribute("duration", duration);
        model.addAttribute("price", price);
        return "detail";
    }
}
