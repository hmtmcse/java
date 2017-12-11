package com.miaisoft.encryption;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.util.UUID;

/**
 * Created by Touhid Mia on 3/11/2014.
 */
public class ABC {


    static  int PIC_VALUE_1 = 10;
    static  int PIC_VALUE_2 = 15;
    static  int PIC_VALUE_3 = 16;
    static  int PIC_VALUE_4 = 21;

    public static void main(String[] args) {
        for (int i =0; i < 65; i++){
            keyEncrypt("jdue8q4x1");
        }

    }

    public static void keyEncrypt(String prefix){
        String uuid = UUID.randomUUID().toString();

        String profixUUID = prefix + "-" + uuid + "-8080";
        uuid = profixUUID;
        int number1 = (int) uuid.charAt(PIC_VALUE_1);
        int number2 = (int) uuid.charAt(PIC_VALUE_2);


//        System.out.println("=================================");
//        System.out.println(uuid.charAt(PIC_VALUE_1));
//        System.out.println(uuid.charAt(PIC_VALUE_2));

        int number3 = (int) uuid.charAt(PIC_VALUE_3);
        int number4 = (int) uuid.charAt(PIC_VALUE_4);

//        System.out.println(uuid.charAt(PIC_VALUE_3));
//        System.out.println(uuid.charAt(PIC_VALUE_4));
//        System.out.println("=================================");

        int subtraction = 0;
        if (number1 < number2){
            subtraction = number2 - number1;
        }else if (number2 < number1){
            subtraction = number1 - number2;
        }

        int subtraction2 = 0;
        if (number3 < number4){
            subtraction2 = number4 - number3;
        }else if (number4 < number3){
            subtraction2 = number3 - number4;
        }

        int code = 0;
        if (subtraction < subtraction2){
            code = subtraction2 - subtraction;
        }else if (subtraction2 < subtraction){
            code = subtraction - subtraction2;
        }

        String hash = "";

        StringBuilder stringBuilder = new StringBuilder();

        int ascii = 0,sub=0;
        for (int i=0; i< profixUUID.length(); i++){
            if (i != PIC_VALUE_1 && i != PIC_VALUE_2 && i != PIC_VALUE_3 && i != PIC_VALUE_4 ){
                ascii = (int)profixUUID.charAt(i);
                if (ascii < code){
                    sub = code - ascii;
                }else if (code < ascii){
                    sub = ascii - code;
                }
                stringBuilder.append((char)sub);
                hash += "" + (char) sub;
            }else{
                stringBuilder.append(profixUUID.charAt(i));
                hash += "" + profixUUID.charAt(i);
            }

        }
//        System.out.println( "This is Encrypt Code = " + code + " Hash = " + hash);
        hash =  Base64.encode(hash.getBytes());
        String x =  Base64.encode(String.valueOf(stringBuilder).getBytes());
        System.out.println( hash);
        System.out.println( x );

//        keyDecrypt(hash);
        System.out.println( hash + "  "  + profixUUID);
    }

    public static void keyDecrypt(String hashCode) {
        String decrypted = "";
        try {
            String hash = new String(Base64.decode(hashCode));


//            System.out.println("=================================");
//            System.out.println(hash.charAt(PIC_VALUE_1));
//            System.out.println(hash.charAt(PIC_VALUE_2));
//
//            System.out.println(hash.charAt(PIC_VALUE_3));
//            System.out.println(hash.charAt(PIC_VALUE_4));
//            System.out.println("=================================");

            int number1 = (int) hash.charAt(PIC_VALUE_1);
            int number2 = (int) hash.charAt(PIC_VALUE_2);

            int number3 = (int) hash.charAt(PIC_VALUE_3);
            int number4 = (int) hash.charAt(PIC_VALUE_4);

            int subtraction = 0;
            if (number1 < number2){
                subtraction = number2 - number1;
            }else if (number2 < number1){
                subtraction = number1 - number2;
            }

            int subtraction2 = 0;
            if (number3 < number4){
                subtraction2 = number4 - number3;
            }else if (number4 < number3){
                subtraction2 = number3 - number4;
            }

            int code = 0;
            if (subtraction < subtraction2){
                code = subtraction2 - subtraction;
            }else if (subtraction2 < subtraction){
                code = subtraction - subtraction2;
            }

            System.out.println( "This is Decrypt Code = " + code);

            int ascii = 0,sub=0;
            for (int i= hash.length() - 1 ; 0 < 1 ; i--){
                if (i != PIC_VALUE_1 && i != PIC_VALUE_2 && i != PIC_VALUE_3 && i != PIC_VALUE_4){
                    ascii = (int)hash.charAt(i);
                    if (ascii < code){
                        sub = code + ascii;
                    }else if (code < ascii){
                        sub = ascii + code;
                    }
                    decrypted += "" + (char) sub;
                }else{
                    decrypted += "" + hash.charAt(i);
                }
            }

        } catch (Base64DecodingException e) {
            e.printStackTrace();
        }

        System.out.println("Decoded = " + decrypted);

    }

}
