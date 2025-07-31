# Algorithms Specialization

This repository contains Java implementations of algorithms covered in the [Algorithms Specialization](https://www.coursera.org/specializations/algorithms) by **Tim Roughgarden (Stanford University)** on Coursera.

Each folder contains algorithms grouped by category, following the structure of the course.

---

## 📘 Topics Covered

- Divide and Conquer
- Graph Algorithms

---

## 📁 Project Structure

```
java/
├── divide_and_conquer/
│   ├── sorting/
│   │   ├── MergeSort.java
│   │   ├── QuickSort.java
│   │   └── MainSorting.java
│   ├── sorting_and_inversion_count/
│   │   ├── MergeSortAndCount.java
│   │   ├── MainSortingAndInversionCount.java
│   │   └── MainSortingAndInversionCountFromFile.java
│   ├── sorting_and_comparison_count/
│   │   ├── QuickSortCounter.java
│   │   └── QuickSortCounterMain.java
│   ├── integer_multiplication/
│   │   ├── Karatsuba.java
│   │   └── MainIntegerMultiplication.java
│   ├── selection/
│   │   ├── RandomizedSelection.java
│   │   └── MainSelection.java
├── graph_algorithms/
│   ├── min_cut/
│   │   ├── RandomizedContraction.java
│   │   └── MainMinCut.java
│   ├── search/
│   │   ├── BFS.java
│   │   ├── BFSConnectedComponents.java
│   │   ├── BFSShortestPaths.java
│   │   ├── DFS.java
│   │   ├── DFSTopologicalSort.java
│   │   ├── DFSSCC.java
│   │   ├── Graph.java
│   │   ├── GraphSearchAlgorithm.java
│   │   ├── GraphSearchAlgorithmFactory.java
│   │   └── MainSearch.java
│   │   └── dijkstra/
│   │       ├── DijkstraStandard.java
│   │       ├── DijkstraHeap.java
│   │       ├── Edge.java
│   │       ├── GraphWeighted.java
│   │       ├── GraphWeightedSearchAlgorithm.java
│   │       └── MainSearchFromFile.java

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
- Dijkstra (linear implementation, heap-based implementation)

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Credits

Algorithm concepts and explanations are based on the **Algorithms Specialization** course by **Tim Roughgarden**, Stanford University.

