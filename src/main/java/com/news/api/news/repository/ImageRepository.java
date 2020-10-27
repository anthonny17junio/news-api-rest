package com.news.api.news.repository;

import com.news.api.news.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {
    List<Image> findByNewNewId(Long newId);
}
