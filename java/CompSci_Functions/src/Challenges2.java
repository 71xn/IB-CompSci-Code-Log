// Finn Lestrange - 30/09/2020
// Functions Challenges 2

import java.util.Scanner;

public class Challenges2 {

    public static boolean checkPass(String pass) {
        int charCounter = 0; // Counter to count the special chars
        int numCounter = 0; // Counter to count the number of numbers

        for (int i = 0; i < pass.length(); i++) { // loops through length of password
            String tempChar = Character.toString(pass.charAt(i)); // grabs current character at pos x
            switch (tempChar) { // switch of tempChar
                case "@": case "_": case "%": // if special character then counter++
                        charCounter++;
                        break;
                    case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
                        numCounter++; // if number num counter++
                        break;
                }
        }

        if (charCounter > 0 && pass.length() > 8 && numCounter > 0) { //checks if special char, number and length over 8
            return true;
        } else { // else its a bad password
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Checker!");
        System.out.print("Please input a password: ");
        String pass = scanner.next();

        if (checkPass(pass) == true) {
            System.out.println("Wow! You had a good password!");
        } else {
            System.out.println("Nice, your password was terrible!");
        }
    }
}
