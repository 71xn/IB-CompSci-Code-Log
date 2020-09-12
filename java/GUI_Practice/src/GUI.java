// Finn Lestrange - 12/09/2020
// Simple GUI Application using Swing

// Followed this video: https://www.youtube.com/watch?v=5o3fMLPY7qY&ab_channel=AlexLee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI() { // Making a new GUI Constructor, basically a method to house our GUI stuff, treated like a method

        frame = new JFrame(); // This is create a windows object to house the contents of our windows

        // Creating label and button objects
        JButton button = new JButton("Click Me!");
        label = new JLabel("Number of clicks: 0");

        // Allowing the button object to register clicks
        button.addActionListener(this);

        panel = new JPanel(); // Creating a new panel object, the panel is where the content is shown, and then panel in turn is displayed by the frame

        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 100, 150)); // Create a new Border object using BorderFactory and setting the panel border to the object
        panel.setLayout(new GridLayout(0, 1)); // Setting the panel layout to a grid, so that we can place objects in that grid
        panel.add(button); // Adds our button to the GUI
        panel.add(label); // Adds our label to the GUI

        frame.add(panel, BorderLayout.CENTER); // Makes sure the layout is centred
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes sure that when we close the app the window also closes
        frame.setTitle("Simple GUI"); // Sets the title of the window
        frame.pack(); // Packs all the elements and send them to the frame to be displayed
        frame.setVisible(true); // Makes sure the windows is visible

    }

    public static void main(String[] args) {
        new GUI(); // Creates a new GUI Object, which goes to the above constructor



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}
