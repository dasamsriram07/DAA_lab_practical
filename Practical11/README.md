# Practical 11 — Implementation of Floyd–Warshall Algorithm

## Overview

The **Floyd–Warshall Algorithm** is an all-pairs shortest-path dynamic programming algorithm for directed or undirected weighted graphs. Unlike single-source shortest path algorithms (such as Dijkstra's or Bellman–Ford), Floyd–Warshall computes the minimum distance between **every pair of vertices** `(i, j)` simultaneously.

It supports positive and negative edge weights, provided the graph does not contain any **negative-weight cycles**.

---

## Objectives

- Understand the All-Pairs Shortest Path problem and its formulation via Dynamic Programming.
- Implement the Floyd–Warshall algorithm using a distance matrix in Java.
- Understand how intermediate vertices (`k`) progressively refine shortest path lengths.
- Analyze conditions for negative cycle detection.
- Formally evaluate time (`O(V^3)`) and space (`O(V^2)`) complexities.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `FloydWarshall.java` | `FloydWarshall` | Reads a weighted adjacency matrix (using `-1` for no edge), computes all-pairs shortest paths in-place, and outputs the resulting distance matrix. |

---

## Dynamic Programming Formulation

Let `dist[i][j]` represent the shortest path distance from vertex `i` to vertex `j`.

### Base Case (Direct Edges)
```text
dist[i][j] = 0           if i == j (distance to self is 0)
dist[i][j] = weight      if a direct edge from i to j exists
dist[i][j] = Infinity    if no direct edge exists (entered as -1)
```

### Recurrence Relation
For each intermediate vertex `k` (from `0` to `n - 1`), check if traveling through vertex `k` provides a shorter path between vertex `i` and vertex `j`:

```text
dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
```

Where:
- `dist[i][j]`: Currently known shortest distance from `i` to `j`.
- `dist[i][k] + dist[k][j]`: Distance of routing from `i` to `k`, and then from `k` to `j`.

### In-Place Space Optimization
The algorithm updates a single `n x n` distance matrix in-place across three loops:
```java
for (int k = 0; k < n; k++) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
            }
        }
    }
}
```

### Negative-Cycle Detection
After running all `n` iterations, if any diagonal entry becomes negative (`dist[i][i] < 0`), the graph contains a negative-weight cycle.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | `O(V^3)` | Three nested loops iterate from `0` to `V - 1`: intermediate vertex `k`, source `i`, and destination `j`. |
| **Space Complexity** | `O(V^2)` | A single `V x V` 2D distance matrix updated in-place. |
| **Edge Weights** | Positive & Negative | Valid as long as no negative-weight cycle is reachable. |

---

## Example Walkthrough

Consider a 3-vertex directed graph:
```text
(0) --- 4 ---> (1)
 |              |
 11             2
 |              |
 v              v
 +------------>(2)
```

**Initial Matrix (`-1` represents no direct path):**
```text
 0   4  11
-1   0   2
-1  -1   0
```

### Iteration Trace:
1. **Routing through vertex 0 (k = 0)**:
   - No path improvements.
2. **Routing through vertex 1 (k = 1)**:
   - Path `0 -> 2` via vertex `1`:
     `dist(0, 2) = min(11, dist(0, 1) + dist(1, 2)) = min(11, 4 + 2) = 6`.
   - Distance from `0` to `2` is updated from `11` to `6`.
3. **Routing through vertex 2 (k = 2)**:
   - No further path improvements.

**Final Shortest Distance Matrix:**
```text
0   4   6
INF 0   2
INF INF 0
```

---

## Sample Execution

**Sample Input:**
```text
Enter number of vertices: 3
Enter adjacency matrix (-1 for no edge):
0 4 11
-1 0 2
-1 -1 0
```

**Output:**
```text
Shortest Distance Matrix:
0 4 6 
INF 0 2 
INF INF 0 
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical11/FloydWarshall.java

# Run
java Practical11.FloydWarshall
```

---

## Learning Outcomes

- Formulated the All-Pairs Shortest Path problem using dynamic programming state transitions.
- Mastered the intermediate-vertex relaxation technique (`i -> k -> j`).
- Understood space optimization allowing an in-place 2D matrix representation without losing accuracy.
