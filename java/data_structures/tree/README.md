# 🌳 Tree Data Structures

This folder contains Java implementations of **tree data structures**, currently including:

- **Red-Black Tree** (self-balancing binary search tree)

---

## 📌 Implemented Classes

### BinarySearchTree.java
- Provides the **basic BST functionality**:
  - `insert(int key)`: inserts a new key using standard BST rules (no balancing)
  - `search(int key)`: searches for a key in the tree
  - `inorder()`: prints all elements in sorted order

### RedBlackTree.java
- Extends `BinarySearchTree` and adds **balancing rules**:
  - Each node has a `color` (RED or BLACK)
  - Maintains Red-Black Tree properties:
    - Root is always black
    - No consecutive red nodes
    - Equal black height on all paths
- Overrides `insert` to include `fixInsert` (rotations + recoloring)
- Uses `rotateLeft` and `rotateRight` to restructure the tree

### MainTree.java
- Demonstrates how to use `RedBlackTree`
- Inserts values, prints in-order traversal, searches for elements

---

## 🧠 Concept Overview

- A **Binary Search Tree (BST)** stores values such that for each node:
  - Left subtree keys < node key
  - Right subtree keys > node key
- **Red-Black Tree** is a BST with additional rules to ensure balance:
  - Guarantees **O(log n)** insertion, deletion, and search
  - Uses rotations and recoloring to maintain properties

---

## 🚀 How to Run

Run `MainTree.java` to see the Red-Black Tree in action:

```bash
=== Red-Black Tree Demo ===
In-order traversal: 10 15 20 25 30
Search 15: true
Search 99: false
