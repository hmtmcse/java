package com.hmtmcse.habijabi;

public class TaxCalculation {

    public static void main(String[] args) {
        double percentage = 10;
        double priceWithTax = 60;
        System.out.println("Price " + priceWithTax + " Taka with inclusive Tax " + percentage + "%");
        double tax = (priceWithTax * percentage) / (percentage + 100);
        double realPrice = priceWithTax - tax;
        System.out.println("Tax " + tax);
        System.out.println("Real Price " + realPrice);
    }
}
