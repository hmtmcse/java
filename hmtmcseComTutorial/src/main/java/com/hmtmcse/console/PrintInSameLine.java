package com.hmtmcse.console;

public class PrintInSameLine {

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("\r%s", "Touhid Mia");
        Thread.sleep(1000);
        System.out.printf("\r%s", "Touhid Mia 1");
        Thread.sleep(1000);
        System.out.printf("\r%s", "Touhid Mia 2");
        Thread.sleep(1000);
        System.out.printf("\r%s", "Touhid Mia 3");


        System.out.println();

        System.out.print("Start[          ]");
        System.out.flush(); // the flush method prints it to the screen

        // 11 '\b' chars: 1 for the ']', the rest are for the spaces
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
        System.out.flush();
        Thread.sleep(500); // just to make it easy to see the changes

        for(int i = 0; i < 10; i++)
        {
            System.out.print("."); //overwrites a space
            System.out.flush();
            Thread.sleep(100);
        }

        System.out.print("] Done\n"); //overwrites the ']' + adds chars
        System.out.flush();
    }

}
