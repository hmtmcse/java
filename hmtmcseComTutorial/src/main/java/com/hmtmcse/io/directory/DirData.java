package com.hmtmcse.io.directory;

import java.util.ArrayList;
import java.util.List;

public class DirData {

    public String name;
    public String absolutePath;
    public Long lastModified;
    public Boolean isDirectory = false;
    public List<DirData> subDirectories = new ArrayList<>();

    public String getName() {
        return name;
    }

    public DirData setName(String name) {
        this.name = name;
        return this;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public DirData setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
        return this;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public DirData setLastModified(Long lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public DirData setDirectory(Boolean directory) {
        isDirectory = directory;
        return this;
    }

    public List<DirData> getSubDirectories() {
        return subDirectories;
    }

    public DirData setSubDirectories(List<DirData> subDirectories) {
        this.subDirectories = subDirectories;
        return this;
    }

    public static DirData instance(){
        return new DirData();
    }
}
