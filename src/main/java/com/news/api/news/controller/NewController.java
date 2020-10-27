package com.news.api.news.controller;

import com.news.api.news.model.New;
import com.news.api.news.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewController {
    @Autowired
    private NewService newService;

    @RequestMapping("/news")
    public List<New> getAll() {
        return newService.getAllNews();
    }

    @RequestMapping("/news/{id}")
    public Optional<New> getNew(@PathVariable Long id) {
        return newService.getNew(id);
    }

    @RequestMapping("/news/{nPage}/{nItems}")
    public List<New> getAllPaginated(@PathVariable int nPage, @PathVariable int nItems) {
        return newService.getNewsPagination(nPage, nItems);
    }

    @RequestMapping("/feeds/{idFeed}/news")
    public List<New> getNewsByFeed(@PathVariable Long idFeed) {
        return newService.getNewsByFeed(idFeed);
    }

    @RequestMapping("/feeds/{idFeed}/news/{nPage}/{nItems}")
    public List<New> getNewsByFeedPaginated(@PathVariable Long idFeed, @PathVariable int nPage, @PathVariable int nItems) {
        return newService.getNewsByFeedPagination(idFeed, nPage, nItems);
    }

}
