import java.sql.*;
import java.util.LinkedList;

public class SQL {
    private Connection con = null;
    private LinkedList<LinkedList> table = new LinkedList();

    public SQL(String server, String schema, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // You need this: https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.21.zip and https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
            //System.out.println("Driver loaded!"); // This was used for debugging the MySQL JBDC Connector
            String sqlUrl = "jdbc:mysql://" + server + ":3306/" + schema;
            con = DriverManager.getConnection(sqlUrl, username, password); // Establishes a connection to the SQL Database
            //System.out.println("Connected!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList readPeopleData(String query) {
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            // Declaring Lists for columns
            LinkedList<String> firstNames = new LinkedList<>();
            LinkedList<String> lastNames = new LinkedList<>();
            LinkedList<Integer> age = new LinkedList<>();

            while (rs.next()) {
                firstNames.add(rs.getString("firstName"));
                lastNames.add(rs.getString("lastName"));
                age.add(rs.getInt("age"));
            }

            // List to store whole table
            this.table.add(firstNames);
            this.table.add(lastNames);
            this.table.add(age);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.table;
    }

    public LinkedList getTable() {
        return this.table;
    }

}

/*
DB Schema
----------------
| People Table |
----------------

| first name (string) | last name (string) | age (int) | height in cm (double) | weight in kg (double) |


 */