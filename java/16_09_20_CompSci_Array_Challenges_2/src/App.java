// Finn Lestrange - 16/09/2020
// Array Challenges II

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> passwords = new ArrayList<>();
        boolean check = false;

        System.out.println("Password Checker!");
        System.out.print("Please input some passwords, when you are done please type `end`: ");

        while (!check) {
            String tempPass = scanner.next().toLowerCase();
            if (tempPass.equals("end")) { // if string entered is equal to the keyword then loop ends by setting check to true
                check = true;
            }
            else { //If password is not `end` then it is added to arraylist, passwords
                passwords.add(tempPass);
            }
        }

        int charCounter = 0; // Counter to count the special chars
        int numCounter = 0; // Counter to count the number of numbers

        for (int i = 0; i < passwords.size(); i++) { // Loops through the size of arraylist
            String tempPassword = passwords.get(i).toLowerCase(); // grabs current password in list
            for (int x = 0; x < tempPassword.length(); x++ ){ // loops through length of password
                String tempChar = Character.toString(tempPassword.charAt(x)); // grabs current character at pos x
                switch (tempChar) { // switch of tempChar
                    case "@": case "_": case "%": // if special character then counter++
                        charCounter++;
                        break;
                    case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
                        numCounter++; // if number num counter++
                        break;
                }

            }
            if (charCounter > 0 && passwords.get(i).length() > 8 && numCounter > 0) { //checks if special char, number and length over 8
                System.out.println("Password " + (i + 1) + " is a good password!");
            } else { // else its a bad password
                System.out.println("Password " + (i + 1) + " is a bad password!");
            }
            // rests the counter so we don't get a running total
            numCounter = 0;
            charCounter = 0;
        }
    }
}
