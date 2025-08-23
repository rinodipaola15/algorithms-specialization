# ⚖️ Sorting Algorithms with Comparison Count

This folder contains implementations of sorting algorithms that also count the number of comparisons made during execution.

## 📌 Implemented Algorithms

### Quick Sort with Comparison Counting  
- **Time Complexity:** O(n log n) on average, O(n²) in the worst case  
- **Description:** A divide-and-conquer sorting algorithm that recursively partitions the array around a pivot element and sorts the subarrays. The implementation also counts the number of element comparisons made during sorting.  
- **Pivot Strategies:**  
  - **First Element:** Always use the first element as the pivot.  
  - **Last Element:** Swap the last element with the first and use it as the pivot.  
  - **Median-of-Three:** Choose the pivot as the median among the first, middle, and last elements. This helps reduce the impact of worst-case inputs like sorted or reverse-sorted arrays.  
- **Why use it:** Useful for analyzing the performance of different pivot selection strategies, especially in competitive programming and algorithm analysis contexts.

## 🚀 How to Run

Simply run the `MainSortingAndComparisonCount.java` file.  
Make sure the array input file `QuickSort.txt` is present in the root directory.  

The program will run the QuickSort algorithm on the input array using all three pivot strategies:

1. First element as pivot  
2. Last element as pivot  
3. Median-of-three (first, middle, last element)

It will then print the number of comparisons for each strategy to the console.