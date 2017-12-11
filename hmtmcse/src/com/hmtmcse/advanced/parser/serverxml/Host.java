package com.hmtmcse.advanced.parser.serverxml;

import java.util.List;

/**
 * Created by touhid on 17/01/2016.
 */
public class Host {

    public String name;
    public String appBase;
    public List<String> alias;
    public Boolean unpackWARs;
    public Boolean autoDeploy;

    public Host(String name,String appBase,List<String> alias,Boolean unpackWARs,Boolean autoDeploy){
        this.name = name;
        this.appBase = appBase;
        this.alias = alias;
        this.unpackWARs = unpackWARs;
        this.autoDeploy = autoDeploy;
    }

    public Boolean getAutoDeploy() {
        return this.autoDeploy;
    }

    public Boolean getUnpackWARs() {
        return this.unpackWARs;
    }

    public List<String> getAlias() {
        return this.alias;
    }

    public String getAppBase() {
        return this.appBase;
    }


    public String getName() {
        return this.name;
    }
}
