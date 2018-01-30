package com.hmtmcse.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupHtml {

    public static void main(String[] args) {
        Document doc = null;
        try {

            Document list = Jsoup.connect("http://www.talkenglish.com/speaking/basics/speaking_basics_i.aspx").get();
            Elements baseURLs = list.select(".steps-learn").get(0).select("a");
            baseURLs.remove(0);
            for (Element element1 : baseURLs) {
                StringBuilder stringBuilder = new StringBuilder();
                String url = "http://www.talkenglish.com" + element1.attr("href");
//                System.out.println(element1.ownText() + " " + url);
                System.out.println("<br><br>");
                System.out.println("* **" + element1.ownText() + "**");
                doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".sm2-playlist-bd span a");
                for (Element element : elements) {
                    System.out.println("  * " + element.text());
                    Thread.sleep(2000);
                }
                System.out.println("");
                System.out.println("");
            }
            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
