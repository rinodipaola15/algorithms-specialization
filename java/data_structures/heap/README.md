# 🔼 Heap Data Structures (MinHeap & MaxHeap)

This folder contains Java implementations of **MinHeap** and **MaxHeap** data structures, which support efficient insertion, extraction of the extremal element, and heapify operations.

## 📌 Implemented Classes

### MinHeap.java
- Implements a binary **min-heap** using an array.
- Supports operations such as:
  - `insert(int value)`: adds a new element while maintaining heap property.
  - `extractMin()`: removes and returns the smallest element.
  - `heapify(int index)`: restores heap property starting from a given node.
- Uses zero-based indexing with parent/child relations:
  - Left child of `i`: `2*i + 1`
  - Right child of `i`: `2*i + 2`
  - Parent of `i`: `(i - 1) / 2`
- Ensures the array is compact with no gaps between elements.
- Guarantees that no node has a right child without a left child, by design of a complete binary tree.

### MaxHeap.java
- Implements a binary **max-heap** using an array.
- Supports operations such as:
  - `insert(int value)`: adds a new element while maintaining heap property.
  - `extractMax()`: removes and returns the largest element.
  - `heapify(int index)`: restores heap property starting from a given node.
- Same indexing scheme as `MinHeap` (zero-based, complete binary tree).
- Property: every parent node is greater than or equal to its children.

### MainHeap.java
- Demonstrates usage of `MinHeap`.
- Inserts several values and extracts the minimum elements in sorted order.
- Also includes examples using Java’s built-in `PriorityQueue` both as a min-heap (default) and as a max-heap (using `Collections.reverseOrder()`).

## 🧠 Concept Overview

- A **heap** is a complete binary tree stored in an array, allowing **O(log n)** insertions and deletions.
- **MinHeap** property: every parent ≤ its children.
- **MaxHeap** property: every parent ≥ its children.
- The compact array representation means elements occupy consecutive indices from `0` to `size - 1`.
- The **priority queue** abstraction often uses heaps internally to manage elements ordered by priority keys.

## 🚀 How to Run

Run `MainHeap.java` to see the heap in action, including custom and built-in implementations.