/*
 Finn Lestrange - 9/9/2020
 Loop Challenges 2
*/

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1 - Accept any number and extract each digit
        System.out.print("Please input an integer: ");
        long n1 = scanner.nextLong();
        String n1Str = Long.toString(n1); // Converts the long, users input, to a string so we can extract digits easier

        System.out.println("Here are the digit's: ");

        for (int i = 0; i < n1Str.length(); i++) {
            System.out.print(n1Str.charAt(i) + " "); // Grabs the digit at position `i` in the number String and prints it
            // Throws an error when the number is over 10 digits long, not sure why - scanner was looking for next int, instead of next long
        }
        System.out.println("\n");


        // Task 2 - Accept any number and print the sum of its digits.
        System.out.print("Please input an integer: ");
        long sum = 0;
        long n2 = scanner.nextLong(); // Grabs the next long value, basically an integer with more memory space, so you don't get errors when the number is over 10 digits long
        String n2Str = Long.toString(n2); // Converts n2 to a string so we can grab the char at position i
        // This is more simple then getting the digits using something like this method - https://github.com/71xn/IB-CompSci-Code-Log/blob/master/python/number-digit-extractor.py

        for (int i = 0; i < n2Str.length(); i ++) { //Loops until the loop has looped through all the digits, length of the number string (n2Str)
            int tempNum = Character.getNumericValue(n2Str.charAt(i)); //  grabs the car from the string at position i, then gets the integer value of that number and assigns it to tempnum
            // Thanks Intellij, very cool assistance, above
            sum += tempNum; // Adds the current digit to a running total
            // Remember!!!! += is not the same as =+
        }

        System.out.println("The sum of the digits is: " + sum); // Prints out the sum of all the digits, obtained in the for loop above
        System.out.print("\n"); // Prints a newline char, \n so the text is not all crammed together in the console


        // Task 3 - Fibonacci Sequence
        System.out.print("Please enter a number: ");
        int n3 = scanner.nextInt(); // Grabs what our nth term number will be for the loop
        int sum2; // Stores the sum of the previous two numbers
        int num1 = 0; // Stores the first number
        int num2 = 1; // Stores the second number
        int count = 0; // Counter variable for out loop

        while (count < n3) { // Keep looping until we read the nth term in the sequence
            sum2 = num1 + num2; // Sum is equal to the first and second number, so for the first run its 1 + 0, then 1 + 1, then 2 + 1, then 3 + 2
            num1 = num2; // Moves the second number to first number place
            num2 = sum2; // The second number var stores the value of the first and second place number's added together
            count++;
            System.out.print(num1 + ", "); // Prints out the nth number of numbers in the sequence
        }


    }
}
