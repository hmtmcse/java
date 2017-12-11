package com.hmtmcse.advanced.network;

/**
 * Created by touhid on 7/02/2017.
 */

import javax.swing.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class PCNetworkScanner {

    public static void main(String[] args){

        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();

            String information = "";
            information += "Host Name : " + ip.getHostName() + "\n";
            information += "Current IP address : " + ip.getHostAddress() + "\n";


            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            information += "Current MAC address : " + sb.toString();
            JTextArea ta = new JTextArea(3, 30);
            ta.setText(information);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setCaretPosition(0);
            ta.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(ta), "PC Network Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e){
            e.printStackTrace();
        }

    }
}
