package com.hmtmcse.io.directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdvanceFileDirectoryList {

    class ListingInfoData {
        String location;
        Boolean isRecursive = false;
        Boolean fileOnly = true;
        Boolean directoryOnly = true;
        Boolean filterExtension = null;

        public String getLocation() {
            return location;
        }

        public ListingInfoData setLocation(String location) {
            this.location = location;
            return this;
        }

        public Boolean getRecursive() {
            return isRecursive;
        }

        public ListingInfoData setRecursive(Boolean recursive) {
            isRecursive = recursive;
            return this;
        }

        public Boolean getFileOnly() {
            return fileOnly;
        }

        public ListingInfoData setFileOnly(Boolean fileOnly) {
            this.fileOnly = fileOnly;
            return this;
        }

        public Boolean getDirectoryOnly() {
            return directoryOnly;
        }

        public ListingInfoData setDirectoryOnly(Boolean directoryOnly) {
            this.directoryOnly = directoryOnly;
            return this;
        }

        public Boolean getFilterExtension() {
            return filterExtension;
        }

        public ListingInfoData setFilterExtension(Boolean filterExtension) {
            this.filterExtension = filterExtension;
            return this;
        }
    }

    public List<DirData> listDirectory(ListingInfoData  listingInfoData) {
        List<DirData> dirDataList = new ArrayList<>();
        File locationFile = new File(listingInfoData.getLocation());
        DirData dirData;
        if (locationFile.exists()) {
            for (File file : locationFile.listFiles()) {
                dirData = DirData.instance()
                        .setName(file.getName())
                        .setLastModified(file.lastModified())
                        .setAbsolutePath(file.getAbsolutePath());
                if (file.isDirectory() && !listingInfoData.getFileOnly()) {
                    dirData.setDirectory(true);
                    if (listingInfoData.getRecursive()){
                        listingInfoData.setLocation(file.getAbsolutePath());
                        dirData.setSubDirectories(listDirectory(listingInfoData));
                    }
                }
                dirDataList.add(dirData);
            }
        }
        return dirDataList;
    }


    public List<DirData> getDirectoryOnlyList(String location){
        return listDirectory(
                new ListingInfoData()
                        .setDirectoryOnly(true)
                        .setFileOnly(false)
                        .setRecursive(false)
                        .setLocation(location)
        );
    }

    public List<DirData> getDirectoryOnlyRecursiveList(String location){
        return listDirectory(
                new ListingInfoData()
                        .setDirectoryOnly(true)
                        .setRecursive(true)
                        .setLocation(location)
        );
    }
}
