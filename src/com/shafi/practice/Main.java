package com.shafi.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // mortgage calculator
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principle = 0;
        float interestRate = 0;
        int numberOfPayment = 0;


        Scanner scanner = new Scanner(System.in);

        //P
        while (true) {
            System.out.print("Principal: ");
            principle = scanner.nextInt();
            if (principle >= 1000 && principle <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }


        //r
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float interestRateSc = scanner.nextFloat();
            if (interestRateSc >= 1 && interestRateSc <= 30){
                interestRate = interestRateSc / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        //n
        //take in years
        while (true){
            System.out.print("Period (Years): ");
            byte numberOfPaymentInYear = scanner.nextByte();
            if (numberOfPaymentInYear >= 1 && numberOfPaymentInYear <= 30){
                numberOfPayment = numberOfPaymentInYear * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }


        /* M = Mortgage:

         M = P( r(1+r)^n ) /
                    (1+r)^n -1
         */
        System.out.println();
        double mortGage = principle * (interestRate * Math.pow(1 + interestRate, numberOfPayment))
                / (Math.pow(1 + interestRate, numberOfPayment) - 1);


        String mortGageCurrency = NumberFormat.getCurrencyInstance().format(mortGage);
        System.out.println("Mortgage: " + mortGageCurrency);
    }
}
