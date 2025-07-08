# 🔍 Selection Algorithms

This folder contains an implementation of selection algorithms used to find the i-th smallest element in an unsorted array without sorting the entire array.

## 📌 Implemented Algorithms

### Randomized Selection (RSelect)
- **Time Complexity:** Expected O(n), Worst-case O(n²)
- **Description:** A divide-and-conquer algorithm that recursively selects a pivot element at random and partitions the array around it. Only the relevant subarray is processed recursively.
- **How it works:** 
  - Randomly selects a pivot
  - Partitions the array into elements less than and greater than the pivot
  - If the pivot is in the desired i-th position, return it
  - Otherwise, recurse into the appropriate half
- **Why use it:** It avoids full sorting and solves the order statistic problem efficiently on average. Particularly useful when you only need a specific element like the median or minimum/maximum.

## 🧠 Example Use Case

Given an unsorted array: `[7, 3, 1, 9, 5]`,  
If we want to find the 3rd smallest element (i = 3),  
Randomized Selection returns `5` without sorting the entire array.

## 🚀 How to Run

Use the `MainSelection.java` file and customize the input:

```java
int[] array = {7, 3, 1, 9, 5};
int i = 3;
int result = RandomizedSelection.select(array, i);
System.out.println("The " + i + "rd order statistic is: " + result);
