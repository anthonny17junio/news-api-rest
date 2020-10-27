package com.news.api.news.newsCatcher.nos.model;

import com.news.api.news.model.New;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class NOSFile {
    private NOSRss rss;

    public NOSRss getRss() {
        return rss;
    }

    public List<New> getListNews() throws MalformedURLException {
        List<New> news = new ArrayList<>();
        if (this.rss != null) {
            news = rss.getListNews();
        }
        return news;
    }
}
