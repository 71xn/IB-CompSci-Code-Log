import java.util.Scanner;

public class CLI {

    private App app = new App();
    private Scanner sc = new Scanner(System.in);

    public CLI() {
        System.out.println("Hello, this program would have ideally been a gui but swing is clunky and annoying, however, welcome, we have a sql database with random integers between 1 - 30");
        System.out.println("Here are the numbers from the DB, stored in a binary search tree, displayed in order:");
        app.treeDB.inOrder();
        System.out.println("You can perform various operations on the data, such as:");
        System.out.println("1. View Data in In-Order");
        System.out.println("2. View Data in Pre-Order");
        System.out.println("3. View Data in Post-Order");
        System.out.println("4. Remove Data");
        System.out.println("5. Add Data");
        System.out.println("6. Create new BST based on search criteria");
        System.out.println("7. Exit");
        menu();
    }

    public void menu() {

        System.out.println("Please choose another option, to see options again enter 8: ");
        int userInput = sc.nextInt();
        menuOptions(userInput);
    }

    public void menuOptions(int usr) {
        switch (usr) {
            case 1:
                System.out.println("Here are the numbers displayed using In-Order Traversal:");
                app.treeDB.inOrder();
                menu();
                break;
            case 2:
                System.out.println("Here are the numbers displayed using Pre-Order Traversal:");
                app.treeDB.preOrder();
                menu();
                break;
            case 3:
                System.out.println("Here are the numbers displayed using Post-Order Traversal:");
                app.treeDB.postOrder();
                menu();
                break;
            case 4:
                System.out.println("Please input a number you would like removed: ");
                int toRemove = sc.nextInt();
                app.treeDB.remove(toRemove);
                System.out.println("Here is the tree after the number has been removed:");
                app.treeDB.inOrder();
                menu();
                break;
            case 5:
                System.out.println("Please input a number to be added (>= 0 & < 30): ");
                int toAdd = sc.nextInt();
                app.treeDB.add(toAdd);
                System.out.println("Here is the tree after the number has been added:");
                app.treeDB.inOrder();
                menu();
                break;
            case 6:
                System.out.println("This option recreates the binary search tree given a range, lowest value and maximum value to be included in the tree.");
                System.out.println("Please input the minimum value: ");
                int min = sc.nextInt();
                System.out.println("Please input the max value: ");
                int max = sc.nextInt();
                app.treeDB = newTree(min, max);
                menu();
                break;
            case 7:
                System.exit(0);
                break;
            case 8:
                System.out.println("1. View Data in In-Order");
                System.out.println("2. View Data in Pre-Order");
                System.out.println("3. View Data in Post-Order");
                System.out.println("4. Remove Data");
                System.out.println("5. Add Data");
                System.out.println("6. Create new BST based on search criteria");
                System.out.println("7. Exit");
                menu();
                break;
        }
    }

    public Tree newTree(int min, int max) {
        for (int i = 0; i < min; i++) {
            if (app.treeDB.contains(i)) {
                app.treeDB.remove(i);
            }
        }
        for (int j = max - 1; j < 30; j++) {
            if (app.treeDB.contains(j)) {
                app.treeDB.remove(j);
            }
        }
        return app.treeDB;
    }

}
