package com.miaisoft.miscellaneous;

import com.sun.deploy.security.BadCertificateDialog;

import java.math.BigInteger;

/**
 * Created by touhid on 12/08/2014.
 *
 */

//Classless Inter-Domain Routing
public class IPInCIDR {

    public String calculateSubnetmask(Integer usedBit){
        String netmask = "";
        Integer result = usedBit/8;
        Integer modes = usedBit%8;
        Integer freeBit = 32 - usedBit;
        Integer result0 = freeBit/8;

        for(int i = 0; i < result; i++){
            netmask = IPInCIDR.addDot(netmask,"255");
        }

        Integer BCD[] = new Integer[]{128,64,32,16,8,4,2,1};
        Integer lastMask = 0;
        for (int j = 0; j < modes; j++){
            lastMask += BCD[j];
        }

        if(lastMask !=0){
            netmask = IPInCIDR.addDot(netmask,"" + lastMask);
        }
        for(int i = 0; i < result0; i++){
            netmask = IPInCIDR.addDot(netmask,"0");
        }
        return netmask;
    }

    static String addDot(String string,String afterDot){
        String adDot[] = string.split("\\.");
        if (string == ""){
            string += afterDot;
        }else if(adDot.length == 0 || adDot.length < 4){
            string += "." + afterDot;
        }
        return string;
    }

    public String gateWay(String ipAddress, String netmask){
        String splitedIP[] = ipAddress.split("\\.");
        String splitedmask[] = netmask.split("\\.");
        String lastOctated = "";
        for (int i = 0; i < 4; i++){
            if (!splitedmask[i].equals("255") && !splitedmask[i].equals("0")){
               String mskbit = Integer.toBinaryString(Integer.parseInt(splitedmask[i]));
               String ipbit = Integer.toBinaryString(Integer.parseInt(splitedIP[i]));
                int  mskbitLnth = mskbit.length();
                int  ipbitLnth = ipbit.length();
                int ipb =1, mskb = 1;
                for (int j = 0; j < 8; j++){
                    ipbitLnth -= j;
                    if (ipbitLnth > 0){
                        ipb = Integer.parseInt(ipbit.substring( ipbitLnth - 1, ipbitLnth));
                    }

                    mskbitLnth -= j;
                    if (mskbitLnth > 0){
                       mskb =  Integer.parseInt(mskbit.substring(mskbitLnth - 1, mskbitLnth));
                    }

                    if(mskbitLnth < 0 &&  0 > ipbitLnth){
                        break;
                    }
                    lastOctated += (ipb * mskb);
                }
                System.out.println(Integer.parseInt(lastOctated, 2));
            }
        }
    return "";
    }



    public static void main(String[] args) {
        IPInCIDR ipInCIDR = new IPInCIDR();
        ipInCIDR.gateWay("10.0.30.40".toString(),ipInCIDR.calculateSubnetmask(27).toString());
    }

}
