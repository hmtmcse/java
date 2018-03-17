package com.hmtmcse.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class ReadHtmlAndParseByJsoup {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("http://ieltsliz.com/ielts-listening/").get();
        Elements elements = document.select("ul li a");
        for (Element element: elements){
            System.out.println(element.ownText());
        }

    }

}
