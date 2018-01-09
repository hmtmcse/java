package com.hmtmcse.habijabi;

import java.util.Currency;

public class JavaCurrency {


    public static void printInfo(String countryName, Currency currency){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Country: " + countryName);
        System.out.println("Code: " + currency.getCurrencyCode());
        System.out.println("Display Name: " + currency.getDisplayName());
        System.out.println("Symbol: " + currency.getSymbol());
        System.out.println("Default Factorial Digit: " + currency.getDefaultFractionDigits()); // Gets the default number of fraction digits used with this currency.
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
    }

    public static void main(String[] args) {

        Currency currency = Currency.getInstance("AUD"); // Returns the Currency instance for the given currency code.
        printInfo("Australia", currency);

        currency = Currency.getInstance("BDT");
        printInfo("Bangladesh", currency);

    }

}
