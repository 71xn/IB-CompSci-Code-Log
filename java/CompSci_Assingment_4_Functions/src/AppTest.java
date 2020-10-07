// Finn Lestrange Assignment 4 - Functions

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {

    public static ArrayList<String> validateEmails(ArrayList<String> emails) {

        int at = 0;
        int period = 0;
        boolean nextTo = false;
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < emails.size(); i++) {
            String email = emails.get(i);
            if (email.contains("@.") || email.contains(".@")) {
                nextTo = true;
            }
            for (int x = 0; x < email.length(); x++) {
                String char1 = Character.toString(email.charAt(x));
                if (char1.equals("@")) {
                    at++;
                } else if (char1.equals(".")) {
                    period++;
                }
            }

            if (at == 1 && period >=1 && !nextTo) {
                arr.add("T");
            } else {
                arr.add("F");
            }
            at = 0;
            period = 0;
            nextTo = false;
        }
        return arr;
    }

    public static void main(String[] args) {

        ArrayList<String> email1 = new ArrayList<>(Arrays.asList("abc@aol.com", "def@.com", "efg@abc", "sk@gmail.com"));
        ArrayList<String> email2 = new ArrayList<>(Arrays.asList("a@aol.com", "d@.g.com", "e123g@abc.sg", "sk123@.abcgmail.com"));

        System.out.println(validateEmails(email1));
        System.out.println(validateEmails(email2));
    }
}