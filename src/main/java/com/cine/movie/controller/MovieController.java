package com.cine.movie.controller;

import com.cine.movie.entity.Movie;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private static final Logger LOG = Logger.getLogger(MovieController.class);

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
        LOG.info(movie.toString());
        return "movies/form";
    }
}
