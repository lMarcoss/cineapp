package com.cine.contact.controller;

import com.cine.contact.entity.Contact;
import com.cine.contact.service.IContactService;
import com.cine.movie.service.IMovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Logger LOG = Logger.getLogger(ContactController.class);

    @Autowired
    private IContactService _iContactService;

    @Autowired
    private IMovieService _iMovieService;

    @GetMapping(value = {"/", ""})
    public String listContacts(Model model) {
        model.addAttribute("listContacts", _iContactService.getAll());
        return "contacts/contacts";
    }

    @GetMapping("/contact")
    public String create(@ModelAttribute Contact contact, Model model) {
        model.addAttribute("listNotifications", getTypeNotifications());
        model.addAttribute("listGenres", _iMovieService.getGenres());
        return "contacts/form";
    }

    @PostMapping("/contact")
    public String save(@ModelAttribute Contact contact) {
        LOG.info(contact);
        return "redirect:/contacts/";
    }

    private List<String> getTypeNotifications() {
        List<String> listNotifications = new ArrayList<>();
        listNotifications.add("Estrenos");
        listNotifications.add("Promociones");
        listNotifications.add("Noticias");
        listNotifications.add("Preventas");
        return listNotifications;
    }
}
