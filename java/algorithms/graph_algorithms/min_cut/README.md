# ✂️ Minimum Cut (Karger's Algorithm)

This folder contains an implementation of Karger's Randomized Contraction Algorithm to compute the Minimum Cut of an undirected graph.

## 📌 Implemented Algorithms

### Karger's Randomized Contraction Algorithm
- **Time Complexity:** O(n²) per run (expected), O(n² log n) with repetition
- **Description:** A Monte Carlo algorithm that contracts edges randomly until only two nodes remain. The number of edges between these two supernodes is a possible minimum cut.
- **How it works:**
  1. Repeatedly choose a random edge (u, v)
  2. Merge vertex `v` into `u`, combining their edges
  3. Replace all appearances of `v` with `u`
  4. Remove self-loops
  5. Repeat until only two vertices remain
- **Why use it:** Extremely simple to implement and works well for small/medium graphs. Repeating the algorithm increases the probability of finding the true minimum cut.

### Repeated Karger's Algorithm
- Runs the contraction multiple times (with fresh copies of the graph) to increase the chance of getting the actual minimum cut.
- The probability of success improves exponentially with more trials.

## 📂 Input Format

The graph must be provided as a text file in adjacency list format (tab-separated):

1 2 3 4
2 1 3
3 1 2 4
4 1 3

Each line represents a node followed by its connected neighbors.

## 🚀 How to Run

1. Make sure your graph file is formatted correctly and available in your project directory.
2. Call the methods like this:

```java
Map<Integer, List<Integer>> graph = RandomizedContraction.readGraph("kargerMinCut.txt");
int minCut = RandomizedContraction.repeatedMinCut(graph, 100); // 100 trials
System.out.println("Minimum Cut found: " + minCut);
