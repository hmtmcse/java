package com.hmtmcse.html;


import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 18/07/2016.
 */
public class HTMLFormParser {



    public static void main(String[] args) {
        Document doc = null;
        try {
//            File input = new File("D:\\touhid\\java\\hmtmcse\\src\\com\\hmtmcse\\html\\data.html");
//            doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            doc = Jsoup.connect("http://order-staging.webtogo.info/demolt/StoreAuth/SignIn").get();


            ObjectMapper mapper = new ObjectMapper();

            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString( parserForm(doc)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Form> parserForm(Document document) {
        Elements forms = document.select("form");
        List<Form> formList = new ArrayList<Form>();
        Form formData;
        for (Element form : forms) {
            formData = new Form();
            formData.setAction(form.attr("action"));
            formData.setMethod(form.attr("method"));
            formData.setInputs(formInputParser(form.select("input")));
            formData.setSelects(formSelectParser(form.select("select")));
            formList.add(formData);
        }
        return formList;
    }


    public static List<Input> formInputParser(Elements inputTypes){
        List<Input> inputs = new ArrayList<Input>();
        Input inputData;
        for (Element input : inputTypes){
            inputData = new Input();
            inputData.setName(input.attr("name"));
            inputData.setMaxLength(input.attr("maxlength"));
            inputData.setType(input.attr("type"));
            inputData.setPlaceholder(input.attr("placeholder"));
            inputData.setRaw(input.toString());
            inputs.add(inputData);
        }
        return inputs;
    }


    public static List<Select> formSelectParser(Elements selects){
        List<Select> selectList = new ArrayList<Select>();
        Select selectData;
        Elements options;

        for (Element select : selects){
            selectData = new Select();
            selectData.setName(select.attr("name"));
            selectData.setPlaceholder(select.attr("placeholder"));
            options = select.select("option");
            for (Element option : options){
                selectData.addOption(option.text(),option.attr("value"));
            }
            selectData.setRaw(select.toString());
            selectList.add(selectData);
        }
        return selectList;
    }

}



