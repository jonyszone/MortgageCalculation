package com.shafi.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// mortgage calculator
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        //P
        System.out.print("Principal: ");
        int principle = scanner.nextInt();

        //r
        System.out.print("Annual Interest Rate: ");
        float interestRateSc = scanner.nextFloat();
        float interestRate = interestRateSc/PERCENT/MONTHS_IN_YEAR;
        //n
        //take in years
        System.out.print("Period (Years): ");
        byte numberOfPaymentInYear = scanner.nextByte();
        int numberOfPayment = numberOfPaymentInYear * MONTHS_IN_YEAR;

        /* M = Mortgage:

         M = P( r(1+r)^n ) /
                    (1+r)^n -1
         */
        System.out.println();
        double mortGage = principle * (interestRate * Math.pow(1 + interestRate, numberOfPayment))
                / (Math.pow(1 + interestRate, numberOfPayment) -1);

        String mortGageCurrency = NumberFormat.getCurrencyInstance().format(mortGage);
        System.out.println("Mortgage: "+mortGageCurrency);
    }
}
