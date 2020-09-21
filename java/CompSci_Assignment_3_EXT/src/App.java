// Finn Lestrange - 20/09/2020
// Computer Science Assignment 3 Extension with SQL Support

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App implements ActionListener { // `implements ActionListener` is used for making the button do something, Line 77

    // Create instances of the necessary swing methods, to be used in main and in the ActionListener method
    private static JTextField priceInput;
    private static JLabel output1;
    private static JLabel output2;
    private static JLabel textBox;
    private static JLabel textBox2;

    // Arrays used for processing, has to be static so that data can be inputted in tne static main method
    public static ArrayList<Double> vacuumPrice = new ArrayList<>();
    public static ArrayList<String> model = new ArrayList<>();
    public static ArrayList<String> features = new ArrayList<>();

    public static void main(String[] args) {
        // SQL Stuff - Would not have been possible without learning from - http://alvinalexander.com/java/java-mysql-select-query-example/
        try {
            String myUrl = "jdbc:mysql://sql2.freemysqlhosting.net:3306/database";
            Class.forName("com.mysql.cj.jdbc.Driver"); // You need this: https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.21.zip and https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
            // System.out.println("Driver loaded!"); // This was used for debugging the MySQL JBDC Connector
            Connection conn = DriverManager.getConnection(myUrl, "user", "pass"); // Establishes a connection to the SQL Database

            // Creates a sql query to get all the data in the JavaApp1 Table
            String query = "SELECT * FROM JavaApp1";

            // create the java statement, used for executing a static SQL Query with JDBC
            Statement statement = conn.createStatement();

            // execute the query, and get a java ResultSet of data that can be added to our arraylist
            ResultSet resultset = statement.executeQuery(query);

            // iterate through the java ResultSet and add data to the ArrayLists
            while (resultset.next()) {
                vacuumPrice.add(resultset.getDouble("price"));
                model.add(resultset.getString("model"));
                features.add(resultset.getString("features"));
            }
            statement.close(); // Once all the data has been added to the Arrays, the sql connection is closed
        } catch (Exception e) { // If the sql connection fails, or the JDBC Driver is not added to the classpath
            System.out.println("Whoops, SQL Connection Failed!");
        }

        // Window Stuff
        JFrame frame = new JFrame(); // This is create a frame object to house the contents of our window
        JPanel panel = new JPanel(); // Creating a new panel object, the panel is where the content is shown, and then panel in turn is displayed by the frame

        frame.setSize(800, 400); // Setting the size of the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes sure that when we close the window the java process also exits
        frame.add(panel); // Adds our panel to the frame
        frame.setTitle("AIRMASTER: Vacuum Cleaner Shop"); // Sets the title of the window
        panel.setLayout(null); // Makes sure there is no layout, like grid etc. Allows us to place elements w/ coordinates

        // Prints a message before the windows is displayed, explaining what the program does
        JOptionPane.showMessageDialog(null, "Hello, welcome to the AIRMASTER Vacuum Shop! Please enter your price and we will display the vacuums you can afford! ");

        // Creates a label, assigns text, positions it with coordinates and adds it to the panel so it is shown
        JLabel label = new JLabel("Maximum Price: £");
        label.setBounds(10, 20, 170, 25);
        panel.add(label);

        // Creates a text field to allow the user to input text, in this case a number which will be used below
        priceInput = new JTextField(8);
        priceInput.setBounds(185, 20, 165,25);
        panel.add(priceInput);

        // Creates a button that when pressed calls the ActionLister method (ActionPerformed) to do something when the button is pressed
        JButton button = new JButton("Check Available Vacuum's");
        button.setBounds(10,60,200,25);
        // the `new App();` creates a new App object, as ActionListener is an object and App is a class, they have no relation, hence the `implements ActionListener` in the class declaration
        button.addActionListener(new App());
        panel.add(button);

        // Creates a second label, assigns text, positions it with coordinates and adds it to the panel so it is shown
        textBox = new JLabel("");
        textBox.setBounds(10,100,500,25);
        panel.add(textBox);

        output1 = new JLabel("");
        output1.setBounds(10, 125, 750, 175);
        panel.add(output1);

        textBox2 = new JLabel("");
        textBox2.setBounds(10,300,500,25);
        panel.add(textBox2);

        output2 = new JLabel("");
        output2.setBounds(10, 325, 750, 40);
        panel.add(output2);

        // Makes sure that everything that is put into the panel is visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = priceInput.getText();
        double price = Double.parseDouble(number);
        String output = "";
        textBox.setText("These are the vacuums and their features up to £" + price);

        if (price <= 0 || price > 999999999) { // Check for valid input number
            JOptionPane.showMessageDialog(null, "Sorry! You entered something wrong!");
        } else { // If input is valid
            for (int i = 0; i < vacuumPrice.size(); i++) { // Loop through price arraylist and only display the vacuums that are under or the same price as the user inputted
                if (vacuumPrice.get(i) <= price) {
                    output = output + model.get(i) + ": " + features.get(i) + " : £" + vacuumPrice.get(i) + "<br>"; // Swing JLabel supports html for formatting, used here to get line breaks as "\n" doesn't work
                    // https://stackoverflow.com/questions/1090098/newline-in-jlabel
                }
            }
            output1.setText("<html>" + output + "</html>"); // Sets the text box in the windows and adds the html tags  so everything is formatted properly -
        }

        output = "";
        double priceUp = price * 0.1;
        textBox2.setText("If you are willing to pay £" + priceUp + " more then you can also get:");
        // This does the same as above but shows you what you can get if you spend 10% more
        for (int i = 0; i < vacuumPrice.size(); i++) {
            if (vacuumPrice.get(i) > price && vacuumPrice.get(i) <= (priceUp + price)) {
                output = output + model.get(i) + ": " + features.get(i) + " : £" + vacuumPrice.get(i) + "<br>"; // <br> for the line breaks as "\n" doesn't work with JLabel
            }
        }
        output2.setText("<html>" + output + "</html>"); // More html formatting for the line breaks used above
    }
}