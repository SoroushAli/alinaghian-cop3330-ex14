/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Soroush Alinaghian
 */
package base;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
Write a simple program to compute the tax on an order amount. The program should prompt for the order amount and the state.
If the state is “WI,” then the order must be charged 5.5% tax. The program should display the subtotal, tax, and total for
Wisconsin residents but display just the total for non-residents.

Example Output

What is the order amount? 10
What is the state? WI
The subtotal is $10.00.
The tax is $0.55.
The total is $10.55.

Or

What is the order amount? 10
What is the state? MN
The total is $10.00

Constraints

Implement this program using only a simple if statement—don’t use an else clause.
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.

Challenges

Allow the user to enter a state abbreviation in upper, lower, or mixed case.
Also allow the user to enter the state’s full name in upper, lower, or mixed case.
 */
public class App {
    static Scanner in = new Scanner(System.in);
    private static DecimalFormat DF = new DecimalFormat("0.00");

    public static void main(String[] args) {
        String amount = readAmount();
        String state = readState();
        wisconsinStateTax(amount, state);
        stateTax(amount, state);

    }

    private static void wisconsinStateTax(String amount, String state) {
        if(state.equals ("WI")){
            float subtotal = Float.parseFloat(amount);
            float tax = (float) .55;
            float result = subtotal + tax;
            System.out.println(String.format("What is the order amount? %s\nWhat is the state? %s\nThe subtotal is $%.2f.\nThe tax is $%.2f.\nThe total is $%.2f", amount, state, subtotal, tax, result));
        }
    }

    private static void stateTax(String amount, String state) {
        float total = Float.parseFloat(amount);
        if(!state.equals("WI")){
            System.out.println(String.format("What is the order amount? %s\nWhat is the state? %s\nThe total is $%.2f", amount, state, total));
        }
    }

    private static String readState() {
        return in.nextLine();
    }

    private static String readAmount() {
        return in.nextLine();
    }
}
