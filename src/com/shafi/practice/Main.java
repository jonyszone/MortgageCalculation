package com.shafi.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// mortgage calculator
        Scanner scanner = new Scanner(System.in);

        //P
        System.out.print("Principal: ");
        int principle = scanner.nextInt();

        //r
        System.out.print("Annual Interest Rate: ");
        float interestRateSc = scanner.nextFloat();
        float interestRate = interestRateSc/100/12;
        //n
        //take in years
        System.out.print("Period (Years): ");
        byte numberOfPaymentSc = scanner.nextByte();
        int numberOfPayment = numberOfPaymentSc * 12;

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
