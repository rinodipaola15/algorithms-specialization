/**
 * Main class to demonstrate tree operations.
 *
 * This file is designed to test different types of trees,
 * not only Red-Black Trees. In the future, we can add:
 * - AVLTree
 * - BinarySearchTree
 * - B-Trees
 * and test them here.
 */
public class MainTree {
    public static void main(String[] args) {
        System.out.println("=== Red-Black Tree Demo ===");
        BinarySearchTree rbt = new RedBlackTree();

        // Insert some elements
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(30);
        rbt.insert(15);
        rbt.insert(25);

        // Print sorted order
        System.out.print("In-order traversal: ");
        rbt.inorder(); // expected sorted order

        // Search for elements
        System.out.println("Search 15: " + rbt.search(15)); // true
        System.out.println("Search 99: " + rbt.search(99)); // false

        // Future placeholders:
        // AVLTree avl = new AVLTree();
        // BinarySearchTree bst = new BinarySearchTree();
    }
}

