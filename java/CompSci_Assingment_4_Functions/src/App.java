// Finn Lestrange - 06/10/2020
// Computer Science Assignment 4: Functions
// Email Validator

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static ArrayList<String> emailCheck(ArrayList<String> emails) {

        String tempEmail;
        String tempChar;
        int count = 1;
        int count1 = 1;
        int atCount = 0;
        int periodCount = 0;
        String prevChar;
        String nextChar;
        boolean bool1 = false;
        boolean bool2 = false;
        ArrayList<String> array = new ArrayList<>();

        for (String email : emails) {
            tempEmail = email;
            //System.out.println(tempEmail);
            for (int x = 0; x < tempEmail.length(); x++) {
                tempChar = Character.toString(tempEmail.charAt(x));
                // System.out.println(tempChar);
                switch (tempChar) {
                    case "@":
                        if (!bool2) {
                            atCount = 1;
                            bool2 = true;
                            break;
                        } else {
                            count1++;
                        }

                        //System.out.println(count1);
                        //System.out.println("found @!");
                        break;
                    case ".":
                        if (x > 0 && x < emails.size()) {
                            prevChar = Character.toString(tempEmail.charAt(x-1));
                            nextChar = Character.toString(tempEmail.charAt(x+1));
                            if (prevChar.equals(".") || nextChar.equals(".")) {
                                periodCount++;
                                bool1 = true;
                                break;
                            } else if (prevChar.equals("@") || nextChar.equals("@")) {
                                periodCount++;
                                bool1 = true;
                                break;
                            }
                        }
                        break;
                }
            }
            System.out.println(count);
            System.out.println(count1);
            if (bool1 || count1 > 1) {
                array.add("F");
            } else if (count1 == 0 && bool2) {
                array.add("T");
            } else {
                array.add("T");
            }
            System.out.println(array);
            count = 1;
            count1 = 1;
        }
        return array;
    }



    public static void main(String[] args) {

        ArrayList<String> email1 = new ArrayList<>(Arrays.asList("abc@aol.com", "def@.com", "efg@abc", "sk@gmail.com"));

        System.out.println(emailCheck(email1));

    }
}
