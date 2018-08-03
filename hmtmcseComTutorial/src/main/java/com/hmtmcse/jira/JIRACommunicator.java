package com.hmtmcse.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import java.net.URI;

public class JIRACommunicator {


    public static String JIRA_URL = "";
    private String username;
    private String password;


    private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
    }

    public JIRACommunicator(String username, String password){
        this.username = username;
        this.password = password;
    }


    public boolean isLoginSuccess(){
        getJiraRestClient();
        getJiraRestClient().getUserClient().getUser("apitest");
        return true;
    }

    private URI getJiraUri() {
        return URI.create(JIRA_URL);
    }


    public static void main(String[] args) {
        JIRACommunicator jiraCommunicator = new JIRACommunicator("", "");
        jiraCommunicator.isLoginSuccess();
    }


}
