# Practical 3 — Implementation of Max-Heap Sort

## Overview

Heap Sort is an efficient, comparison-based, in-place sorting algorithm that leverages a **Binary Heap** data structure. A binary heap is a complete binary tree where every node satisfies the heap property: in a **Max-Heap**, each parent node's key is greater than or equal to the keys of its children, placing the maximum element at the root.

Heap Sort executes in two distinct phases:
1. **Building a Max-Heap** from an arbitrary array in linear time (`O(n)`).
2. **Repeated Root Extraction** and in-place sorting by swapping the maximum element to the rear of the active heap range and restoring the heap property (`O(n log n)`).

---

## Objectives

- Understand the properties of a complete binary tree and its implicit 0-indexed array representation.
- Implement the bottom-up `heapify` procedure to restore heap invariants.
- Implement in-place Heap Sort.
- Analyze the asymptotic time complexity of heap building (`O(n)`) and full sort (`O(n log n)`).

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `heapSort.java` | `heapSort` | Implements `heapify`, bottom-up max-heap construction, and repeated root extraction. |

---

## Binary Heap Mechanics & Array Indexing

A binary heap is mapped directly to a linear array without requiring pointer-based tree nodes:

- **Root Node**: `arr[0]`
- **Parent of node at index i**: `(i - 1) / 2`
- **Left Child of node at index i**: `2 * i + 1`
- **Right Child of node at index i**: `2 * i + 2`
- **Last Non-Leaf Node**: `(n / 2) - 1` (or `n / 2`)

### Algorithm Steps

1. **Build Max-Heap**:
   - Start from the last internal node down to the root (`i = n/2` down to `0`).
   - Call `heapify(arr, i, n)` on each node.
   - **Time Complexity of Phase 1**: Building the heap takes `O(n)` time because nodes closer to the bottom have smaller subtrees to heapify.

2. **Sort by Extraction**:
   - For `i = n - 1` down to `1`:
     - Swap `arr[0]` (current maximum) with `arr[i]` (last element of unsorted portion).
     - Call `heapify(arr, 0, i)` on the new root within the reduced heap size `i`.
   - **Time Complexity of Phase 2**: `(n - 1)` extractions each taking `O(log n)` time, yielding `O(n log n)`.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Build Heap Time** | `O(n)` | Sum of heights across all heap nodes is bounded linearly. |
| **Best Case Time** | `O(n log n)` | Elements must still be sifted down through the heap levels. |
| **Average Case Time** | `O(n log n)` | Guaranteed logarithmic height per root extraction. |
| **Worst Case Time** | `O(n log n)` | Guaranteed upper bound regardless of initial input order. |
| **Auxiliary Space** | `O(1)` | Operates strictly in-place on the input array. |
| **Stability** | No | Swapping elements across long distances alters duplicate order. |

---

## Example Walkthrough

**Sample Input:**
```text
Enter the size of array
5
4 10 3 5 1
```

**Heapification and Sort Trace:**
1. Initial Array: `[4, 10, 3, 5, 1]`
2. After `buildMaxHeap`: `[10, 5, 3, 4, 1]` (Root is 10)
3. Step 1: Swap 10 with 1 -> `[1, 5, 3, 4 | 10]`, heapify root -> `[5, 4, 3, 1 | 10]`
4. Step 2: Swap 5 with 1 -> `[1, 4, 3 | 5, 10]`, heapify root -> `[4, 1, 3 | 5, 10]`
5. Step 3: Swap 4 with 3 -> `[3, 1 | 4, 5, 10]`, heapify root -> `[3, 1 | 4, 5, 10]`
6. Step 4: Swap 3 with 1 -> `[1, 3, 4, 5, 10]`

**Sorted Output:**
```text
1 3 4 5 10 
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical3/heapSort.java

# Run
java Practical3.heapSort
```

---

## Learning Outcomes

- Learned implicit tree representation in flat linear arrays without dynamic node pointers.
- Understood why `buildHeap` takes `O(n)` time despite calling a function with worst-case cost `O(log n)`.
- Gained hands-on experience with in-place `O(n log n)` sorting with zero additional array allocations.
