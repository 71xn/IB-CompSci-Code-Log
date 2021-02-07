import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI {

    private static SQL sqlObj = App.getSqlObj();
    private static LinkedList<LinkedList> table = sqlObj.readPeopleData("SELECT * from people");

    private static JTextField nameSearch;
    private static LinkedList<String> firstName = table.get(0);
    private static LinkedList<String> lastName = table.get(1);
    private static LinkedList<Integer> ages = table.get(2);



    public static void main(String[] args) {
        JFrame frame = new JFrame(); // This is create a frame object to house the contents of our window
        JPanel panel = new JPanel(); // Creating a new panel object, the panel is where the content is shown, and then panel in turn is displayed by the frame

        frame.setSize(800, 400); // Setting the size of the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes sure that when we close the window the java process also exits
        frame.add(panel); // Adds our panel to the frame
        frame.setTitle("People Database Search"); // Sets the title of the window
        panel.setLayout(null); // Makes sure there is no layout, like grid etc. Allows us to place elements w/ coordinates

        // Results Label
        JLabel resultsHeading = new JLabel("<html> <u>Search / Sort Results:<u> <br> First Name | Last Name | Age");
        resultsHeading.setBounds(10,95,300,30);
        panel.add(resultsHeading);

        // Results Box
        JLabel resultsLabel = new JLabel();
        resultsLabel.setBounds(10, 125, 300, 200);
        panel.add(resultsLabel);


        JLabel label = new JLabel("Name to Search for:");
        label.setBounds(10, 20, 170, 25);
        panel.add(label);

        JLabel label2 = new JLabel("Age to Search For:");
        label2.setBounds(380,20,170,25);
        panel.add(label2);

        JTextField ageSearch = new JTextField(8);
        ageSearch.setBounds(540,20,200,25);
        panel.add(ageSearch);

        // Age Search Query Button
        JButton ageSearchButton = new JButton("Run Age Search");
        ageSearchButton.setBounds(380, 60, 200, 25);
        ageSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String ageStr = ageSearch.getText();
                int age = Integer.parseInt(ageStr);

                StringBuilder output = new StringBuilder();
                output.append("<html> ");
                for (int i = 0; i < ages.size(); i++) {
                    if (ages.get(i) == age) {
                        output.append(firstName.get(i) + " " + lastName.get(i) + ", Age: " + ages.get(i)).append("<br>");
                    }
                }
                resultsLabel.setText(output.toString());
            }
        });

        panel.add(ageSearchButton);

        // Creates a text field to allow the user to input text, in this case a number which will be used below
        nameSearch = new JTextField(8);
        nameSearch.setBounds(185, 20, 165,25);
        panel.add(nameSearch);

        // Name search query button
        JButton nameSearchButton = new JButton("Run Name Search");
        nameSearchButton.setBounds(10,60,200,25);
        nameSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder output = new StringBuilder();
                output.append("<html> ");
                String search = nameSearch.getText();
                if(search.equals("")) {
                    for (int i = 0; i < firstName.size(); i++) {
                        output.append(firstName.get(i) + " " + lastName.get(i) + ", Age: " + ages.get(i)).append("<br>");
                    }
                } else {
                    for (int i = 0; i < firstName.size(); i++) {
                        if (search.equals(firstName.get(i))) {
                            output.append(firstName.get(i) + " " + lastName.get(i) + ", Age: " + ages.get(i)).append("<br>");
                        } else if (search.equals(lastName.get(i))) {
                            output.append(firstName.get(i) + " " + lastName.get(i) + ", Age: " + ages.get(i)).append("<br>");
                        }
                    }
                }

                resultsLabel.setText(output.toString());
            }
        });
        panel.add(nameSearchButton);

        // Makes sure that everything that is put into the panel is visible
        frame.setVisible(true);
    }

}
