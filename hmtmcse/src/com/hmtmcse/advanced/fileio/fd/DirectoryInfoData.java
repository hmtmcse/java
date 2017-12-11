package com.hmtmcse.advanced.fileio.fd;

import java.util.List;

public class DirectoryInfoData {

    public String name;
    public String absolutePath;
    public Long lastModified;
    public Boolean isDirectory = false;
    public List<DirectoryInfoData> subDirectory;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }

    public List<DirectoryInfoData> getSubDirectory() {
        return subDirectory;
    }

    public void setSubDirectory(List<DirectoryInfoData> subDirectory) {
        this.subDirectory = subDirectory;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
}
