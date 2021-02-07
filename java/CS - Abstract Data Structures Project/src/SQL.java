import java.sql.*;
import java.util.LinkedList;

public class SQL {
    private Connection con = null;
    private Tree tree = new Tree();

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

    public Tree readData(String query) {
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                this.tree.add(rs.getInt("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.tree;
    }
}
