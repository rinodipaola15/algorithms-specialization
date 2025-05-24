# 🧮 Sorting Algorithms

This folder contains implementations of sorting algorithms.

## 📌 Implemented Algorithms

### Merge Sort
- **Time Complexity:** O(n log n)  
- **Description:** A divide-and-conquer algorithm that recursively splits the array into halves, sorts them, and merges the result.  
- **How it works:** The array is divided until each subarray has one element. Then, sorted subarrays are merged step by step.  
- **Why use it:** Outperforms Selection Sort, Insertion Sort, and Bubble Sort (all O(n²)) on large datasets.  


## 🚀 How to Run

Use `MainSorting.java` and set `SORTING_ALGORITHM` to the class name you want to test:

```java
private static final String SORTING_ALGORITHM = "MergeSort";
