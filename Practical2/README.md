# Practical 2 — Implementation and Time Analysis of Linear and Binary Search

## Overview

Searching is the computational process of locating a specific target key within a dataset. Searching is foundational to database query execution, symbol tables, caching systems, and computational geometry.

This practical explores and contrasts two core searching paradigms:
1. **Linear Search (Sequential Search)**: Brute-force exhaustive scan suitable for arbitrary (unsorted) collections.
2. **Binary Search (Divide-and-Conquer Search)**: Logarithmic search algorithm operating on monotonically ordered (sorted) collections.

---

## Objectives

- Understand sequential vs. interval-halving search strategies.
- Implement Linear Search and Binary Search in Java.
- Understand the precondition of Binary Search (mandatory sorted order).
- Formally evaluate best, average, and worst-case asymptotic time and space complexities.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `linearSearch.java` | `linearSearch` | Scans array sequentially index-by-index until target is matched or end of array is reached. |
| `binarySearch.java` | `binarySearch` | Repeatedly computes midpoint of current range to eliminate half the candidate elements. |

---

## Algorithms Implemented

### 1. Linear Search
- **Mechanism**: Inspects elements sequentially starting at index `0` up to `n - 1`. If `arr[i] == target`, returns `i`. If loop terminates without a match, returns `-1`.
- **Precondition**: None. Operates on unsorted, sorted, or arbitrarily ordered collections.
- **Worst-Case Operations**: Requires $n$ comparisons when the element is at the end or absent.

### 2. Binary Search
- **Mechanism**: Maintains pointers `s` (start) and `e` (end). In each iteration, computes `mid = (s + e) / 2`.
  - If `arr[mid] == key`: Returns index `mid`.
  - If `arr[mid] < key`: Discards left half by setting `s = mid + 1`.
  - If `arr[mid] > key`: Discards right half by setting `e = mid - 1`.
- **Precondition**: The array **must** be sorted in non-decreasing order prior to execution.
- **Recurrence**: $T(n) = T(n/2) + O(1) \implies O(\log n)$.

---

## Complexity Analysis

| Algorithm | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Input Requirement |
|---|:---:|:---:|:---:|:---:|---|
| **Linear Search** | $O(1)$ *(first element)* | $O(n)$ | $O(n)$ *(last or absent)* | $O(1)$ | Any arbitrary array |
| **Binary Search** | $O(1)$ *(middle element)* | $O(\log n)$ | $O(\log n)$ | $O(1)$ *(iterative)* | **Must be sorted** |

---

## Example Input & Output

### Binary Search Example
**Sample Input:**
```text
enter the size of array:
7
enter the elements (which are sorted) of array:
10 20 30 40 50 60 70
enter key value:
40
```
**Output:**
```text
3
```

### Linear Search Example
**Sample Input:**
```text
enter the size of array:
5
enter the elements of array:
42 17 89 5 23
enter key value:
89
```
**Output:**
```text
element is found at 2
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile searching programs
javac Practical2/*.java

# Run Linear Search
java Practical2.linearSearch

# Run Binary Search
java Practical2.binarySearch
```

---

## Learning Outcomes

- Learned when sequential scanning ($O(n)$) is necessary vs. when sorting overhead ($O(n \log n)$) pays off for multiple logarithmic queries ($O(\log n)$).
- Experienced proper boundary condition and index manipulation in binary search loops.
- Avoided common pitfalls such as off-by-one array bounds errors and integer overflow in midpoint calculations.
