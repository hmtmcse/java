package com.hmtmcse.advanced.fileio.textfile;

import java.io.*;

/**
 * Created by touhid on 11/04/2016.
 */
public class TextFileReader {

    public  TextFileData textFileData;

    public TextFileReader(){
        textFileData = new TextFileData();
    }

    public TextFileReader(String location){
        textFileData = new TextFileData();
        fileToString(location);
    }

    public boolean isSuccess(){
        return textFileData.getSuccess();
    }

    public TextFileData fileToString(String location) {
        textFileData.setSuccess(false);
        File locationFile = new File(location);
        if (!locationFile.exists()) {
            textFileData.setErrorMessage("File Not Found");
            return textFileData;
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(locationFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
                textFileData.addLine(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            textFileData.setErrorMessage("FileNotFoundException message: " + e.getMessage());
        } catch (IOException e) {
            textFileData.setErrorMessage("IOException message: " + e.getMessage());
        }
        textFileData.setText(stringBuilder.toString());
        textFileData.setTotalLine(textFileData.getLine().size());
        return textFileData;
    }


    public String getLastLine(){
        return textFileData.getLine(textFileData.getTotalLine());
    }



}
