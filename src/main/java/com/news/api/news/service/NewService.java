package com.news.api.news.service;

import com.news.api.news.model.New;
import com.news.api.news.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService {

    @Autowired
    private NewRepository newRepository;

    public List<New> getAllNews() {
        return new ArrayList<>(newRepository.findAllByOrderByDateDesc());
    }

    public Optional<New> getNew(Long id) {
        return newRepository.findById(id);
    }

    public Optional<New> getNewByGUIDAndFeed(String guid, Long feedId) {
        return newRepository.findByGuidAndFeed(guid, feedId);
    }

    public void addNew(New newNew) {
        newRepository.save(newNew);
    }

    public List<New> getNewsPagination(int nPage, int nElements) {
        Pageable objPageable = PageRequest.of(nPage, nElements, Sort.by("date").descending());

        List<New> news = new ArrayList<>();
        for (New aNew : newRepository.findAll(objPageable)) {
            news.add(aNew);
        }
        return news;
    }

    public List<New> getNewsByFeed(Long idFeed) {
        return new ArrayList<>(newRepository.findByFeedIdOrderByDateDesc(idFeed));
    }

    public List<New> getNewsByFeedPagination(Long idFeed, int nPage, int nElements) {
        Pageable objPageable = PageRequest.of(nPage, nElements, Sort.by("date").descending());
        return new ArrayList<>(newRepository.findByFeedIdOrderByDateDesc(idFeed, objPageable));
    }

}
