package com.news.api.news.service;

import com.news.api.news.model.Feed;
import com.news.api.news.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {

    @Autowired
    private FeedRepository feedRepository;

    public List<Feed> getAllFeeds() {
        List<Feed> feeds = new ArrayList<>();
        feedRepository.findAll()
                .forEach(feeds::add);
        return feeds;
    }
}
