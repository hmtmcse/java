package com.hmtmcse.interfaceTesting;

/**
 * Created by Tou on 28/02/2015.
 */
public class InterfaceTester {

    public static void main(String[] args) {
        
        new WorkBuilder() {
            @Override
            public Object preWork() {
                return null;
            }

            @Override
            public void postWork(Object string) {

            }
        }.execute();

    }
    
}
