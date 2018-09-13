package com.hmtmcse.gitflow;

import com.hmtmcse.io.directory.TextReadWrite;

import java.io.File;

public class GitFlowMain {


    static String repository = "C:\\Users\\hmtmc\\OneDrive\\Desktop\\codes\\master";

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
        rebasePull();
    }


    public static void rebase(String branch){
        git("rebase " + branch);
    }

    public static void deletBranch(String branch){
        git("branch -D " + branch);
        git("push -d origin " + branch);
    }


    public static void cleanHistory(){
        git("checkout master");
        git("checkout --orphan backup_branch");
        git("add -A");
        git("commit -am \"bismillah\"");
        git("branch -D master");
        git("branch -m master");
        git("push -f origin master");
        git("branch --set-upstream-to=origin/master master");
        git("pull");
    }

    public static void deleteFile(String fileName){
        File file = new File(concatFile(fileName));
        if (file.exists()){
            file.delete();
        }

    }

    public static void cleanAndDeleteBranch(){
        cleanHistory();
        deletBranch("development");
        deletBranch("opt-1");
        deletBranch("opt-2");

        deleteFile("dev");
        deleteFile("master");
        deleteFile("opt-1");
        deleteFile("opt-2");
    }


    public static String concatFile(String fileName){
        return repository + File.separator + fileName + ".md";
    }


    public static void commit(String commit, String fileName){
        TextReadWrite textReadWrite = new TextReadWrite();
        textReadWrite.writeToFile(concatFile(fileName), commit + "\n", true);
        git("add .");
        git("commit -am \"" + commit + "\"");
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


        checkout("developer");
        rebase("master");
        rebasePull();
        push();


        checkout("developer");
        createBranch("opt-1");
        commit("Opt-1 1", "opt-1");
        commit("Opt-1 2", "opt-1");
        push();

        checkout("developer");
        commit("Dev 3", "dev");
        commit("Dev 4", "dev");
        push();

        checkout("opt-1");
        rebase("developer");
        rebasePull();
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

        checkout("developer");
        rebase("master");
        rebasePull();
        push();

        checkout("opt-1");
        rebase("developer");
        rebasePull();
        push();

        checkout("opt-2");
        rebase("developer");
        rebasePull();
        push();

    }

    public static void main(String[] args) {

        cleanAndDeleteBranch();

    }



}
