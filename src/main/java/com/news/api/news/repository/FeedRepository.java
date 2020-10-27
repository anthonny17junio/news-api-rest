package com.news.api.news.repository;

import com.news.api.news.model.Feed;
import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, Long> {
}
