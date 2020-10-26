// Finn Lestrange - 25/10/2020
// IB Computer Science Assignment 5

import java.util.Scanner;

public class App {

    public static int codeGen(int m, int y) {
        int tempInt = m + y; // Combines the two numbers for separation

        // Splits the digits of the number apart and puts them into an array
        int count = 0;
        int numLength = (int) (Math.log10(tempInt) + 1);
        int operand = 10;
        int divisor = 1;
        int[] numArray = new int[numLength];
        for (int i = (numLength - 1); i >= 0; i--) {
            numArray[i] = ((tempInt % operand) - count) / divisor;
            count += numArray[i];
            operand = operand * 10;
            divisor = divisor * 10;
        }
        int total = 0;

        // Adds the separated digits together to get the special code
        for (int j : numArray) {
            total = total + j;
        } return total;
    }


    public static void sort(String[] names, int[] codes) {

        System.out.println("Please find sorted names list below.");
        int n = codes.length;

        for (int i = 0; i < n; i++) { // Loops the length of the codes array
            int min = i; // Sets the minimum element to the value of i
            for (int x = i+1; x < n; x++) { //Loops through the array and if the minimum element is greater then the current element then min is assigned to the new min element
                if (codes[min] > codes[x]) {
                    min = x;
                }
            }
            int temp = codes[min]; // temp variable is the value of the minimum elements
            String tempStr = names[min]; // Names copies the codes swapping so that both arrays can be sorted together
            codes[min] = codes[i]; // Min value in codes element is now assigned to the first available position in the codes array, which shrinks each time a new smaller element is found
            names[min] = names[i];
            codes[i] = temp;
            names[i] = tempStr;
        }
        for (int i = 0; i < codes.length; i++) {
            System.out.println(names[i] + ", " + codes[i]);
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Data for testing all 20 names
        //String[] names = new String[]{"name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9", "names10", "name11", "name12", "name13", "name14", "name15", "name16", "name17", "name18", "name19", "names20", "names21"};

        String[] names = new String[]{"name1", "name2", "name3", "name4"};
        int[] codes = new int[names.length];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Please enter month of birth for " + names[i] + ": ");
            int m = scanner.nextInt();
            System.out.print("Please enter year of birth for " + names[i] + ": ");
            int y = scanner.nextInt();
            codes[i] = codeGen(m, y);
            System.out.println("Unique code for " + names[i] + " is " + codes[i]);
            System.out.println("\n");
        }
        sort(names, codes);
    }
}
