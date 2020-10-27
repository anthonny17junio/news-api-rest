package com.news.api.news.model;

import javax.persistence.*;
import java.net.URL;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private URL url;

    @ManyToOne(cascade = CascadeType.ALL)
    private New newNew;

    protected Image() {
    }

    public Image(long id, URL url, New newNew) {
        this.id = id;
        this.url = url;
        this.newNew = newNew;
    }

    public Long getId() {
        return id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

}
