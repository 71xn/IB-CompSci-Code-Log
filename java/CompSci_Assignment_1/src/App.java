// Finn Lestrange - 04/09/2020 - Assignment 1

import java.util.Scanner; // Importing the scanner module so that we can get user input

public class App {

    public static double price = 0; // Allocating memory space for a price variable that will be used later on
    public static Scanner scanner = new Scanner(System.in); // Initializing a scanner instance called scanner to read user input

    public static void main(String[] args) {
        System.out.print("Hi there! What is your name? ");
        String name = scanner.next(); // The scanner grabs the next string that it written in the console

        System.out.println("Welcome to Pizza Planet, " + name + "! What kind of pizza would you like today?"); // Concatenating `name` into the welcome string to be more personalized
        System.out.println("1. Margarita (6.99 M / 8.99 L)\n" +
                "2. Pepperoni (7.20 M / 9.00 L)\n" +
                "3. Hawaii (7.50 M / 9.50 L)\n" +
                "4. Tex Mex (7.50 M / 9.50 L)");

        int pizzaChoice = scanner.nextInt(); // Grabs the next integer value in console, which should be the pizza
        System.out.print("Excellent! Will that be L or M? ");
        String size = scanner.next(); // Grabs the next String value in console, which should be the pizza size, L or M, or a lowercase variant of that

        if ((pizzaChoice >= 1 && pizzaChoice <= 4 ) && (size.equals("M") || size.equals("m") || size.equals("L") || size.equals("l"))) {
            // This if loop checks that the pizza is a value between 1 and 4, (I don't have to worry about decimals as int does not store a decimal place in Java) and that size is a string of either L or M, or a lowercase variant of that
            price = pizzaChecker(pizzaChoice, size); // Sends the choice of pizza and the size to the pizzaChecker class, this avoid me having a huge switch case in my main method, and this allows for more expansion in the future, as instead of exiting the program when a wrong selection is made, you could recall the pizzaChecker class
        }
        else {
            System.out.println("Sorry, you entered something incorrectly! ");
            System.exit(0); // If the USER made a wrong choice, the program exits

        }

        System.out.println("What additional toppings would you like? (0.10£ each) Type in all digits together please!");
        System.out.println("1. Olives\n" +
                "2. Jalapeno peppers\n" +
                "3. Sweet Corn\n" +
                "4. Pepperoni\n" +
                "5. Mushrooms");

        String toppings = scanner.next(); // Grabs the String value of the toppings string, e.g 1432
        double toppingsPrice; // Creates memory space for the toppings price variable, double is used as it uses decimal places
        int counter = 0; // Set's up a counter to count how many toppings are ordered, used for calculating price later

        for (int i = 0; i < toppings.length(); i++) {
            char t1 = toppings.charAt(i); // Grabs the character at index `i` in the toppings string and convert it to a char
            String t2 = Character.toString(t1); // Convert the first character to a String
            if ( t2.equals("1") || t2.equals("2") || t2.equals("3") || t2.equals("4") || t2.equals("5")) {
                // This checks that the value at index `i` in the String toppings is one of the accepted numbers
                counter+= 1; // If the user input is accepted then 1 is added to the counter
            }
            else {
                System.out.println("Sorry, you did not enter an accepted value for toppings!");
                System.exit(0); // Exits the program if an incorrect value for toppings is used, e.g 7, x, 5644454 etc.
            }
        }

        toppingsPrice = counter * 0.10; // Each topping is £0.10 and every time a valid topping was found it was added to the counter, so this multiplies the counter variable by the price of each topping
        price+= toppingsPrice; // Adds the price of the toppings to the overall price
        double priceTax = price + 0.25; // Adds the sales tax of £0.25 to the price

        System.out.println("Cool! Your total bill is: £" + price + " + £0.25 (taxes) = £" + priceTax + ". Enjoy the pizza!");
    }

    public static double pizzaChecker(int pizzaChoice, String size) {
        switch (pizzaChoice) { // This means that the variable pizzaChoice that is passed to this method, is switched and for each possible input there is a different case for what happens
            case 1: // e.g case 1 is for the Margarita pizza, this case then checks the size and adds the correct price to the price variable
                if (size.equals("M") || size.equals("m")) {
                    price =+ 6.99;
                    break; // The break statement means that when this is hit, it immediately skips all other cases in the loop and either goes to the default case or if there isn't a default case it exits the switch loop.
                }
                else if (size.equals("L") || size.equals("l")) {
                    price =+ 8.99;
                    break;
                }
                else {
                    break;
                }
            case 2:
                if (size.equals("M") || size.equals("m")) {
                    price =+ 7.20;
                    break;
                }
                else if (size.equals("L") || size.equals("l")) {
                    price =+ 9.00;
                    break;
                }
                else {
                    break;
                }
            case 3:
            case 4:
                if (size.equals("M") || size.equals("m")) {
                    price =+ 7.50;
                    break;
                }
                else if (size.equals("L") || size.equals("l")) {
                    price =+ 9.50;
                    break;
                }
                else {
                    break;
                }
        }
        return price; // This returns the price variable so that when the method is called above like this, `price = pizzaChecker(pizzaChoice, size);` whatever value is returned is equal made equal to the price.
    }
}
