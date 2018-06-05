package com.hmtmcse.io.directory;

import java.io.FileWriter;
import java.io.IOException;

public class TextReadWrite {


    public void writeToFile(String location, String content, Boolean isAppend){
        try {
            FileWriter fileWriter = new FileWriter(location, isAppend);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeToFile(String location, String content){
            writeToFile(location, content, false);
    }


    public static void main(String[] args) {
        TextReadWrite textReadWrite = new TextReadWrite();
        textReadWrite.writeToFile("F:\\touhid\\java\\hmtmcseComTutorial\\resources\\style.css", "Touhid");

    }

}
