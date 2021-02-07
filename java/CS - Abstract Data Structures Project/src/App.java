public class App {

    public SQL sqlObj = new SQL("localhost", "cs", "root", "password");
    public Tree treeDB = sqlObj.readData("SELECT * FROM numbers");


    public static void main(String[] args) {
        new CLI();
    }
}
