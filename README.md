# Algorithms Specialization

This repository contains Java implementations of algorithms and data structures covered in the [Algorithms Specialization](https://www.coursera.org/specializations/algorithms) by **Tim Roughgarden (Stanford University)** on Coursera.

Each folder contains algorithms grouped by category, following the structure of the course.

---

## 📘 Topics Covered

- Divide and Conquer Algorithms
- Graph Algorithms
- Data Structures

---

## 📁 Project Structure

```
java/
├── algorithms/
│   ├── divide_and_conquer/
│   │   ├── sorting/
│   │   ├── sorting_and_inversion_count/
│   │   ├── sorting_and_comparison_count/
│   │   ├── integer_multiplication/
│   │   └── selection/
│   ├── graph_algorithms/
│   │   ├── min_cut/
│   │   ├── search/
│   │   │   └── dijkstra/
├── data_structures/
│   ├── heap/
│   ├── tree/
│   └── hash_table/
```

- Each folder contains algorithm implementations and a dedicated `Main` class for running tests.

---

## 💻 How to run

Open the repository folder in **Visual Studio Code** and:

1. Open the specific `Main` class file you want to run (e.g., `MainSorting.java` for sorting algorithms).
2. At the top of `MainSorting.java`, you'll typically find a configuration like:

   ```java
   private static final String SORTING_ALGORITHM = "MergeSort";
   ```

   Replace "MergeSort" with the name of the algorithm class you want to run.

4. Use the Java terminal or debugger to compile and run the selected file.

---

## 📖 Algorithms Implemented

### 🧠 Divide and Conquer

#### 📊 Sorting
- Merge Sort
- Quick Sort

#### 🔄 Inversion Counting
- Merge Sort with Inversion Counting

#### 🔄 Comparison Counting
- Quick Sort with Comparison Counting

#### 🧮 Integer Multiplication
- Karatsuba  

#### 🔍 Selection
- Randomized Selection (RSelect)

---

### 🌐 Graph Algorithms

#### ✂️ Minimum Cut
- Karger’s Randomized Contraction Algorithm

#### 🔍 Search
- BFS (Breadth-First Search)
- BFS Connected Components
- BFS Shortest Paths
- DFS (Depth-First Search)
- DFS Topological Sort
- DFS Strongly Connected Components (Kosaraju’s Algorithm)
- Dijkstra (naive implementation, heap-based implementation)

## 📚 Data Structures implemented

#### 🔼 Heap
- Implementation of a MinHeap data structure

#### 🌳 Tree
- BinarySearchTree: standard BST operations (insert, search, in-order traversal)
- RedBlackTree: self-balancing BST with rotations and recoloring

### 🗃️ Hash Table
- **Hash Table**: stores key-value pairs using a hash function to map keys to indices in an underlying array. Supports fast `insert`, `remove`, and `lookup` operations (average-case O(1)).
- Ideal for scenarios requiring **quick access or membership checks**. Collisions are handled via chaining or open addressing.
- **Bloom Filters**: probabilistic data structure for set membership checks with very low memory usage. Can return false positives but never false negatives.

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Credits

Algorithm concepts and explanations are based on the **Algorithms Specialization** course by **Tim Roughgarden**, Stanford University.

