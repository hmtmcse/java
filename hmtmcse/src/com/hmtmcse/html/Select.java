package com.hmtmcse.html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 18/07/2016.
 */
public class Select {

    public String name;
    public String placeholder;
    public String raw;
    public List<Option> options;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void addOption(String name, String value) {
        if (options == null){
            options = new ArrayList<Option>();
        }
        Option option = new Option();
        option.setName(name);
        option.setValue(value);
        options.add(option);
    }



    class Option{
        String name;
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



    }

}
