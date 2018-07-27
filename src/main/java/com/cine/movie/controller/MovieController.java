package com.cine.movie.controller;

import com.cine.movie.entity.Movie;
import com.cine.movie.service.IMovieService;
import com.cine.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    public String create(@ModelAttribute Movie movie, Model model) {
        model.addAttribute("listGenres", _iMovieService.getGenres());
        return "movies/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Movie movie, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                       @RequestParam("picture") MultipartFile multipartFile, HttpServletRequest httpServletRequest) {

        String fileName = Util.validateAndSavePicture(multipartFile, httpServletRequest);
        if (fileName != null) {
            movie.setPicture(fileName);
        }

        if (bindingResult.hasErrors()) {
            Util.printError(bindingResult.getAllErrors());
            return "movies/form";
        } else {
            _iMovieService.save(movie);
            redirectAttributes.addFlashAttribute("message", "Movie added successful");
            LOG.info(movie.toString());
            LOG.info("movies: " + _iMovieService.getAll().size());
            return "redirect:/movies/";
        }
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
