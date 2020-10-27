package com.news.api.news.newsCatcher.nos;


import com.google.gson.Gson;
import com.news.api.news.model.Feed;
import com.news.api.news.model.New;
import com.news.api.news.newsCatcher.NewsCatcher;
import com.news.api.news.newsCatcher.nos.model.NOSFile;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class NOSNewsCatcher implements NewsCatcher {


    @Override
    public List<New> getNews(Feed feed) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        String stringXML = this.getStringXML(feed.getUrl());
        return getObjNews(stringXML);
    }

    //Convert String XML to List<New>
    private List<New> getObjNews(String stringXML) throws MalformedURLException {
        Gson g = new Gson();
        String xmlFile = XML.toJSONObject(stringXML).toString();
        NOSFile nosFile = g.fromJson(xmlFile, NOSFile.class);
        return nosFile.getListNews();
    }

    //Returns xml from URL
    private String getStringXML(URL url) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(url.openStream());
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(new DOMSource(doc), result);

        return writer.toString();
    }
}
