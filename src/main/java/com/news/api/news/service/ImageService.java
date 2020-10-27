package com.news.api.news.service;

import com.news.api.news.model.Image;
import com.news.api.news.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImage(Long newId) {
        return new ArrayList<>(imageRepository.findByNewNewId(newId));
    }
}
