package com.hmtmcse.advanced.fileio;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.*;

/**
 * Created by touhid on 23/03/2016.
 */
public class FindAndReplace {


    public static void main(String args[]){
       FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.findAndReplace("D:\\touhid\\java\\hmtmcse\\resources\\findReplace.txt","Dog","Cat");
    }


    public void findAndReplace(String fileLocation, String search, String replace){
        String content = fileToString(fileLocation);
        String newContent;
        if (content != null){
            newContent = content.replaceAll(search,replace);
            writeStringToFile(fileLocation,newContent);
        }
    }


    public String fileToString(String location) {
        File locationFile = new File(location);
        if (!locationFile.exists()) {
            System.out.println("File Not Exists");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(locationFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception From File Not Found");
            return null;
        } catch (IOException e) {
            System.out.println("Exception From IO Operation");
            return null;
        }
        return stringBuilder.toString();
    }

    public boolean writeStringToFile(String location, String content){
        try {
            File destinationLoc = new File(location);
            if (!destinationLoc.exists()) {
                destinationLoc.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(destinationLoc.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
