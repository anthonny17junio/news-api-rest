package com.news.api.news.controller;

import com.news.api.news.model.Feed;
import com.news.api.news.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    @Autowired
    private FeedService feedService;

    @RequestMapping("/feeds")
    public List<Feed> getAll() {
        return feedService.getAllFeeds();
    }

}
