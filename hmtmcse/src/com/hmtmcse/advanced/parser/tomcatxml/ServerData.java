package com.hmtmcse.advanced.parser.tomcatxml;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 7/03/2016.
 */
public class ServerData {
    public String shutdown;
    public List<ConnectorData> connectorDataList = new ArrayList<ConnectorData>();
    public List<HostData> hostDataList = new ArrayList<HostData>();

    public String getShutdown() {
        return shutdown;
    }

    public void setShutdown(String shutdown) {
        this.shutdown = shutdown;
    }

    public List<ConnectorData> getConnectorDataList() {
        return connectorDataList;
    }

    public void setConnectorDataList(List<ConnectorData> connectorDataList) {
        this.connectorDataList = connectorDataList;
    }

    public List<HostData> getHostDataList() {
        return hostDataList;
    }

    public void setHostDataList(List<HostData> hostDataList) {
        this.hostDataList = hostDataList;
    }
}
