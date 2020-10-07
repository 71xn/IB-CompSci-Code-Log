// Finn Lestrange 07/10/2020
// Program that accepts a credit card number (16 digits, String) and returns a masked version of it with just the last 4 digits showing. Print INVALID for numbers < or > 16.

import java.util.Scanner;

public class Challenge3 {

    public static String[] ccChecker(String[] cc) {

        String[] out = new String[cc.length];

        if (cc.length > 20) {
            System.out.println("INVALID");
        } else {
            for (int i = 0; i < (cc.length - 5); i++) {
                if (i == 4 || i == 9 || i == 14) {
                    out[i] = " ";
                } else {
                    out[i] = "*";
                }
            }
            for (int i = cc.length - 1; i >= 15; i--) {
                out[i] = cc[i];
            }
        } return out;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cc1 = new String[20];
        String value = "";

        System.out.println("Credit Card Obfuscator!");
        System.out.print("Please Enter a Valid CC Number: ");

        for (int i = 0; i < 19; i = i + 5) {
            value = scanner.next();
            cc1[i] = String.valueOf(value.charAt(0));
            cc1[i+1] = String.valueOf(value.charAt(1));
            cc1[i+2] = String.valueOf(value.charAt(2));
            cc1[i+3] = String.valueOf(value.charAt(3));
            cc1[i+4] = " ";
        }

        String[] out = ccChecker(cc1);

        System.out.print("Your obfuscated cc number: ");

        for (String s : out) {
            System.out.print(s);
        }

    }

}
