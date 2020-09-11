// Finn Lestrange - 11/09/2020
// Program that accepts a 3 digit number and prints each digit the number of times it is. Invalid values give errors.

import java.util.Scanner; // Imports the scanner module

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Sets up a new scanner instance to grab user input

        System.out.print("Please input a three digit number, e.g 123: ");
        int n = scanner.nextInt(); // Grabs the user input in an integer format

        while (n < 0 || n >= 999) { // Checks to see if the user input is valid, by making sure it is a number between 1 and including 999
            System.out.println("Sorry, the number you entered is not valid, please try again");
            System.out.print("Please input a three digit number, e.g 123: ");
            n = scanner.nextInt();
        }

        int digit1 = n % 10; // Extracts the last digit by modulo 10
        int digit2 = ((n % 100) - digit1) / 10; // Extracts the last two digits, then subtracts the first digit and then divides by 10 to get rid of the 0 at the end
        int digit3 = ((n % 1000) - digit1 - digit2) / 100; // % 1000 gets last three digits so we have to subtract the last and 2nd last then divide 100 to get rid of the two zeros

        /*
         * The for loops below look at each digit and then prints out the number of digits that that digit is
         * e.g if we had 543 it would print 5 fives and 4 fours and then 3 threes, so we would get 555554444333
         */

        System.out.print("Here is your number: ");
        for (int i = 0; i < digit3; i++ ) {
            System.out.print(digit3); // w/ each iteration of the loop it print out the extracted digit from above
        }
        for (int i = 0; i < digit2; i++ ) {
            System.out.print(digit2);
        }
        for (int i = 0; i < digit1; i++ ) {
            System.out.print(digit1);
        }

    }
}
