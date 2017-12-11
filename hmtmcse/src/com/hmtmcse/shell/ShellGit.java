package com.hmtmcse.shell;

import java.io.File;

/**
 * Created by Touhid Mia on 03/01/2016.
 */
public class ShellGit {
    
    private ShellRunner shellRunner;
    private File sourceRoot;

    private final String GIT_BIN = "/usr/bin/";
    private final String PULL = GIT_BIN + "git pull";
    private final String LAST_LOG = GIT_BIN + "git log -1";
    private final String GIT_BRANCH = GIT_BIN + "git branch | grep '*'";
    private final String LAST_CHANGE_DETAILS = GIT_BIN + "git diff master@{1} master";
    private final String LAST_CHANGE_STAT = GIT_BIN + "git diff --stat master@{1} master";


    public ShellGit(String location) throws JavaShellExceptionHandler {
        sourceRoot = isExistFile(location);
    }

    public String pull(){
        
        return null;
    }

    public String lastLog(){
        return null;
    }

    public String selectedBranch(){
        return null;
    }


    public String lastPullChangesWrite(){
        return null;
    }

    public String lastPullChangesStatWrite(){
        return null;
    }

    private File isExistFile(String location) throws JavaShellExceptionHandler {
        File file = new File(location);
        if (!file.exists()){
            throw new JavaShellExceptionHandler("Shell Git Exception "  + location +  " File Not found" );
        }
        return file;
    }

}
