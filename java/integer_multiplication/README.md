# 🧮 Integer Multiplication Algorithms

This folder contains implementations of integer multiplication algorithms.

## 📌 Implemented Algorithms

### Karatsuba Multiplication
- **Time Complexity:** ~ O(n^1.585)
- **Description:** A divide-and-conquer algorithm that reduces the number of multiplications compared to the traditional approach.
- **How it works:** 
Given two integers X and Y, it splits them recursively into halves:
X = A * 10^m + B and Y = C * 10^m + D.
Then it computes:
AC = Karatsuba(A, C)
BD = Karatsuba(B, D)
AD + BC = Karatsuba(A+B, C+D) - AC - BD
Finally, combines them as:
Result = AC * 10^(2m) + (AD + BC) * 10^m + BD  
- **Why use it:** Faster than grade-school multiplication for large integers. Forms the basis of even faster algorithms like Toom-Cook and Schönhage-Strassen.


## 🚀 How to Run

Use `MainIntegerMultiplication.java` and set `INTEGER_MULTIPLICATION_ALGORITHM` to the class name you want to test:

```java
private static final String INTEGER_MULTIPLICATION_ALGORITHM = "KaratsubaMultiplication";
