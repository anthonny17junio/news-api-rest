package com.news.api.news.controller;

import com.news.api.news.model.Image;
import com.news.api.news.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/news/{id}/images")
    public List<Image> getAllImages(@PathVariable Long id) {
        return imageService.getAllImage(id);
    }
}
