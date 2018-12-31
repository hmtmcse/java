package com.hmtmcse;

public class Test {

    public static void main(String[] args) {
        String x = "";
        int y = 1;
        for(int i = 301; i < 496; i++){
            x += "\"http://template" + i + ".webcommander.biz\" ";
            if (y == 40){
                y = 0;
                x += "\n";
            }
            y++;
        }
        System.out.println(x);
    }
}
