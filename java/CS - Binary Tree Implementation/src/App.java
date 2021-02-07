public class App {

    public App() {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        tree.add(5);
        tree.add(4);
        tree.add(2);
        tree.add(21);
        System.out.println("Does the tree contain a 4?");
        System.out.println(tree.contains(4));
        System.out.println("In-Order Traversal");
        tree.inOrder();
        System.out.println("Removing 4 . . .");
        tree.remove(4);
        System.out.println("Does the tree still contain 4?");
        System.out.println(tree.contains(4));
        System.out.println("In-Order Traversal");
        tree.inOrder();
        System.out.println("Pre-Order Traversal");
        tree.preOrder();
        System.out.println("Post-Order Traversal");
        tree.postOrder();
    }

    public static void main(String[] args) {
        new App();
    }

}
