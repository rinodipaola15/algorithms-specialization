/**
 * Red-Black Tree implementation extending a basic Binary Search Tree.
 *
 * A Red-Black Tree is a self-balancing BST that guarantees O(log n) operations.
 * It adds balancing rules on top of standard BST insertion.
 */
public class RedBlackTree extends BinarySearchTree {
    /** Color constants */
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * Inner class representing a Red-Black Tree node.
     * Inherits key, children, and parent from BST Node,
     * but adds a color (red or black).
     */
    protected class RBNode extends Node {
        boolean color;

        RBNode(int key) {
            super(key);
            this.color = RED; // new nodes are always inserted red
        }
    }

    /**
     * Insert a new key into the Red-Black Tree.
     * Steps:
     * 1. Perform standard BST insertion
     * 2. Fix Red-Black Tree violations by rotations and recoloring
     *
     * @param key value to insert
     * @return the inserted node
     */
    @Override
    public Node insert(int key) {
        RBNode node = new RBNode(key);
        root = bstInsert(root, node); // standard BST insert
        fixInsert(node);              // balance the tree
        return node;
    }

    /**
     * Fix Red-Black Tree properties after insertion.
     * Cases handled:
     * - Parent is black → nothing to do
     * - Parent is red → need to check uncle and apply rotations/recoloring
     *
     * @param node recently inserted node
     */
    private void fixInsert(RBNode node) {
        Node parent, grandparent;

        while (node != root && ((RBNode) node.parent).color == RED) {
            parent = node.parent;
            grandparent = parent.parent;

            // Case A: parent is left child
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: uncle is red → recolor
                if (uncle != null && ((RBNode) uncle).color == RED) {
                    ((RBNode) parent).color = BLACK;
                    ((RBNode) uncle).color = BLACK;
                    ((RBNode) grandparent).color = RED;
                    node = (RBNode) grandparent;
                } else {
                    // Case 2: node is right child → rotate left
                    if (node == parent.right) {
                        node = (RBNode) parent;
                        rotateLeft(node);
                    }
                    // Case 3: node is left child → rotate right
                    ((RBNode) parent).color = BLACK;
                    ((RBNode) grandparent).color = RED;
                    rotateRight(grandparent);
                }
            }
            // Case B: parent is right child
            else {
                Node uncle = grandparent.left;

                if (uncle != null && ((RBNode) uncle).color == RED) {
                    ((RBNode) parent).color = BLACK;
                    ((RBNode) uncle).color = BLACK;
                    ((RBNode) grandparent).color = RED;
                    node = (RBNode) grandparent;
                } else {
                    if (node == parent.left) {
                        node = (RBNode) parent;
                        rotateRight(node);
                    }
                    ((RBNode) parent).color = BLACK;
                    ((RBNode) grandparent).color = RED;
                    rotateLeft(grandparent);
                }
            }
        }
        ((RBNode) root).color = BLACK; // root must always be black
    }

    /**
     * Rotate a subtree to the left.
     *
     * Example:
     *        x                y
     *         \              / \
     *          y    ->      x   C
     *         / \            \
     *        B   C            B
     *
     * @param node root of the subtree to rotate
     */
    private void rotateLeft(Node node) {
        Node y = node.right;
        node.right = y.left;

        if (y.left != null) y.left.parent = node;
        y.parent = node.parent;

        if (node.parent == null) {
            root = y;
        } else if (node == node.parent.left) {
            node.parent.left = y;
        } else {
            node.parent.right = y;
        }

        y.left = node;
        node.parent = y;
    }

    /**
     * Rotate a subtree to the right.
     *
     * Example:
     *        y                x
     *       /                / \
     *      x      ->        A   y
     *     / \                  /
     *    A   B                B
     *
     * @param node root of the subtree to rotate
     */
    private void rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;

        if (x.right != null) x.right.parent = node;
        x.parent = node.parent;

        if (node.parent == null) {
            root = x;
        } else if (node == node.parent.right) {
            node.parent.right = x;
        } else {
            node.parent.left = x;
        }

        x.right = node;
        node.parent = x;
    }
}
