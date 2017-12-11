package com.hmtmcse;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by touhid on 29-May-17.
 */
public class DominaToIPResolver {

    public static void main(String[] args) {

        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

            InetAddress[] machines = InetAddress.getAllByName("yahoo.com");
            for(InetAddress address : machines){
                System.out.println(address.getHostAddress());
                System.out.println(address.getCanonicalHostName());
            }

        } catch (UnknownHostException e) {

            e.printStackTrace();

        }

    }

}
