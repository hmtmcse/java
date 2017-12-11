package com.hmtmcse.advanced.parser.tomcatxml;

/**
 * Created by touhid on 7/03/2016.
 */
public class ConnectorData {

    public String port;
    public String protocol;
    public String connectionTimeout;
    public String redirectPort;
    public String maxHttpHeaderSize;
    public String scheme;
    public String proxyPort;

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getRedirectPort() {
        return redirectPort;
    }

    public void setRedirectPort(String redirectPort) {
        this.redirectPort = redirectPort;
    }

    public String getMaxHttpHeaderSize() {
        return maxHttpHeaderSize;
    }

    public void setMaxHttpHeaderSize(String maxHttpHeaderSize) {
        this.maxHttpHeaderSize = maxHttpHeaderSize;
    }
}
