# 🗃️ Hash Table Data Structures

This folder contains Java examples and explanations using **Hash Tables**, which support efficient storage, lookup, and removal of key-value pairs. Hash Tables are a fundamental data structure for problems requiring **fast access, updates, or membership tests**, such as the classic Two-Sum problem (using keys only).

## 📌 Concept Overview

- A **Hash Table** stores **key-value pairs** using a **hash function** to map keys to indices in an underlying array.  
- Provides **average-case O(1) complexity** for:
  - `put(key, value)`: insert or update a key-value pair
  - `remove(key)`: delete a key (and its value)
  - `get(key)`: retrieve the value associated with a key  
- Collision handling is done using methods like **chaining** (linked lists) or **open addressing**.  
- Does not maintain any order among the keys.  
- Ideal for scenarios where **quick access, updates, or membership testing** is required.  

### Advantages

- Very fast lookup, insertion, and deletion on average.
- Flexible: can store arbitrary key-value associations.
- Simple API in most programming languages (e.g., `HashMap` in Java, `dict` in Python).  

### Disadvantages

- Requires more memory than a simple array due to underlying hash table and collision handling.  
- Performance can degrade if the **hash function is poor** or the table becomes too full.  
- Not suitable when **order of elements** matters.  

### Bloom Filter

- A **Bloom Filter** is a **probabilistic data structure** for set membership tests.  
- Supports extremely fast **insertions and queries** with **very low memory usage**, but:
  - May return **false positives** (key appears present even if it isn’t)
  - Never returns **false negatives** (key present will always be detected)  
- Useful when memory efficiency is critical and **occasional false positives are acceptable**.  

## 📌 Example Usage

- `TwoSumAlgorithm.java` demonstrates a typical use-case where a **Hash Table** is used to store keys:
  - Checks for the complementary number in O(1) average time.  
  - Shows how Hash Tables are ideal for problems requiring **fast lookups or membership checks**.  

## 🚀 Complexity Summary

| Operation       | Average Case | Worst Case |
|-----------------|-------------|------------|
| `put`           | O(1)        | O(n)       |
| `remove`        | O(1)        | O(n)       |
| `get`           | O(1)        | O(n)       |

> Worst-case occurs in rare situations with **many hash collisions**.