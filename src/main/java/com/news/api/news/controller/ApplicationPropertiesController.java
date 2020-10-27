package com.news.api.news.controller;

import com.news.api.news.applicationProperties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationPropertiesController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping("/properties/time")
    public Integer getSeconds() {
        return applicationProperties.getTime();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/properties/time/{timeInSeconds}")
    public void setTime(@PathVariable Integer timeInSeconds) {
        if (timeInSeconds > 0)
            applicationProperties.setTime(timeInSeconds);
        else
            throw new IllegalArgumentException(Integer.toString(timeInSeconds));
    }
}
