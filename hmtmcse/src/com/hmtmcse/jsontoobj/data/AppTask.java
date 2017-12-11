package com.hmtmcse.jsontoobj.data;

/**
 * Created by touhid on 3/01/2017.
 */
public class AppTask {

    OnBuild onBuild;
    OnPopulate onPopulate;

    public OnBuild getOnBuild() {
        return onBuild;
    }

    public void setOnBuild(OnBuild onBuild) {
        this.onBuild = onBuild;
    }

    public OnPopulate getOnPopulate() {
        return onPopulate;
    }

    public void setOnPopulate(OnPopulate onPopulate) {
        this.onPopulate = onPopulate;
    }
}
