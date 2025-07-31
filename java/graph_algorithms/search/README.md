# 🔍 Graph Search Algorithms

This folder contains implementations of fundamental graph search algorithms, including BFS and DFS variants.

## 📌 Implemented Algorithms

### BFS (Breadth-First Search)
- **Description:** Visits all nodes reachable from a start node in breadth-first order, marking them as explored.
- **Use case:** Useful for finding shortest paths in unweighted graphs and exploring all nodes layer-by-layer.

### BFSConnectedComponents
- **Description:** Uses BFS to identify connected components in an undirected graph.
- **Use case:** Detects how many disconnected subgraphs exist and which nodes belong to each component.

### BFSShortestPaths
- **Description:** Computes shortest paths and distances from a source node to all reachable nodes using BFS.
- **Use case:** Finds minimal hop counts in unweighted graphs and tracks path parents.

### DFS (Depth-First Search) - Iterative
- **Description:** Visits all reachable nodes from a start node using a stack, exploring as deep as possible before backtracking.
- **Use case:** Useful for traversal, cycle detection, and pathfinding when recursion is not preferred.

### DFSTopologicalSort
- **Description:** Performs a DFS-based topological sort on a directed acyclic graph (DAG).
- **How it works:** Marks finishing times for nodes in decreasing order to generate a valid linear ordering.
- **Use case:** Ordering tasks with dependencies, scheduling problems.

### DFSSCC (Strongly Connected Components) - Kosaraju's Algorithm
- **Description:** Finds strongly connected components in directed graphs using two passes of DFS.
- **How it works:** 
  1. DFS on reversed graph to compute finishing times.
  2. DFS on original graph in decreasing order of finishing times to discover SCCs.
- **Use case:** Identifying clusters of nodes mutually reachable in directed graphs.

### Dijkstra Standard
- **Description:** Classic Dijkstra's algorithm using linear search to find the node with the minimum distance.
- **How it works:** Iteratively selects the unvisited node with the smallest known distance, then relaxes its neighbors.
- **Time Complexity:** O(V²)
- **Use case:** Suitable for dense graphs or educational purposes where simplicity is preferred.

### Dijkstra Heap
- **Description:** Optimized Dijkstra's algorithm using a priority queue (min-heap) for faster node selection.
- **How it works:** Uses a heap to efficiently select the node with the smallest distance; supports fast updates during relaxation.
- **Time Complexity:** O((V + E) log V)
- **Use case:** Preferred for sparse graphs or large datasets where performance matters.

## 🚀 How to Run

Use the `MainSearch.java` file. Change the `SEARCH_ALGORITHM` constant to the algorithm you want to test, e.g.:

```java
private static final String SEARCH_ALGORITHM = "DFS";
