package com.miaisoft.miscellaneous;

import com.sun.deploy.security.BadCertificateDialog;

import java.math.BigInteger;

/**
 * Created by touhid on 12/08/2014.
 */

//Classless Inter-Domain Routing
public class IPInCIDR {

    public static String netmask,network,gateWay,broadcast;

    public String calculateSubnetmask(Integer usedBit) {
        netmask = "";
        Integer result = usedBit / 8;
        Integer modes = usedBit % 8;
        Integer freeBit = 32 - usedBit;
        Integer result0 = freeBit / 8;

        for (int i = 0; i < result; i++) {
            netmask = IPInCIDR.addDot(netmask, "255");
        }

        Integer BCD[] = new Integer[]{128, 64, 32, 16, 8, 4, 2, 1};
        Integer lastMask = 0;
        for (int j = 0; j < modes; j++) {
            lastMask += BCD[j];
        }

        if (lastMask != 0) {
            netmask = IPInCIDR.addDot(netmask, "" + lastMask);
        }
        for (int i = 0; i < result0; i++) {
            netmask = IPInCIDR.addDot(netmask, "0");
        }
        return netmask;
    }

    static String addDot(String string, String afterDot) {
        String adDot[] = string.split("\\.");
        if (string == "") {
            string += afterDot;
        } else if (adDot.length == 0 || adDot.length < 4) {
            string += "." + afterDot;
        }
        return string;
    }

    public String getIPDetails(String ipAddress, String netmask) {
        String splitedIP[] = ipAddress.split("\\.");
        String splitedmask[] = netmask.split("\\.");
        network = "";
        gateWay = "";
        broadcast = "";
        for (int i = 0; i < 4; i++) {
            if (splitedmask[i].equals("0")) {
                network = IPInCIDR.addDot(network, "0");
                gateWay = IPInCIDR.addDot(gateWay, i == 3 ?"1":"0");
                broadcast = IPInCIDR.addDot(broadcast, "0");
            } else if (!splitedmask[i].equals("255")) {
                BigInteger mskbit = new BigInteger(Integer.toBinaryString(Integer.parseInt(splitedmask[i])), 2);
                BigInteger ipbit = new BigInteger(Integer.toBinaryString(Integer.parseInt(splitedIP[i])), 2);
                BigInteger lastBit = new BigInteger("1");
                network = IPInCIDR.addDot(network, mskbit.and(ipbit).toString());
                gateWay = IPInCIDR.addDot(gateWay, i == 3 ? mskbit.and(ipbit).add(lastBit).toString() : mskbit.and(ipbit).toString());
                broadcast = IPInCIDR.addDot(broadcast, ipbit.not().toString());
                System.out.println(mskbit.xor(new BigInteger("11111111", 2)).toString());
            } else {
                network = IPInCIDR.addDot(network, splitedIP[i]);
                gateWay = IPInCIDR.addDot(gateWay, i == 3 ? "" + (Integer.parseInt(splitedIP[i]) + 1) :splitedIP[i]);
                broadcast = IPInCIDR.addDot(broadcast, splitedIP[i]);
            }

        }
        return gateWay;
    }


    public static void main(String[] args) {
        IPInCIDR ipInCIDR = new IPInCIDR();
        ipInCIDR.getIPDetails("10.0.30.32".toString(), ipInCIDR.calculateSubnetmask(27).toString());
        System.out.println(network);
        System.out.println(gateWay);
        System.out.println(netmask);
        System.out.println(broadcast);
    }

}
