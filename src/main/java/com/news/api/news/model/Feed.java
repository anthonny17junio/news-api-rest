package com.news.api.news.model;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url_source")
    private URL url;
    private String name;

    @OneToMany(mappedBy = "feed")
    private List<New> news;

    protected Feed() {
    }

    public Feed(long id, URL url) {
        this.id = id;
        this.url = url;
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

    public String getName() {
        return name;
    }
}
