package com.news.api.news.newsCatcher;

import com.news.api.news.model.Feed;
import com.news.api.news.model.New;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface NewsCatcher {
    List<New> getNews(Feed feed) throws IOException, ParserConfigurationException, SAXException, TransformerException;
}
