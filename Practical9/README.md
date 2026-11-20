# Practical 9 — Implementation of Prim's Algorithm for Minimum Spanning Tree

## Overview

A **Spanning Tree** of a connected, undirected graph `G = (V, E)` is an acyclic subgraph that connects all `V` vertices using exactly `V - 1` edges. When edges carry numerical weights/costs, a **Minimum Spanning Tree (MST)** is a spanning tree whose sum of edge weights is minimized.

**Prim's Algorithm** is a classic greedy algorithm that constructs an MST by growing a single connected tree from an arbitrary starting vertex, one edge at a time.

---

## Objectives

- Understand the theoretical definition and properties of a Minimum Spanning Tree.
- Implement Prim's algorithm using an Adjacency Matrix representation in Java.
- Apply a greedy selection criterion to maintain the cut property.
- Handle disconnected graphs and compute the total MST weight.
- Analyze the asymptotic complexity of matrix-based vs. priority-queue implementations.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `Prim.java` | `Prim` | Implements Prim's MST algorithm on a weighted adjacency matrix, prints each selected edge, and outputs total minimum cost. |

---

## Algorithm Mechanics (Greedy Cut Property)

1. **Initialization**:
   - Maintain a boolean array `visited[n]` tracking vertices already absorbed into the MST.
   - Start with vertex `0`: mark `visited[0] = true`.
   - Maintain counters: `edges = 0`, `cost = 0`.

2. **Greedy Iteration**:
   - While `edges < n - 1`:
     - Search for the minimum-weight edge `(u, v)` such that `u` is visited (`visited[u] == true`) and `v` is unvisited (`!visited[v] == true`), with `a[u][v] != 0`.
     - If no valid edge is found, the graph is **disconnected**; terminate.
     - Add `(u, v)` to the tree:
       - Mark `visited[v] = true`.
       - Print edge `u - v : weight`.
       - Increment `cost += weight` and `edges++`.

---

## Complexity Analysis

| Representation | Time Complexity | Space Complexity | Best Suited For |
|---|:---:|:---:|---|
| **Adjacency Matrix** (implemented here) | `O(V^2)` | `O(V)` | Dense graphs (where E is close to V^2) |
| **Adjacency List + Min-Heap / Priority Queue** | `O(E log V)` | `O(V + E)` | Sparse graphs (where E << V^2) |

*Explanation for Adjacency Matrix*:
The outer loop runs `V - 1` times. Inside, two nested loops check all pairs `(i, j)` where `i` is visited and `j` is unvisited across the `V x V` matrix, yielding `(V - 1) * O(V^2)` in a naive scan or `O(V^2)` using a key distance array.

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

**Weighted Adjacency Matrix:**
```text
0  10  6   5
10  0  0  15
6   0  0   4
5  15  4   0
```

### Trace:
1. Start at vertex `0`: `visited = {0}`
2. Eligible edges from `{0}`:
   - `(0, 1)` with weight 10
   - `(0, 2)` with weight 6
   - `(0, 3)` with weight 5 -> **Pick (0, 3) with weight 5**, add vertex 3. `visited = {0, 3}`.
3. Eligible edges from `{0, 3}`:
   - `(0, 1)` with weight 10
   - `(0, 2)` with weight 6
   - `(3, 1)` with weight 15
   - `(3, 2)` with weight 4 -> **Pick (3, 2) with weight 4**, add vertex 2. `visited = {0, 2, 3}`.
4. Eligible edges from `{0, 2, 3}`:
   - `(0, 1)` with weight 10 -> **Pick (0, 1) with weight 10**, add vertex 1. `visited = {0, 1, 2, 3}`.
5. All 4 vertices are included (`V - 1 = 3` edges selected).

**Total Minimum Cost:** `5 + 4 + 10 = 19`.

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
0 - 3 : 5
3 - 2 : 4
0 - 1 : 10
Minimum Cost: 19
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical9/Prim.java

# Run
java Practical9.Prim
```

---

## Learning Outcomes

- Gained deep understanding of the Greedy Choice Property and MST Cut Property.
- Implemented vertex-growing MST expansion from an initial seed vertex.
- Validated conditions for graph connectedness and cycle avoidance.
