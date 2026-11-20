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
- **Strategy**: Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The largest unsorted element "bubbles" to its final position at the end of each pass.
- **Characteristics**: Simple to understand, stable, in-place.

### 2. Selection Sort
- **Strategy**: Partitions the array into sorted (left) and unsorted (right) regions. In each pass, it scans the unsorted region to find the minimum element and swaps it with the first unsorted position.
- **Characteristics**: Performs minimal writes/swaps ($O(n)$ swaps), not stable by default, in-place.

### 3. Insertion Sort
- **Strategy**: Iterates through input elements, progressively inserting each element into its correct sorted location among previously examined elements by shifting larger elements one position to the right.
- **Characteristics**: Adaptive ($O(n)$ on nearly sorted arrays), stable, in-place, ideal for small input sizes ($n \le 16$).

### 4. Merge Sort
- **Strategy**: Follows the Divide-and-Conquer paradigm. Divides the array into two halves until single-element subarrays are reached, recursively sorts both halves, and merges the two sorted halves using an auxiliary buffer.
- **Recurrence**: $T(n) = 2T(n/2) + \Theta(n)$ $\implies$ $\Theta(n \log n)$ by Master Theorem.
- **Characteristics**: Guaranteed $O(n \log n)$ time, stable, requires $O(n)$ auxiliary space.

### 5. Quick Sort
- **Strategy**: Selects a pivot element (Lomuto partition scheme using the rightmost element), partitions the array such that all items $\le$ pivot are placed left and items $>$ pivot are placed right, then recursively sorts both partitions.
- **Recurrence**:
  - Best / Average: $T(n) = 2T(n/2) + \Theta(n) \implies O(n \log n)$
  - Worst Case (sorted/reverse sorted without randomization): $T(n) = T(n-1) + \Theta(n) \implies O(n^2)$
- **Characteristics**: In-place, cache-efficient, not stable, $O(\log n)$ average recursion stack space.

---

## Complexity Analysis

| Algorithm | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Stability | In-Place? |
|---|:---:|:---:|:---:|:---:|:---:|:---:|
| **Bubble Sort** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Yes | Yes |
| **Selection Sort** | $O(n^2)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | No | Yes |
| **Insertion Sort** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Yes | Yes |
| **Merge Sort** | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(n)$ | Yes | No |
| **Quick Sort** | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ (avg stack) | No | Yes |

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

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile all sorting implementations
javac Practical1/*.java

# Run Bubble Sort
java Practical1.bubbleSort

# Run Selection Sort
java Practical1.selectionSort

# Run Insertion Sort
java Practical1.insertion_sort

# Run Merge Sort
java Practical1.mergeSort

# Run Quick Sort
java Practical1.quickSort
```

---

## Learning Outcomes

- Mastered both elementary comparison-based sorting ($O(n^2)$) and divide-and-conquer ($O(n \log n)$) techniques.
- Analyzed the trade-off between auxiliary memory usage (Merge Sort's $O(n)$ buffer) and runtime guarantees.
- Identified practical scenarios where Insertion Sort outperforms advanced algorithms (e.g. nearly sorted lists or small subarrays).
