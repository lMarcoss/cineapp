package com.cine.home;

import com.cine.movie.entity.Movie;
import com.cine.movie.service.IMovieService;
import com.cine.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");

    @Autowired
    private IMovieService _iMovieService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome() {
        return "home";
    }

    @GetMapping("/")
    public String showHome(Model model) {
        setDataHome(model, null);
        return "home";
    }

    private void setDataHome(Model model, String date) {
        List<String> listDates = Util.getNextDays(4);
        List<Movie> listMovies = _iMovieService.getAll();
        model.addAttribute("fechaActual", date == null ? simpleDateFormat.format(new Date()) : date);
        model.addAttribute("listMovies", listMovies);
        model.addAttribute("listDates", listDates);
    }


    /*@RequestMapping(value = "/detail/{id}/{fechaBusqueda}", method = RequestMethod.GET)
    public String mostrarDetalle(Model model, @PathVariable("id") int id, @PathVariable("fechaBusqueda") String fechaBusqueda) {*/
    @RequestMapping(value = "/detail", method = RequestMethod.GET)//RequestParam
    public String mostrarDetalle(Model model, @RequestParam("id") int id, @RequestParam("fechaBusqueda") String fechaBusqueda) {
        LOG.info(id);
        LOG.info(fechaBusqueda);
        model.addAttribute("movie", _iMovieService.getById(id));
        return "movies/detail";
    }

    @PostMapping("/search")
    public String searchByDate(Model model, @RequestParam("dateSearch") String date) {
        LOG.info(date);
        setDataHome(model, date);
        return "home";
    }
}
