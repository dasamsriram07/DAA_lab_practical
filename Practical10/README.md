# Practical 10 — Implementation of Kruskal's Algorithm for Minimum Spanning Tree

## Overview

**Kruskal's Algorithm** is an edge-based greedy algorithm that finds a Minimum Spanning Tree (MST) in a connected, weighted, undirected graph. While Prim's algorithm expands a single connected tree from a starting vertex, Kruskal's algorithm operates on the entire graph simultaneously by maintaining a **forest** of trees that merge until a single spanning tree remains.

To prevent cycle formation, Kruskal's algorithm employs the **Disjoint Set Union (DSU)** data structure (also known as Union-Find).

---

## Objectives

- Understand the edge-centric greedy strategy of Kruskal's algorithm.
- Implement the Disjoint Set Union (DSU) data structure for cycle detection.
- Extract, sort, and process weighted edges.
- Contrast the execution mechanisms of Prim's and Kruskal's algorithms.
- Analyze the time and space complexity of sorting and union-find operations.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `Krushkal.java` | `Krushkal` (alias `Kruskal`) | Extracts undirected graph edges, sorts edges by weight, applies DSU for cycle prevention, and prints MST edges and total cost. |

---

## Algorithm Mechanics

1. **Edge Extraction**:
   - Reads the upper triangle of the adjacency matrix (`j > i` where `a[i][j] != 0`) to avoid duplicate undirected edges.
   - Stores each edge as `[u, v, weight]` in an edge list.

2. **Edge Sorting**:
   - Sorts all extracted edges in non-decreasing order of weight.

3. **Disjoint Set Initialization**:
   - Each vertex starts as its own representative root:
     ```text
     For each vertex i: parent[i] = i
     ```

4. **Greedy Edge Selection & Cycle Prevention**:
   - Iterate through the sorted edges. For each edge `(u, v)` with weight `w`:
     - Find the root representative of `u`: `while (parent[x] != x) x = parent[x]`.
     - Find the root representative of `v`: `while (parent[y] != y) y = parent[y]`.
     - **If x != y**: Vertices belong to different connected components. Adding edge `(u, v)` **does not create a cycle**.
       - Merge components: `parent[x] = y`.
       - Add edge to MST and accumulate cost.
       - Increment selected edge counter (`count++`).
     - **If x == y**: Vertices already share a common component. Adding this edge would form a cycle; **discard it**.
   - Stop as soon as `n - 1` edges are successfully included.

---

## Complexity Analysis

| Phase | Time Complexity (Implementation) | Time Complexity (Optimal) | Space Complexity |
|---|:---:|:---:|:---:|
| **Edge Extraction** | `O(V^2)` | `O(E)` | `O(E)` |
| **Edge Sorting** | `O(E^2)` (Bubble Sort) | `O(E log E)` (Merge/Quick Sort) | `O(1)` |
| **Cycle Detection (DSU)** | `O(E * V)` (Naive find) | `O(E * alpha(V))` (Path compression) | `O(V)` |
| **Overall** | `O(V^2 + E^2)` | `O(E log E)` = `O(E log V)` | `O(V + E)` |

*Note: In sparse graphs where `E` is much smaller than `V^2`, Kruskal's algorithm with `O(E log E)` sorting is very efficient.*

---

## Example Walkthrough

Consider a 4-vertex weighted graph:

```text
       10
   (0)-----(1)
    | \     |
   6|  \5   |15
    |   \   |
   (2)-----(3)
        4
```

**Adjacency Matrix:**
```text
0 10 6 5
10 0 0 15
6 0 0 4
5 15 4 0
```

### Extracted & Sorted Edges:
1. `(2 - 3)` with weight **4**
2. `(0 - 3)` with weight **5**
3. `(0 - 2)` with weight **6**
4. `(0 - 1)` with weight **10**
5. `(1 - 3)` with weight **15**

### Processing Steps:
- **Edge 1: (2 - 3, wt 4)**: `find(2) != find(3)`. -> **Include**. Set `parent[2] = 3`. Total cost = 4.
- **Edge 2: (0 - 3, wt 5)**: `find(0) != find(3)`. -> **Include**. Set `parent[0] = 3`. Total cost = 4 + 5 = 9.
- **Edge 3: (0 - 2, wt 6)**: `find(0) == find(2)` (both have root 3). -> **Cycle detected! Discard**.
- **Edge 4: (0 - 1, wt 10)**: `find(0) != find(1)`. -> **Include**. Set `parent[3] = 1`. Total cost = 9 + 10 = 19.
- `V - 1 = 3` edges reached. Complete.

**Minimum Cost:** **19** (Matches Prim's MST result).

---

## Sample Execution

**Sample Input:**
```text
Enter number of vertices: 4
Enter weighted adjacency matrix (0 for no edge):
0 10 6 5
10 0 0 15
6 0 0 4
5 15 4 0
```

**Output:**
```text
2 - 3 : 4
0 - 3 : 5
0 - 1 : 10
Minimum Cost: 19
```
