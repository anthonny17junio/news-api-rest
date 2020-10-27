package com.news.api.news.repository;
import com.news.api.news.model.New;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface NewRepository extends PagingAndSortingRepository<New, Long> {
    @Query(value = "SELECT * FROM New n where n.guid=?1 and n.feed_id=?2 LIMIT 1;", nativeQuery = true)
    Optional<New> findByGuidAndFeed(String guid, Long idFeed);

    List<New> findAllByOrderByDateDesc();

    List<New> findByFeedIdOrderByDateDesc(Long feedId);

    List<New> findByFeedIdOrderByDateDesc(Long feedId, Pageable pageable);
}
