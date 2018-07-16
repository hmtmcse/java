package com.hmtmcse.gitflow;

import com.hmtmcse.io.directory.TextReadWrite;

import java.io.File;

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

    public static void push(){
        git("push --all");
    }


    public static void rebase(String branch){
        git("rebase " + branch);
    }

    public static void deletBranch(String branch){
        git("branch -D " + branch);
        git("push -d origin " + branch);
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


    public static void cleanAndDeleteBranch(){
        cleanHistory();
        deletBranch("developer");
        deletBranch("opt-1");
        deletBranch("opt-2");
    }



    public static void commit(String commit, String fileName){
        TextReadWrite textReadWrite = new TextReadWrite();
        textReadWrite.writeToFile(repository + File.separator + fileName + ".md", commit + "\n", true);
        git("add --all");
        git("commit -m \"" + commit + "\"");
    }


    public static void setup(){
        cleanAndDeleteBranch();

        checkout("master");
        commit("Master 1", "master");
        commit("Master 2", "master");
        push();

        createBranch("developer");
        commit("Dev 1", "dev");
        commit("Dev 2", "dev");
        push();

        checkout("master");
        commit("Master 3", "master");
        commit("Master 4", "master");
        push();

        createBranch("developer");
        rebase("master");
        push();

        createBranch("opt-1");
        commit("Opt-1 1", "opt-1");
        commit("Opt-1 2", "opt-1");
        push();

        checkout("developer");
        commit("Dev 3", "dev");
        commit("Dev 4", "dev");
        push();

        createBranch("opt-1");
        rebase("developer");
        push();


        checkout("developer");
        createBranch("opt-2");
        commit("Opt-2 1", "opt-2");
        commit("Opt-2 2", "opt-2");
        push();

        checkout("master");
        commit("Master 5", "master");
        commit("Master 6", "master");
        push();
    }

    public static void main(String[] args) {

        setup();

    }



}