package com.cine.news.controller;

import com.cine.news.model.News;
import com.cine.news.service.INewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final Logger LOG = Logger.getLogger(NewsController.class);

    @Autowired
    private INewsService _iNewsService;

    @GetMapping("/create")
    public String formNews() {
        return "news/form";
    }

    @PostMapping("save")
    public String save(News news) {
        _iNewsService.save(news);
        return "news/form";
    }
}
