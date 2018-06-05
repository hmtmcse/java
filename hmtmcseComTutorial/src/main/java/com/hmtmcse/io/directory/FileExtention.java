package com.hmtmcse.io.directory;

public class FileExtention {

    public static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(getFileExtension("touhid.text.css"));
    }

}
