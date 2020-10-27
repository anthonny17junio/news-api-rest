package com.news.api.news.model;

import javax.persistence.*;
import java.net.URL;
import java.time.Instant;
import java.util.List;

@Entity
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private URL link;
    private String guid;
    private String title;
    private String description;
    @Column(name = "pubdate")
    private Instant date;

    @ManyToOne(cascade = CascadeType.ALL)
    private Feed feed;

    @OneToMany(mappedBy = "newNew", cascade = {CascadeType.ALL})
    private List<Image> images;

    protected New() {
    }

    public New(long id, URL url, String guid, String title, String description, Instant date, List<Image> images) {
        this.id = id;
        this.link = url;
        this.guid = guid;
        this.date = date;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDate() {
        return date;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
