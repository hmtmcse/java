package com.miaisoft.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * Created by touhid on 21/09/2014.
 */
public class ParseHTMLContent {


    public static void main(String[] args) {
        String html = "<html><head><link href=\"/BOOKS/1d2edefb-6732-4fa0-afbd-4b38b87969da/OEBPS/css/Jilmil.css\" rel=\"stylesheet\" type=\"text/css\" /><link href=\"/BOOKS/1d2edefb-6732-4fa0-afbd-4b38b87969da/OEBPS/css/Jilmil.css\" rel=\"stylesheet\" type=\"text/css\" /><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        Element body =  doc.body();
        System.out.println(body.getElementsByTag("body").toString());

    }
}
