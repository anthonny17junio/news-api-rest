package com.news.api.news.newsCatcher.nos.model;


import com.news.api.news.model.Image;
import com.news.api.news.model.New;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class NOSNew {
    private String link;
    private String description;
    private NOSGuid guid;
    private String title;
    private String pubDate;
    private NOSEnclosure enclosure;

    public New getConverted() throws MalformedURLException {
        URL url = new URL(this.link);

        String strGuid = null;
        if (guid != null) {
            strGuid = guid.getText();
        }

        Instant instantDate = null;
        if (pubDate != null) {

            instantDate = LocalDateTime.parse(pubDate, DateTimeFormatter.RFC_1123_DATE_TIME)
                    .atZone(
                            ZoneId.of(TimeZone.getDefault().getID())
                    ).toInstant();
        }

        New newToReturn = new New(0, url, strGuid, title, description, instantDate, null);

        List<Image> images = new ArrayList<>();
        if (enclosure != null) {
            Image image = new Image(0, enclosure.getUrl(), newToReturn);
            images.add(image);
        }

        newToReturn.setImages(images);

        return newToReturn;
    }
}
