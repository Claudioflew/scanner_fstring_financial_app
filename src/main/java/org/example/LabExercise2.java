// Student name: Koichi Nakata (ID: 1963595)

package org.example;

import java.util.Scanner;

public class LabExercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int loanAmount = askLoanAmount(input);
        int years = askYears(input);

        displayResult(loanAmount, years);
    }

    private static int askLoanAmount(Scanner input) {
        String inputStr;
        int loanAmount;
        System.out.print("Please enter the loan amount: ");
        while (true) {
            // Input validation logic:
            // Input should be stored as a string first and then use try and catch to convert the string to integer.
            // Use while loop to continue if the program catches an error.
            inputStr = input.next();
            try {
                loanAmount = Integer.parseInt(inputStr);
                if (loanAmount > 0) break;
                System.out.print("Invalid entry.. Please enter a positive integer: ");
            } catch (Exception e) {
                System.out.print("Invalid entry.. Please enter amount in integer: ");
            }
        }
        return loanAmount;
    }

    private static int askYears(Scanner input) {
        String inputStr;
        int years;
        System.out.print("Please enter the loan period (years): ");
        while (true) {
            inputStr = input.next();
            try {
                years = Integer.parseInt(inputStr);
                if (years > 0) break;
                System.out.print("Invalid entry.. Please enter a positive integer: ");
            } catch (Exception e) {
                System.out.print("Invalid entry.. Please enter year in integer: ");
            }
        }
        return years;
    }


    private static void displayResult(int loanAmount, int years) {
        System.out.printf("\n%16s%22s%22s\n", "Interest Rate (%)", "Monthly Payment ($)", "Total Payment ($)");

        for (int i = 0; i < 25; i++) {
            double annualRate = 5 + 0.125 * i;
            double monthlyPay = calcMonthlyPayment(loanAmount, years, annualRate);
            double totalPay = calcTotalPayment(monthlyPay, years);

            System.out.printf("%16.3f%22.2f%22.2f\n", annualRate, monthlyPay, totalPay);
        }
    }

    private static double calcMonthlyPayment(int loanAmount, int years, double annualRate) {
        double monthlyRate = annualRate / 12 / 100;
        double top = loanAmount * monthlyRate;
        double bottom = 1 - Math.pow(1 + monthlyRate, -years * 12);

        return top / bottom;
    }

    private static double calcTotalPayment(double monthlyPay, int years) {
        return monthlyPay * years * 12;
    }

}