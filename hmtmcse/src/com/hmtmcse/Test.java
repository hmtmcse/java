package com.hmtmcse;

import com.sun.prism.impl.Disposer;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by touhid on 16/04/2015.
 */
public class Test {

    public static void main(String[] args) throws IOException {


        Date dt = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, 1);
        dt = calendar.getTime();
        System.out.println(dt.getTime() / 1000L);

        System.exit(0);


        System.out.println(UUID.randomUUID());

        String branch = "  2.1.5\n" +  "* master";
        System.out.println(branch.indexOf("*"));
        System.out.println("\u001B[32m" + "This is Mine");


        Integer a = 1;
        Integer b = 2;
        Integer sum = a + b;
        System.out.println(sum);

        int a1 = a;
        int b1 = 2;
        int sum1 = a1 + b1;
        System.out.println(sum1);

        String mac = "1866da1f7d39";
        mac = mac.toLowerCase();
        mac = mac.replaceAll("-","");
        System.out.println(mac.replaceAll(":",""));


        Process process = Runtime.getRuntime().exec("");




//        Disposer.Record[] records = new MethodHandles.Lookup("gmail.com", Type.NS).run();
//        for (int i = 0; i < records.length; i++) {
//            NSRecord ns = (NSRecord) records[i];
//            System.out.println("Nameserver " + ns.getTarget());
//        }



    }

}
