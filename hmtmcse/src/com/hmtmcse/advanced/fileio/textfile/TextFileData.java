package com.hmtmcse.advanced.fileio.textfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 11/04/2016.
 */
public class TextFileData {

    public Integer totalLine;
    public String text;
    public Boolean isSuccess;
    public String errorMessage;
    public List<String> line = new ArrayList<String>();


    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(Integer totalLine) {
        this.totalLine = totalLine;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    public void addLine(String line){
        this.line.add(line);
    }

    public String getLine(Integer lineNumber){
        if (this.line.get(lineNumber) != null){
            return this.line.get(lineNumber);
        }else{
            return null;
        }
    }

}
