# 🧮 Sorting Algorithms

This folder contains implementations of sorting algorithms.

## 📌 Implemented Algorithms

### Merge Sort
- **Time Complexity:** O(n log n)  
- **Description:** A divide-and-conquer algorithm that recursively splits the array into halves, sorts them, and merges the result.  
- **How it works:** The array is divided until each subarray has one element. Then, sorted subarrays are merged step by step.  
- **Why use it:** Outperforms Selection Sort, Insertion Sort, and Bubble Sort (all O(n²)) on large datasets.  

### QuickSort
- **Time Complexity:** O(n log n) on average, O(n²) in the worst case  
- **Description:** A divide-and-conquer algorithm that partitions the array around a pivot, then recursively sorts the left and right subarrays.  
- **How it works:** The pivot (first element in this implementation) is placed in its correct sorted position. All elements less than the pivot are moved to the left, and all greater elements to the right.  
- **Why use it:** One of the fastest sorting algorithms in practice due to good cache performance and low overhead.


## 🚀 How to Run

Use `MainSorting.java` and set `SORTING_ALGORITHM` to the class name you want to test:

```java
private static final String SORTING_ALGORITHM = "MergeSort";
