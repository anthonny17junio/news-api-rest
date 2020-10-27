package com.news.api.news.newsCatcher.nos.model;

import com.news.api.news.model.New;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class NOSRss {
    private NOSChannel channel;

    public NOSChannel getChannel() {
        return channel;
    }

    public List<New> getListNews() throws MalformedURLException {
        List<New> news = new ArrayList<>();
        if (this.channel != null) {
            news = channel.getListNews();
        }
        return news;
    }
}
