package com.news.api.news.newsCatcher.nos.model;


import com.news.api.news.model.New;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class NOSChannel {
    private List<NOSNew> item;

    public List<NOSNew> getNews() {
        return item;
    }

    public List<New> getListNews() throws MalformedURLException {
        List<New> news = new ArrayList<>();
        if (this.item != null && !this.item.isEmpty()) {
            for (NOSNew nosNew : item) {
                New newConverted = nosNew.getConverted();
                news.add(newConverted);
            }
        }
        return news;
    }
}