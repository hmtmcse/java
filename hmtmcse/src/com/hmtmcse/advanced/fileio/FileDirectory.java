package com.hmtmcse.advanced.fileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by touhid on 12/01/2015.
 */
public class FileDirectory {


    public static void main(String[] args) {
        FileDirectory fileDirectory = new FileDirectory();
        try {
            fileDirectory.deletes("D:\\javatest\\touhid\\x\\");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public boolean createDir(String _path) throws IOException {
        Path path = Paths.get(_path);
        if (!Files.exists(path)){
            Files.createDirectory(path);
            return true;
        }else{
            return true;
        }
    }

    public boolean createDirs(String _path) throws IOException {
        Path path = Paths.get(_path);
        if (!Files.exists(path)){
            Files.createDirectories(path);
            return true;
        }else{
            return true;
        }
    }

    public void printDirs(String _path) throws IOException {
        Path path = Paths.get(_path);
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        for (Path file: stream) {
            System.out.println(file.getFileName());
        }
    }

    public boolean deletes(String _path) throws IOException {
        File file = new File(_path);
        if(file.isDirectory()){
            if(file.list().length==0){
                file.delete();
            }else{
                String files[] = file.list();
                for (String temp : files) {
                    File fileDelete = new File(file, temp);
                    deletes(fileDelete.toString());
                }
                if(file.list().length==0){
                    file.delete();
                }
            }

        }else{
            file.delete();
        }
        return true;
   }

    public void delete(String _path) throws IOException {
        Path path = Paths.get(_path);
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        for (Path file: stream) {
                Files.delete(file);
                System.out.println(file.getFileName() + " Deleted" );
        }
    }

}
