// Finn Lestrange - 14/09/2020
// Array Challenges - Accept an array of names and print how many vowels and consonants are in each of them.

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>(); // Need to use arraylist as size is dynamic depending on the number of names inputted

        int vowel = 0;
        int consonants = 0;
        boolean end = false;

        System.out.println("This program tells you the number of vowels and consonants in a name.");
        System.out.print("Please input names, when you are done please type `end` or `stop`: ");

        while (!end) {
            String tempName = scanner.next().toLowerCase();
            if (tempName.equals("end") || tempName.equals("stop")) { // Loops until someone types in the end keyword
                end = true;
            } else {
                names.add(tempName); // Use ArrayList.add(), and not ArrayList.set() as there is no index to set yet
                // https://stackoverflow.com/questions/32317921/index-out-of-bounds-exception-trying-to-create-arraylist-with-1-based-indices
            }
        }

        for (int i = 0; i < names.size(); i ++) { // .size in Java ArrayLists is equivalent to len() in python
            String name = names.get(i);

            for (int x = 0; x < name.length(); x++) {
                char nameChar = name.charAt(x);
                String nameCharStr = Character.toString(nameChar).toLowerCase(); // makes the names lowercase for easier searching
                if (nameCharStr.equals("a") || nameCharStr.equals("e") || nameCharStr.equals("i") || nameCharStr.equals("o") || nameCharStr.equals("u")) {
                    vowel = vowel + 1;
                } else {
                    consonants = consonants + 1;
                }
            }

            System.out.println("V: " + vowel + ", C: " + consonants);
            // Both of these need to be set to zero, otherwise during the next iteration for the loop it adds to the numbers that were previously there
            vowel = 0;
            consonants = 0;

        }
    }
}
