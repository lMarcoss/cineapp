package com.cine.banner.controller;

import com.cine.banner.entity.Banner;
import com.cine.banner.service.IBannerService;
import com.cine.util.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/banners")
public class BannerController {

    private static final Logger LOG = Logger.getLogger(BannerController.class);

    @Autowired
    IBannerService _iBannerService;

    @GetMapping(value = {"", "/"})
    public String listBanners(Model model) {
        model.addAttribute("listBanners", _iBannerService.getAll());
        return "banners/banners";
    }

    @GetMapping("/create")
    public String create() {
        return "banners/form";
    }

    @PostMapping("/save")
    public String save(Banner banner, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                       @RequestParam("picture") MultipartFile multipartFile, HttpServletRequest httpServletRequest) {

        String nameFile = Util.validateAndSavePicture(multipartFile, httpServletRequest);
        if (nameFile != null) {
            banner.setPicture(nameFile);
        }

        if (bindingResult.hasErrors()) {
            Util.printError(bindingResult.getAllErrors());
            return "/banners/form";
        } else {
            redirectAttributes.addFlashAttribute("message", "Banner added successful");
            _iBannerService.save(banner);
            return "redirect:/banners/";
        }


    }
}
