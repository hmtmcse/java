package com.hmtmcse.interfaceTesting;

/**
 * Created by Tou on 28/02/2015.
 */
public abstract class WorkBuilder {

    public abstract Object preWork();
    public abstract void postWork(Object obj);
    
    public void execute(){
        System.out.println("Hi Janu");
        
    }
    
}
