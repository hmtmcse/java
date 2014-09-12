package com.miaisoft.exceptionHandling;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class ExceptionTester {

    public static ExceptionTester exceptionTester;

    public static void main(String[] args) {
        exceptionTester = new ExceptionTester();
        try {
            System.out.println(exceptionTester.doException(1));
        }catch (CustomException ce){
            System.out.println(ce.getMessage());
        }
    }


    public String doException(int isThrowException)
            throws CustomException{
        if (isThrowException == 1){
            throw new CustomException("Oi Exception Occurred! Hi Hi Hi");
        }else {
            return "Good Luck";
        }
    }
}
