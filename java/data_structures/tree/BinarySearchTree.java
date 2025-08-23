/**
 * Basic Binary Search Tree (BST) implementation.
 *
 * This class provides the standard BST operations:
 * - Insertion (without balancing)
 * - Search
 * - Traversal (in-order)
 *
 * Balanced trees (e.g., Red-Black Tree, AVL Tree) can extend this class
 * and override methods where balancing is needed.
 */
public class BinarySearchTree {
    /**
     * Inner class representing a node of the BST.
     * Each node stores:
     * - key: the value stored in the node
     * - left, right: references to child nodes
     * - parent: reference to the parent node
     */
    protected class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
        }
    }

    /** Root of the BST */
    protected Node root;

    /**
     * Insert a key into the BST.
     * This method performs a standard (unbalanced) BST insertion:
     * - Smaller keys go to the left subtree
     * - Larger keys go to the right subtree
     *
     * @param key value to insert
     * @return the newly inserted node
     */
    public Node insert(int key) {
        Node node = new Node(key);
        root = bstInsert(root, node); // use recursive helper
        return node;
    }

    /**
     * Search for a key in the BST.
     *
     * @param key value to search
     * @return true if key is found, false otherwise
     */
    public boolean search(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return true;
            if (key < current.key) current = current.left;
            else current = current.right;
        }
        return false;
    }

    /**
     * Perform an in-order traversal of the BST.
     * In-order traversal visits nodes in ascending order:
     * - Recursively visit the left subtree
     * - Visit the current node
     * - Recursively visit the right subtree
     *
     * Example: for keys {10, 20, 5}, in-order prints "5 10 20".
     */
    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    /**
     * Helper method for recursive in-order traversal.
     * @param node current node being visited
     */
    private void inorderHelper(Node node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(node.key + " ");
            inorderHelper(node.right);
        }
    }

    /**
     * Recursive helper for standard BST insertion.
     * This method attaches a new node in the correct position
     * (left or right subtree) according to BST rules.
     *
     * @param root current root of the subtree
     * @param node new node to insert
     * @return updated subtree root
     */
    protected Node bstInsert(Node root, Node node) {
        if (root == null) return node;

        if (node.key < root.key) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.key > root.key) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        // If equal, do nothing (this BST does not allow duplicates)
        return root;
    }
}
