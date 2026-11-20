# Practical 1 — Implementation and Time Analysis of Sorting Algorithms

## Overview

Sorting is a fundamental operation in computer science that arranges elements of a collection into a specific order (typically ascending or descending). Efficient sorting is critical for optimizing other algorithms such as binary search, database indexing, and data processing pipelines.

This practical covers the implementation, comparison, and complexity analysis of five classic sorting algorithms:
1. **Bubble Sort** (Comparison / Exchange)
2. **Selection Sort** (Selection)
3. **Insertion Sort** (Incremental Insertion)
4. **Merge Sort** (Divide and Conquer)
5. **Quick Sort** (Divide and Conquer / Partitioning)

---

## Objectives

- Understand the theoretical foundations and mechanics of elementary and divide-and-conquer sorting algorithms.
- Implement sorting algorithms in Java with structured input handling.
- Conduct asymptotic time and space complexity analyses for Best, Average, and Worst cases.
- Evaluate trade-offs between comparison count, swap operations, stability, and memory overhead.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `bubbleSort.java` | `bubbleSort` | Compares adjacent pairs and swaps them if out of order. |
| `selectionSort.java` | `selectionSort` | Repeatedly identifies the minimum element from the unsorted segment. |
| `insertion_sort.java` | `insertion_sort` | Builds the sorted sequence one item at a time by shifting larger items. |
| `mergeSort.java` | `mergeSort` | Recursively bisects the array, sorts subarrays, and merges them. |
| `quickSort.java` | `quickSort` | Partitions around a pivot element (last element) and recurses. |

---

## Algorithms Summary

### 1. Bubble Sort
- **Strategy**: Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The largest unsorted element moves to its final position at the end of each pass.
- **Characteristics**: Simple to understand, stable, in-place.

### 2. Selection Sort
- **Strategy**: Partitions the array into sorted (left) and unsorted (right) regions. In each pass, it scans the unsorted region to find the minimum element and swaps it with the first unsorted position.
- **Characteristics**: Performs minimal writes/swaps (`O(n)` swaps), not stable by default, in-place.

### 3. Insertion Sort
- **Strategy**: Iterates through input elements, progressively inserting each element into its correct sorted location among previously examined elements by shifting larger elements one position to the right.
- **Characteristics**: Adaptive (`O(n)` on nearly sorted arrays), stable, in-place, ideal for small input sizes.

### 4. Merge Sort
- **Strategy**: Follows the Divide-and-Conquer paradigm. Divides the array into two halves until single-element subarrays are reached, recursively sorts both halves, and merges the two sorted halves using an auxiliary buffer.
- **Recurrence**: `T(n) = 2T(n/2) + O(n)` -> `O(n log n)`
- **Characteristics**: Guaranteed `O(n log n)` time, stable, requires `O(n)` auxiliary space.

### 5. Quick Sort
- **Strategy**: Selects a pivot element (last element), partitions the array such that all items `<= pivot` are placed on the left and items `> pivot` on the right, then recursively sorts both partitions.
- **Recurrence**:
  - Best / Average: `T(n) = 2T(n/2) + O(n)` -> `O(n log n)`
  - Worst Case (already sorted array with rightmost pivot): `T(n) = T(n - 1) + O(n)` -> `O(n^2)`
- **Characteristics**: In-place, cache-efficient, not stable, `O(log n)` average recursion stack space.

---

## Complexity Analysis

| Algorithm | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Stability | In-Place? |
|---|:---:|:---:|:---:|:---:|:---:|:---:|
| **Bubble Sort** | `O(n)` | `O(n^2)` | `O(n^2)` | `O(1)` | Yes | Yes |
| **Selection Sort** | `O(n^2)` | `O(n^2)` | `O(n^2)` | `O(1)` | No | Yes |
| **Insertion Sort** | `O(n)` | `O(n^2)` | `O(n^2)` | `O(1)` | Yes | Yes |
| **Merge Sort** | `O(n log n)` | `O(n log n)` | `O(n log n)` | `O(n)` | Yes | No |
| **Quick Sort** | `O(n log n)` | `O(n log n)` | `O(n^2)` | `O(log n)` (avg stack) | No | Yes |

---

## Example Input & Output

**Sample Input:**
```text
Enter the size of array:
5
Enter the elements of array:
64 25 12 22 11
```

**Sorted Output:**
```text
11 12 22 25 64
```
