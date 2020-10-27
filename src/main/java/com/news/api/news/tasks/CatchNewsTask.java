package com.news.api.news.tasks;

import com.news.api.news.model.Feed;
import com.news.api.news.model.New;
import com.news.api.news.newsCatcher.NewsCatcher;
import com.news.api.news.newsCatcher.NewsCatcherFactory;
import com.news.api.news.service.FeedService;
import com.news.api.news.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CatchNewsTask {
    @Autowired
    private NewService newService;

    @Autowired
    private FeedService feedService;

    public void catchNews() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        NewsCatcherFactory factory = new NewsCatcherFactory();
        for (Feed feed : feedService.getAllFeeds()) {
            NewsCatcher newsCatcher = factory.createNewsCatcher(feed.getName());
            if (newsCatcher != null) {
                List<New> listNews = newsCatcher.getNews(feed);
                for (New newToInsert : listNews) {
                    Optional<New> newDB = newService.getNewByGUIDAndFeed(newToInsert.getGuid(), feed.getId());
                    if (newDB.isEmpty()) {
                        newToInsert.setFeed(feed);
                        newService.addNew(newToInsert);
                    }
                }
            }
        }

    }
}
