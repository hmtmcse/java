package com.hmtmcse.advanced.parser.tomcatxml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 7/03/2016.
 */
public class HostData {

    public String name;
    public String appBase;
    public boolean unpackWARs;
    public boolean autoDeploy;
    public List<String> alias = new ArrayList<String>();
}
