package com.cine.schedule.controller;

import com.cine.movie.service.IMovieService;
import com.cine.schedule.entity.Schedule;
import com.cine.schedule.service.IScheduleService;
import com.cine.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    private static final Logger LOG = Logger.getLogger(ScheduleController.class);

    @Autowired
    IScheduleService _iScheduleService;

    @Autowired
    private IMovieService _iMovieService;

    @GetMapping(value = {"/", ""})
    public String listSchedules() {
        return "schedules/schedules";
    }

    @GetMapping("/schedule")
    public String create(@ModelAttribute Schedule schedule, Model model) {
        model.addAttribute("listRooms", getRooms());
        model.addAttribute("listMovies", _iMovieService.getAll());
        return "schedules/form";
    }

    private List<String> getRooms() {
        List<String> listRooms = new ArrayList<>();
        listRooms.add("Premiun");
        listRooms.add("3D");
        listRooms.add("4D");
        listRooms.add("IMAX");
        return listRooms;
    }

    @PostMapping("/schedule")
    public String save(@ModelAttribute Schedule schedule, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            Util.printError(bindingResult.getAllErrors());
            model.addAttribute("listMovies", _iMovieService.getAll());
            model.addAttribute("listRooms", getRooms());
            return "schedules/form";
        } else {
            // save schedule
            _iScheduleService.save(schedule);
            LOG.info(schedule);
            redirectAttributes.addFlashAttribute("message", "Schedule added successful");
            return "redirect:/schedules/";
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
