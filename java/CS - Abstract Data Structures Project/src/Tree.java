/*
Finn Lestrange - 06/02/21
Binary Search Tree Implementation

Would not have been possible without: https://www.baeldung.com/java-binary-tree
 */

public class Tree {

    // Each Tree has a root node
    private Node root;

    /*
    Node Class
    Each Node has left and right pointer, with data
     */

    class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }


    /*
    Adding New Nodes To The Tree
     - Public method to call the recursive subroutine
     - Traverses the tree recursively till the node finds its place
     */

    public void add (int data) {
        this.root = add(root, data);
    }


    private Node add(Node root, int data) {
        if (root == null) { // If we are at an empty branch, add a new node
            return new Node(data);
        }

        if (data < root.data) { // If the data is less than the current node, move to the left
            root.left = add(root.left, data);
        } else if (data > root.data) {
            root.right = add(root.right, data);
        } else { // If the data already exists
            return root;
        }

        return root;
    }

    /* Checking if a Tree contains a certain Node
     - Public method to call the recursive subroutine
     - Recursively traverses the tree like the add method
     */
    public boolean contains(int data) {
        return contains(this.root, data);
    }

    private boolean contains(Node root, int data) {
        // If we are at an empty node then return false as it means data is not in Tree
        if (root == null) {
            return false;
        }

        // If data we are searching for matches data of current node return True
        if (data == root.data) {
            return true;
        }

        // If the data is less, then move to the left and call the contains method again with a new node of the left branch
        if (data < root.data) {
            return contains(root.left, data);
        } else if (data > root.data) { // If the data is greater than current nodes data, move to right and call contains with node of right branch
            return contains(root.right, data);
        }

        return false;
    }

    /*
    Removes a node from the tree, keeping correct order
     */
    public void remove(int data){
        remove(this.root, data);
    }

    private Node remove(Node root, int data) {
        if (root == null) {
            return null;
        }

        // If we are at the node we want to delete
        if (data == root.data) {
            if (root.left == null && root.right == null) { // If both children are null, e.g a leaf node, we can just delete it and return null
                return null;
            }
            if (root.right == null) { // If the right node is null we replace the parent node (current root) with the left subtree node
                return root.left;
            }
            if (root.left == null) { // If the left node is null we replace the parent node (current root) with the right subtree node
                return root.right;
            }

            int smallestValue = findSmallestValue(root.right); // We find the smallest value on the left subtree of the right child node
            root.data = smallestValue; // reassign the parent node to the data that it is being replaced by
            root.right = remove(root.right, smallestValue); // remove the smallest value as it has been reassigned
            return root;

        } else if (data < root.data) { // If node to delete is smaller, go to left subtree
            root.left = remove(root.left, data);
        } else if (data > root.data) { // If node to delete greater, go to right subtree
            root.right = remove(root.right, data);
        }

        root.right = remove(root.right, data);
        return root;
    }

    /*
    Traverses the left subtree till it finds the bottom most leaf and returns it, this is the smallest value in bst
     */
    private int findSmallestValue(Node root) { // boolean statement ? true result : false result; ? is a temary operator
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    /*
    Tree Traversal
     */

    // In-Order Tree Traversal
    public void inOrder() {
        inOrder(this.root);
    }

    /*
    Left, root, right, smallest to biggest values
     */
    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data + " ");
            inOrder(root.right);
        }
    }

    // Pre-Order Tree Traversal
    public void preOrder() {
        preOrder(this.root);
    }
    /*
    Root, left subtree, right subtree
     */
    private void preOrder(Node root) {
        if (root != null) { // Prevents us from getting NullPointerException as without it we would be trying to get the data on nonexistent subtree nodes
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    // Post-Order Traversal
    public void postOrder() {
        postOrder(this.root);
    }

    /*
    Left subtree, right subtree, root
     */
    private void postOrder(Node root){
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
        }
    }

}
