package com.cine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome() {
        return "home";
    }

    @GetMapping("/")
    public String showHome(Model model) {
        List<String> listMovies = new LinkedList<>();
        listMovies.add("Fast and furious");
        listMovies.add("DeadPool 2");
        listMovies.add("Infinitiy war");
        listMovies.add("Blank Panter");
        model.addAttribute("movies", listMovies);
        return "home";
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
