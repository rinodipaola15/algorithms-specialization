# 🧮 Sorting Algorithms with Inversion Count

This folder contains implementations of sorting algorithms with inversion counting.

## 📌 Implemented Algorithms

### Merge Sort and Count Inversions
- **Time Complexity:** O(n log n)  
- **Description:** A divide-and-conquer algorithm that recursively splits the array into halves, sorts them, merges the results, and counts the number of inversions (i.e., pairs where the order is reversed).  
- **How it works:** The array is divided until each subarray has one element. During the merge step, the algorithm counts how many elements from the left half are greater than elements from the right half, accumulating the total number of inversions.  
- **Why use it:** Efficiently sorts the array and simultaneously counts inversions, which is useful in problems related to array disorder, ranking, or measuring sortedness.

## 🚀 How to Run

Use `MainSortingAndInversionCount.java` and set `SORTING_AND_INVERSION_COUNT_ALGORITHM` to the class name you want to test:

```java
private static final String SORTING_AND_INVERSION_COUNT_ALGORITHM = "MergeSortAndCount";

