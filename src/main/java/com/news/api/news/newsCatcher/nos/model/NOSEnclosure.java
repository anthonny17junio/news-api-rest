package com.news.api.news.newsCatcher.nos.model;

import java.net.MalformedURLException;
import java.net.URL;

public class NOSEnclosure {
    private String type;
    private String url;

    public URL getUrl() throws MalformedURLException {
        if (url != null) {
            return new URL(url);
        } else {
            return null;
        }
    }
}
