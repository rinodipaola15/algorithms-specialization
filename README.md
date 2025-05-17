# Algorithms Specialization

This repository contains Java implementations of algorithms covered in the [Algorithms Specialization](https://www.coursera.org/specializations/algorithms) by **Tim Roughgarden** (Stanford University) on Coursera.

Each folder contains algorithms grouped by category, following the structure of the course.

---

## 📘 Topics Covered

- Divide and Conquer
- Sorting and Searching
- Graph Algorithms
- Greedy Algorithms
- Dynamic Programming
- NP-Completeness

---

## 📁 Project Structure

```
java/
├── sorting/
│ ├── MergeSort.java
│ ├── QuickSort.java
│ └── MainSorting.java
├── graphs/
│ ├── DFS.java
│ ├── BFS.java
│ └── MainGraphs.java
├── dynamic_programming/
│ ├── Knapsack.java
│ └── MainDP.java
```


- Each folder contains algorithm implementations and a dedicated `Main` class for running tests.

---

## 💻 How to run

Open the repository folder in **Visual Studio Code** and:

1. Open the specific `Main` class file you want to run (e.g., `MainSorting.java` for sorting algorithms).
2. At the top of `MainSorting.java`, you'll find:

   ```java
   private static final String SORTING_ALGORITHM = "MergeSort";
   ```

   Replace "MergeSort" with the name of the algorithm class you want to run, for example:

   ```java
   private static final String SORTING_ALGORITHM = "QuickSort";
   ```

4. Use the Java terminal or debugger to compile and run the selected file.
   
---

## 📖 Algorithms Covered

- **Sorting:** Merge Sort, Quick Sort, etc.
- **Graphs:** Depth-First Search (DFS), Breadth-First Search (BFS), etc.
- **Dynamic Programming:** Knapsack Problem, etc.

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Credits

Algorithm concepts and explanations are based on the **Algorithms Specialization** course by **Tim Roughgarden**, Stanford University.

