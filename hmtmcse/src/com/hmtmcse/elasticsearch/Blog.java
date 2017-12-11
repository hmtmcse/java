package com.hmtmcse.elasticsearch;

import com.hmtmcse.advanced.filter.list.Data;

/**
 * Created by touhid on 7/09/2016.
 */
public class Blog {

    public String name;
    public String url;
    public Integer id;
    public Data updated;
    public String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Data getUpdated() {
        return updated;
    }

    public void setUpdated(Data updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }





}
