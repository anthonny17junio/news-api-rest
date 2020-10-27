package com.news.api.news.newsCatcher;

import com.news.api.news.newsCatcher.nos.NOSNewsCatcher;

public class NewsCatcherFactory {
    public NewsCatcher createNewsCatcher(String feedName) {
        if (feedName.equals("nosfeed")) { //Feed name stored in db
            return new NOSNewsCatcher();
        } else {
            return null;
        }
    }
}
