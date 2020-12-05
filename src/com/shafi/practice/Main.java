package com.shafi.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // mortgage calculator

        int principal = 0;
        float annualInterest = 0;
        byte years =0;


        Scanner scanner = new Scanner(System.in);

        //P
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }


        //r
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        //n
        //take in years
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)

                break;

            System.out.println("Enter a value between 1 and 30");
        }


        System.out.println();

        double mortGage = calculateMortgage(principal,annualInterest, years );

        String mortGageCurrency = NumberFormat.getCurrencyInstance().format(mortGage);
        System.out.println("Mortgage: " + mortGageCurrency);
    }

    /* M = Mortgage:

         M = P( r(1+r)^n ) /
                    (1+r)^n -1
         */

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float interestRate = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayment = (short) (years * MONTHS_IN_YEAR);

        double mortGage = principal * (interestRate * Math.pow(1 + interestRate, numberOfPayment))
                / (Math.pow(1 + interestRate, numberOfPayment) - 1);
        return mortGage;
    }
}
