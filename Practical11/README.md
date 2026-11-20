# Practical 11 — Implementation of Floyd–Warshall Algorithm

## Overview

The **Floyd–Warshall Algorithm** is an all-pairs shortest-path (APSP) dynamic programming algorithm for directed or undirected weighted graphs. Unlike single-source shortest path algorithms (e.g., Dijkstra's or Bellman–Ford), Floyd–Warshall computes the minimum distance between **every pair of vertices** $(i, j)$ simultaneously.

It supports positive and negative edge weights, provided the graph does not contain any **negative-weight cycles**.

---

## Objectives

- Understand the All-Pairs Shortest Path problem and its formulation via Dynamic Programming.
- Implement the 3-loop Floyd–Warshall algorithm using an adjacency distance matrix in Java.
- Understand how intermediate vertices ($k$) iteratively refine path lengths.
- Analyze conditions for negative cycle detection.
- Formally evaluate time ($O(V^3)$) and space ($O(V^2)$) complexities.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `FloydWarshall.java` | `FloydWarshall` | Reads weighted adjacency matrix (using `-1` for no edge), computes all-pairs shortest paths in-place, and outputs formatted distance matrix. |

---

## Dynamic Programming Formulation

Let $D^{(k)}[i][j]$ denote the shortest path distance from vertex $i$ to vertex $j$ using only intermediate vertices from the subset $\{0, 1, \dots, k\}$.

### Base Case ($k = -1$ / Initial State)
$$
D^{(0)}[i][j] = \begin{cases}
0 & \text{if } i = j \\
w(i, j) & \text{if a direct edge } (i, j) \text{ exists} \\
\infty & \text{if no direct edge exists (input as } -1)
\end{cases}
$$

### Recurrence Relation
For each intermediate candidate vertex $k \in \{0, 1, \dots, n-1\}$:

$$
D^{(k)}[i][j] = \min \Big( D^{(k-1)}[i][j], \; D^{(k-1)}[i][k] + D^{(k-1)}[k][j] \Big)
$$

### In-Place Space Optimization
Because updating the $k$-th row and $k$-th column leaves their values unchanged during the $k$-th stage, the algorithm requires only a single 2D matrix $D[n][n]$ updated in-place:
```java
if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
}
```

### Negative-Cycle Detection
After running all $n$ iterations, if any diagonal element becomes negative ($D[i][i] < 0$), the graph contains a negative-weight cycle reachable from vertex $i$.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | $O(V^3)$ | Three nested loops iterate from $0$ to $V-1$: intermediate $k$, source $i$, destination $j$. |
| **Space Complexity** | $O(V^2)$ | A single $V \times V$ 2D distance matrix updated in-place. |
| **Edge Weights** | Positive & Negative | Valid as long as no negative cycle is reachable. |

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

**Initial Matrix ($-1$ denotes no direct path):**
```text
 0   4  11
-1   0   2
-1  -1   0
```

### Intermediates Evaluation:
1. **$k = 0$ (Route through 0)**:
   - No path improvements.
2. **$k = 1$ (Route through 1)**:
   - Check path $0 \to 2$ through vertex $1$:
     $$\text{dist}(0, 2) = \min(\text{old } 11, \; \text{dist}(0, 1) + \text{dist}(1, 2)) = \min(11, 4 + 2) = \mathbf{6}$$
   - Matrix entry `graph[0][2]` is updated from $11 \rightarrow 6$.
3. **$k = 2$ (Route through 2)**:
   - No further paths improved.

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
- Mastered the intermediate-vertex relaxation technique ($i \to k \to j$).
- Understood space optimization allowing an in-place 2D matrix representation without losing accuracy.
