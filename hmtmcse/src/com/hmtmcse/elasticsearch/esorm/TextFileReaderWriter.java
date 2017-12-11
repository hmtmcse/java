package com.hmtmcse.elasticsearch.esorm;


//import com.webmascot.data.TextFileData;

import java.io.*;


public class TextFileReaderWriter {

    public TextFileData textFileData;
    public TextFileReaderWriter(){
        textFileData = new TextFileData();
    }
    public TextFileReaderWriter(String location){
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
            textFileData.setSuccess(true);
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
        if (textFileData.getTotalLine() > 0){
            return textFileData.getLine(textFileData.getTotalLine() - 1);
        }else{
            return textFileData.getLine(0);
        }
    }


}
