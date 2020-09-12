// Finn Lestrange - 11/09/2020
// CompSci Number Expander

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Hi there! Welcome to MATHTASTIC!");
        System.out.print("Hi there! What’s your name? ");
        String name = scanner.next();

        System.out.print("Hi " + name + "! Which number would you like try today? ");
        int num = scanner.nextInt();

        while (num <= 0) {
            System.out.println("No Result! ");
            System.out.print("Sorry " + name + "! You entered a negative number, or zero, please enter a positive integer:  ");
            num = scanner.nextInt();
        }

        System.out.println("Awesome! Here is how " + num + " can be expanded!");

        int[] numArray = new int[8];

        numArray[0] = num % 10;
        numArray[1] = ((num % 100) - numArray[0]);
        numArray[2] = ((num % 1000) - numArray[0]  - numArray[1]);
        numArray[3] = ((num % 10000) - numArray[0]  - numArray[1] - numArray[2]);
        numArray[4] = ((num % 100000) - numArray[0]  - numArray[1] - numArray[2] - numArray[3]);
        numArray[5] = ((num % 1000000) - numArray[0]  - numArray[1] - numArray[2] - numArray[3] - numArray[4]);
        numArray[6] = ((num % 10000000) - numArray[0]  - numArray[1] - numArray[2] -  numArray[3] - numArray[4] - numArray[5]);
        numArray[7] = ((num % 100000000) - numArray[0]  - numArray[1] - numArray[2] - numArray[3] - numArray[4] - numArray[5] - numArray[6]);


        for (int i = 7; i >= 0; i--){
            if (numArray[i] != numArray[0] && numArray[i] != 0) {
                System.out.print(numArray[i] + " + ");
            }
            else if (i < 7 && i > 0 && (numArray[i+1] != 0)) {
                System.out.print(numArray[i] + " + ");
            }
            else if (numArray[i] == numArray[0]) {
                System.out.print(numArray[i] + " = " + num);
                System.out.print("\n");
            }
        }

        System.out.println("Enjoy Learning, " + name + "!");

    }
}
