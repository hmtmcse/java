package com.hmtmcse.gitflow;

public class GitFlowMain {


    static String repository = "F:\\touhid\\GitExperiment\\git_experiment";

    public static void git(String command){
        GitCommandRunner.git("git " + command, repository);
    }


    public static void checkout(String branchName){
        git("checkout " + branchName);
    }

    public static void createBranch(String branchName){
        git("checkout -b " + branchName);
    }

    public static void rebasePull(){
        git("pull --rebase");
    }


    public static void rebase(String branch){
        git("rebase " + branch);
    }


    public static void cleanHistory(){
        git("checkout --orphan backup_branch");
        git("add -A");
        git("commit -am \"bismillah\"");
        git("branch -D master");
        git("branch -m master");
        git("push -f origin master");
        git("branch --set-upstream-to=origin/master master");
        git("pull");
    }


    public static void main(String[] args) {
        cleanHistory();
    }



}
