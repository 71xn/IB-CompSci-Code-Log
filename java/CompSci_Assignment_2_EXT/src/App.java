// Finn Lestrange - 11/09/2020
// CompSci Number Expander - Extended with GUI
// This was very helpful when learning how SWING works: https://www.youtube.com/watch?v=5o3fMLPY7qY&ab_channel=AlexLee

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App implements ActionListener { // `implements ActionListener` is used for making the button do something, Line 49

    // Create instances of the necessary swing methods, to be used in main and in the ActionListener method
    private static JLabel label;
    private static JTextField numberInput;
    private static JButton button;
    private static JLabel expandedNumber;
    private static JLabel textBox;


    public static void main(String[] args) {

        JFrame frame = new JFrame(); // This is create a frame object to house the contents of our window
        JPanel panel = new JPanel(); // Creating a new panel object, the panel is where the content is shown, and then panel in turn is displayed by the frame

        frame.setSize(500, 200); // Setting the size of the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes sure that when we close the window the java process also exits
        frame.add(panel); // Adds our panel to the frame
        frame.setTitle("MATHTASTIC"); // Sets the title of the window

        panel.setLayout(null); // Makes sure there is no layout, like grid etc. Allows us to place elements w/ coordinates

        // Prints a message before the windows is displayed, explaining what the program does
        JOptionPane.showMessageDialog(null, "Hello, welcome to MATHTASTIC, please enter a number and it will be expanded, e.g 1234 = 1000 + 200 + 30 + 4");

        // Creates a label, assigns text, positions it with coordinates and adds it to the panel so it is shown
        label = new JLabel("Number Input");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        // Creates a text field to allow the user to input text, in this case a number which will be used below
        numberInput = new JTextField(8);
        numberInput.setBounds(100, 20, 165,25);
        panel.add(numberInput);

        // Creates a button that when pressed calls the ActionLister method (ActionPerformed) to do something when the button is pressed
        button = new JButton("Submit for Expansion");
        button.setBounds(10,60,200,25);
        // the `new App();` creates a new App object, as ActionListener is an object and App is a class, they have no relation, hence the `implements ActionListener` in the class declaration
        button.addActionListener(new App());
        panel.add(button);

        // Creates a second label, assigns text, positions it with coordinates and adds it to the panel so it is shown
        textBox = new JLabel("Your Expanded Number:");
        textBox.setBounds(10,100,200,25);
        panel.add(textBox);

        // Adds a second label that we can put our expanded number into, after it is calculated below
        expandedNumber = new JLabel("");
        expandedNumber.setBounds(10, 125, 450, 25);
        panel.add(expandedNumber);

        // Makes sure that everything that is put into the panel is visible
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = numberInput.getText(); // Grabs whatever is inside the `numberInput` text field

        long num1 = Long.parseLong(number); // Turns the string from before into an long, using long so that 10 digit numbers don't throw an exception
        long num; // Declaring an int num variable to be used below

        if (num1 <= 0) {
            // Checks if the number is 0 or negative, if so, warns the user
            JOptionPane.showMessageDialog(null, "No Result!");
        }
        else if (num1 > 99999999) {
            // Checks if the number is greater than 8 digits long, if so, warns the user
            JOptionPane.showMessageDialog(null, "Sorry you entered a number over 8 digits long!");
        }
        else {
            // Else, converts `number` String to Int
            num = Integer.parseInt(number);

            // Initializes array `numArray`
            long[] numArray = new long[8];

            numArray[0] = num % 10; // Modulo 10 just gets out the last digit
            numArray[1] = ((num % 100) - numArray[0]); // % 100 gets last two digits, subtract the previous ones
            numArray[2] = ((num % 1000) - numArray[0] - numArray[1]); // % 1000 gets last three digits, subtract the previous ones
            numArray[3] = ((num % 10000) - numArray[0] - numArray[1] - numArray[2]); // Same as above but greater number to modulo by
            numArray[4] = ((num % 100000) - numArray[0] - numArray[1] - numArray[2] - numArray[3]);
            numArray[5] = ((num % 1000000) - numArray[0] - numArray[1] - numArray[2] - numArray[3] - numArray[4]);
            numArray[6] = ((num % 10000000) - numArray[0] - numArray[1] - numArray[2] - numArray[3] - numArray[4] - numArray[5]);
            numArray[7] = ((num % 100000000) - numArray[0] - numArray[1] - numArray[2] - numArray[3] - numArray[4] - numArray[5] - numArray[6]);

            String expandedStringNum = ""; // Declares string to be displayed in the text box

            for (int i = 7; i >= 0; i--) { // Goes through the array until hits zero, we are going backwards as we want the largest numbers first
                if (numArray[i] != numArray[0] && numArray[i] != 0) { // Checks it is not the last digit or the number is zero and not inside the number e.g 00091 would print 90 + 1
                    expandedStringNum += numArray[i] + " + ";
                } else if (i < 7 && i > 0 && (numArray[i + 1] != 0)) { // This allows the zeros inside numbers to be printed, e.g 7091 is 7000 + 0 + 90 + 1
                    expandedStringNum += numArray[i] + " + ";
                } else if (numArray[i] == numArray[0]) { // If it is the last digit then instead of + it print = and then the original number
                    expandedStringNum += numArray[i] + " = " + num;;
                }
            }

            expandedNumber.setText(expandedStringNum); // Sends the string calculated above into the text box in the windows
        }



    }
}


