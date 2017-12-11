package com.hmtmcse.advanced.fileio;

import com.hmtmcse.advanced.http.HttpExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileDirectoryChangeChecker {

    private long lastModifiedTimeStamp;
    private final String lastModifiedMark = "lastModifiedMark.dat";
    private boolean isModified = false;


    private boolean isModified(File[] resourceList) {

        if (resourceList == null) return false;
        for (File list : resourceList) {

            if (list.getName().equals(lastModifiedMark)) {
                continue;
            }

            if (list.lastModified() > lastModifiedTimeStamp) {
                isModified = true;
                break;
            }
            if (list.isDirectory()) {
                isModified(list.listFiles());
            }
        }
        return false;
    }


    private void updateLastLog(String path) {
        FileDirectoryOperation fileDirectoryOperation = new FileDirectoryOperation();
        fileDirectoryOperation.export(lastModifiedTimeStamp + "", lastModifiedMark, path);
    }


    public boolean isModifiedSource(String path) throws HttpExceptionHandler {

        File home = new File(path);
        if (!home.exists()) {
            throw new HttpExceptionHandler("Invalid Location");
        }

        File mark = new File(path + File.separator + lastModifiedMark);
        lastModifiedTimeStamp = System.currentTimeMillis();

        if (!mark.exists()) {
            updateLastLog(path);
        } else {
            lastModifiedTimeStamp = mark.lastModified();
        }

        if (home.lastModified() > lastModifiedTimeStamp) {
            updateLastLog(path);
            return true;
        }

        isModified(home.listFiles());
        if (isModified) {
            updateLastLog(path);
        }
        return isModified;
    }


    public static void main(String[] args) {
        FileDirectoryChangeChecker fw = new FileDirectoryChangeChecker();
        try {
            if (fw.isModifiedSource("C:\\Users\\Touhid Mia\\Desktop\\bootstrap")) {
                System.out.println("Modified");
            } else {
                System.out.println("Not Modified");
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            httpExceptionHandler.printStackTrace();
        }
    }


}
