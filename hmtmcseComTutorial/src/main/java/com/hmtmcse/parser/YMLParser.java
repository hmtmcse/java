package com.hmtmcse.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class YMLParser {


    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            YmlData ymlData = mapper.readValue(new File("G:\\serverAppG3\\JavaShell\\manager\\resources\\WebCommander-Multi-Tenant-application.yml"), YmlData.class);
            System.out.println("Yes");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
