// Finn Lestrange - 30/09/2020
// Functions Challenges 1

import java.util.Scanner;

public class Challenges1 {
    public static boolean atmCode(int n1) {
        int sum = 0;
        sum = n1 % 10;
        sum = sum + (((n1 % 100) - (n1 % 10)) / 10);
        sum = sum + (((n1 % 1000) - (n1 % 10) - (((n1 % 100) - (n1 % 10)) / 10)) / 100);
        if (sum % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a 4 digit code: ");
        int pin = scanner.nextInt();
        if (atmCode(pin) == false) {
            System.out.println("F");
        } else {
            System.out.println("T");
        }
    }
}
