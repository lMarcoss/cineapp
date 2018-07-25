package com.cine.movie.controller;

import com.cine.movie.entity.Movie;
import com.cine.movie.service.IMovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private static final Logger LOG = Logger.getLogger(MovieController.class);

    @Autowired
    private IMovieService _iMovieService;

    @GetMapping(value = {"", "/"})
    public String showIndex(Model model) {
        List<Movie> listMovies = _iMovieService.getAll();
        model.addAttribute("listMovies", listMovies);
        return "movies/movies";
    }

    @GetMapping("/create")
    public String create() {
        return "movies/form";
    }

    @PostMapping("/save")
    public String save(Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.error(error.toString());
            }
        }
        _iMovieService.save(movie);
        LOG.info(movie.toString());
        LOG.info("movies: " + _iMovieService.getAll().size());
        return "movies/form";
    }

    /**
     * Al convertir String a Date el formato a esperar será dd-mm-yyyy
     *
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Para todas las propiedades de tipo Date, crear un objeto CustomDateEditor con formato simpleDateFormat y no permitir vacío
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
    }
}
