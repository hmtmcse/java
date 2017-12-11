package com.hmtmcse.basic.consoletable;

/**
 * Created by touhid on 7/01/2016.
 */
public  class BuildReportData {

    private Integer sl;
    private String name;
    private String filename;
    private String ischange;
    private String buildtime;


    public BuildReportData(Integer sl, String name,String fileName,String isChange,String buildTime){
        this.ischange = isChange;
        this.filename = fileName;
        this.buildtime = buildTime;
        this.name = name;
        this.sl = sl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String fileName) {
        this.filename = fileName;
    }


    public String getIschange() {
        return ischange;
    }

    public void setIschange(String isChange) {
        this.ischange = isChange;
    }

    public String getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(String buildTime) {
        this.buildtime = buildTime;
    }

}
