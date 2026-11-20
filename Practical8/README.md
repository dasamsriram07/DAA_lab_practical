# Practical 8 — Graph Representation and Traversal Using DFS and BFS

## Overview

A **Graph** `G = (V, E)` is a non-linear data structure comprising a set of vertices `V` and a set of edges `E` that connect pairs of vertices. Graphs model complex real-world networks such as social networks, transport routing, network topologies, dependency graphs, and state machines.

Graph traversal is the systematic process of visiting each vertex in a graph exactly once. This practical implements and compares the two primary fundamental graph traversal algorithms:
1. **Breadth-First Search (BFS)**: Level-by-level traversal using a FIFO Queue.
2. **Depth-First Search (DFS)**: Deep-dive traversal using LIFO Stack / Recursion.

---

## Objectives

- Understand graph representations: **Adjacency Matrix** vs. **Adjacency List**.
- Implement BFS and DFS traversal algorithms in Java.
- Compare queue-based exploration against recursive stack-based exploration.
- Analyze time and space complexity with respect to vertices (`V`) and edges (`E`).

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `BFS.java` | `BFS` | Standalone implementation of Breadth-First Search using Java Collections `Queue` (`LinkedList`). |
| `DFS.java` | `DFS` | Standalone recursive Depth-First Search implementation using a visited array. |
| `Graph.java` | `Graph` | Unified Object-Oriented `Graph` class supporting both DFS and an array-based BFS queue. |

---

## Graph Representation: Adjacency Matrix

All three implementations represent the graph using an `n x n` **Adjacency Matrix** `graph[n][n]`:
- `graph[i][j] = 1` indicates an edge exists from vertex `i` to vertex `j`.
- `graph[i][j] = 0` indicates no direct edge exists.

For an undirected graph, the adjacency matrix is symmetric (`graph[i][j] == graph[j][i]`).

---

## Traversal Algorithms Comparison

### 1. Breadth-First Search (BFS)
- **Data Structure**: First-In-First-Out (FIFO) **Queue**.
- **Strategy**: Explores all immediate neighbors of the current vertex before moving deeper. Produces the shortest path in unweighted graphs.
- **Algorithm**:
  1. Enqueue source vertex `s` and mark it visited: `visited[s] = true`.
  2. While queue is not empty:
     - Dequeue vertex `v` and print it.
     - For every unvisited adjacent vertex `u` of `v`, mark `visited[u] = true` and enqueue `u`.

### 2. Depth-First Search (DFS)
- **Data Structure**: Last-In-First-Out (LIFO) **Stack** (or recursive call stack).
- **Strategy**: Follows a path as deep as possible until a dead end is reached, then backtracks.
- **Algorithm**:
  1. Mark current vertex `v` visited: `visited[v] = true` and print `v`.
  2. For every unvisited adjacent vertex `u` of `v`, recursively call `DFS(u)`.

---

## Complexity Analysis

| Graph Representation | Algorithm | Time Complexity | Auxiliary Space | Key Use Cases |
|---|---|:---:|:---:|---|
| **Adjacency Matrix** (implemented here) | **BFS** | `O(V^2)` | `O(V)` | Shortest path in unweighted graphs, level-order search. |
| **Adjacency Matrix** (implemented here) | **DFS** | `O(V^2)` | `O(V)` | Cycle detection, topological sort, connectivity, maze solving. |
| *Adjacency List (sparse graph optimization)* | *BFS / DFS* | `O(V + E)` | `O(V)` | General large sparse graphs. |

*Note: In an adjacency matrix of size `V x V`, finding all neighbors of a vertex requires scanning its entire row of length `V`. Doing this for all `V` vertices takes `V * O(V) = O(V^2)` total time.*

---

## Example Walkthrough

Consider a 4-vertex undirected graph:
```text
  0 --- 1
  |     |
  3 --- 2
```

**Adjacency Matrix (4 x 4):**
```text
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
```

- **Starting Vertex:** `0`
- **BFS Traversal:** `0 -> 1 -> 3 -> 2` (visits immediate neighbors 1 and 3 first, then 2).
- **DFS Traversal:** `0 -> 1 -> 2 -> 3` (dives deeply from 0 to 1, 1 to 2, 2 to 3).

---

## Sample Execution

### Using `Graph.java`

**Input:**
```text
Enter number of vertices: 4
Enter adjacency matrix:
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
Enter starting vertex: 0
```

**Output:**
```text
DFS: 0 1 2 3 
BFS: 0 1 3 2 
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile all graph programs
javac Practical8/*.java

# Run Standalone BFS
java Practical8.BFS

# Run Standalone DFS
java Practical8.DFS

# Run Unified Graph Class
java Practical8.Graph
```

---

## Learning Outcomes

- Gained practical proficiency in implementing graph traversals in Java.
- Understood the duality between queues (BFS) and stacks/recursion (DFS).
- Analyzed the impact of Adjacency Matrix lookup cost (`O(V^2)`) on traversal performance.
