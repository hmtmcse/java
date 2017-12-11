package com.hmtmcse.advanced.fileio;

/**
 * Created by touhid on 7/11/2016.
 */
public class FileInfoData {

    String text;
    String id;
    String icon;
    String type;
    Boolean children;

    public FileInfoData(String text,String id,String icon, Boolean children){
        this.text = text;
        this.id = id;
        this.icon = icon;
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
