package com.hmtmcse.html;

import java.util.List;

/**
 * Created by touhid on 18/07/2016.
 */
public class Form {

    public String action;
    public String method;
    public List<Input> inputs;
    public List<Select> selects;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public List<Select> getSelects() {
        return selects;
    }

    public void setSelects(List<Select> selects) {
        this.selects = selects;
    }
}
