package com.hmtmcse.jsontoobj;

import com.hmtmcse.jsontoobj.data.AppTask;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by touhid on 3/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            AppTask appTask = mapper.readValue(new File("D:\\touhid\\java\\hmtmcse\\resources\\appTask.json"), AppTask.class);
            System.out.println("Hi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
