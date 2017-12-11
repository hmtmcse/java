package com.hmtmcse.html;

import com.hmtmcse.advanced.fileio.FileReadWrite;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.hmtmcse.html.UrlDownload.fileDownload;

/**
 * Created by touhid on 18/07/2016.
 */
public class HTMLParser {

    public static void main(String[] args) {

        Document doc = null;
        String location = "C:\\Users\\touhid\\Dropbox\\IELTS (1)\\app\\resources\\english_speaking_basics\\3";
        try {

            Document list = Jsoup.connect("http://www.talkenglish.com/speaking/basics/speaking_basics_iii.aspx").get();
            Elements baseURLs = list.select(".steps-learn").get(0).select("a");
            baseURLs.remove(0);

            FileReadWrite fileReadWrite = new FileReadWrite();
            for (Element element1 : baseURLs) {
                StringBuilder stringBuilder = new StringBuilder();
                String url = "http://www.talkenglish.com" + element1.attr("href");
                System.out.println(element1.ownText() + " " + url);
                stringBuilder.append("Topic Name: " + element1.ownText() + "\n");
                stringBuilder.append("\n");
                stringBuilder.append("\n");

                doc = Jsoup.connect(url).get();
                Elements elements = doc.select("#GridView1 tbody td a");
                for (Element element : elements) {
                     url = element.attr("href");
                    String audioName = url.substring(url.lastIndexOf("/") + 1,url.length());
                    String row = "{sentence:\"" + element.ownText() + "\",audio:\"" + audioName + "\"},";
                    stringBuilder.append(row + "\n");
                    System.out.println(row);
                    fileDownload(url, location);
                    Thread.sleep(2000);
                }
                fileReadWrite.writeStringInFile( location + "\\" + element1.ownText() + ".txt",stringBuilder.toString());
            }
            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
