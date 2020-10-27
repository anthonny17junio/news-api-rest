package com.news.api.news.applicationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "schedule") //application.properties
public class ApplicationProperties {
    private Integer time; //Time in catch new news

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}