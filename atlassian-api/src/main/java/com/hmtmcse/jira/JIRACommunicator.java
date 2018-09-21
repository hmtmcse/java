package com.hmtmcse.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

import java.net.URI;

public class JIRACommunicator {


    public static String JIRA_URL = "https://jira.com.au/jira/";
    private String username;
    private String password;
    private JiraRestClient restClient;


    private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
    }

    public JIRACommunicator(String username, String password){
        this.username = username;
        this.password = password;
        this.restClient = getJiraRestClient();
    }


    public boolean isLoginSuccess(){
        try{
            restClient.getSessionClient().getCurrentSession().claim().getUsername();
        }catch (Exception e){
            return false;
        }
        return true;
    }


    private URI getJiraUri() {
        return URI.create(JIRA_URL);
    }


    public static void main(String[] args) {
        JIRACommunicator jiraCommunicator = new JIRACommunicator("apitest", "bmakabak99#");
        System.out.println("Login Success: " + jiraCommunicator.isLoginSuccess());
    }


    private Promise<SearchResult> JQLRunner(String jql) {
        return restClient.getSearchClient().searchJql(jql);
    }

}
