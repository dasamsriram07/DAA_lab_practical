# Design and Analysis of Algorithms (DAA) Laboratory

[![Language: Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.oracle.com/java/)
[![Curriculum: DAA](https://img.shields.io/badge/Course-Design%20%26%20Analysis%20of%20Algorithms-blue.svg)](#index-of-practicals)
[![Status: Complete](https://img.shields.io/badge/Status-Verified%20%26%20Documented-brightgreen.svg)](#)

This repository contains clean, modular, and well-documented Java implementations for the **Design and Analysis of Algorithms (DAA) Laboratory** curriculum. Each practical directory includes functional Java source code along with a comprehensive `README.md` detailing theoretical concepts, algorithmic paradigms, recurrence relations, complexity analysis, and sample inputs/outputs.

---

## Index of Practicals

| Practical | Topic | Primary Paradigm | Source Files | Time Complexity (Avg / Worst) | Auxiliary Space | Documentation |
|:---:|---|:---:|---|:---:|:---:|:---:|
| **01** | [Sorting Algorithms](./Practical1/) | Divide & Conquer / Comparison | `bubbleSort.java`<br>`selectionSort.java`<br>`insertion_sort.java`<br>`mergeSort.java`<br>`quickSort.java` | $O(n^2)$ / $O(n \log n)$ | $O(1)$ to $O(n)$ | [Practical 1 Guide](./Practical1/README.md) |
| **02** | [Linear & Binary Search](./Practical2/) | Divide & Conquer / Sequential | `linearSearch.java`<br>`binarySearch.java` | $O(n)$ / $O(\log n)$ | $O(1)$ | [Practical 2 Guide](./Practical2/README.md) |
| **03** | [Max-Heap Sort](./Practical3/) | Tree / Heap Transformation | `heapSort.java` | $O(n \log n)$ | $O(1)$ | [Practical 3 Guide](./Practical3/README.md) |
| **04** | [Factorial: Iterative vs. Recursive](./Practical4/) | Iteration vs. Recursion | `factIterat.java`<br>`factRecur.java` | $O(n)$ | $O(1)$ / $O(n)$ | [Practical 4 Guide](./Practical4/README.md) |
| **05** | [0/1 Knapsack Problem](./Practical5/) | Dynamic Programming (Tabulation) | `tab_0_1_knapsack.java` | $O(n \cdot W)$ | $O(n \cdot W)$ | [Practical 5 Guide](./Practical5/README.md) |
| **06** | [Matrix Chain Multiplication (MCM)](./Practical6/) | Dynamic Programming (Interval DP) | `MatrixChainMultiplication.java` | $O(n^3)$ | $O(n^2)$ | [Practical 6 Guide](./Practical6/README.md) |
| **07** | [Coin Change (Minimum Coins)](./Practical7/) | Dynamic Programming (Unbounded) | `coinChange.java` | $O(n \cdot W)$ | $O(n \cdot W)$ | [Practical 7 Guide](./Practical7/README.md) |
| **08** | [Graph Traversals: BFS & DFS](./Practical8/) | Graph Theory / Queue & Stack | `BFS.java`<br>`DFS.java`<br>`Graph.java` | $O(V^2)$ *(Adjacency Matrix)* | $O(V)$ | [Practical 8 Guide](./Practical8/README.md) |
| **09** | [Prim's Algorithm for MST](./Practical9/) | Greedy Method (Vertex-growing) | `Prim.java` | $O(V^2)$ *(Matrix)* | $O(V)$ | [Practical 9 Guide](./Practical9/README.md) |
| **10** | [Kruskal's Algorithm for MST](./Practical10/) | Greedy Method + DSU (Edge-growing) | `Krushkal.java` | $O(V^2 + E^2)$ | $O(V + E)$ | [Practical 10 Guide](./Practical10/README.md) |
| **11** | [Floyd–Warshall Algorithm](./Practical11/) | Dynamic Programming (All-Pairs SP) | `FloydWarshall.java` | $O(V^3)$ | $O(V^2)$ | [Practical 11 Guide](./Practical11/README.md) |
| **12** | [Travelling Salesperson Problem (TSP)](./Practical12/) | Backtracking / Permutation Search | `TSP.java` | $O((n - 1)!)$ | $O(n)$ | [Practical 12 Guide](./Practical12/README.md) |

---

## Directory Structure

```text
DAA_LAB/
│
├── README.md                      # Master repository documentation (this file)
├── .gitignore                     # Git ignore rules (*.class, *.pdf)
│
├── Practical1/                    # Sorting Algorithms
│   ├── bubbleSort.java
│   ├── selectionSort.java
│   ├── insertion_sort.java
│   ├── mergeSort.java
│   ├── quickSort.java
│   └── README.md
│
├── Practical2/                    # Searching Algorithms
│   ├── linearSearch.java
│   ├── binarySearch.java
│   └── README.md
│
├── Practical3/                    # Heap Sort
│   ├── heapSort.java
│   └── README.md
│
├── Practical4/                    # Factorial Analysis
│   ├── factIterat.java
│   ├── factRecur.java
│   └── README.md
│
├── Practical5/                    # 0/1 Knapsack
│   ├── tab_0_1_knapsack.java
│   └── README.md
│
├── Practical6/                    # Matrix Chain Multiplication
│   ├── MatrixChainMultiplication.java
│   └── README.md
│
├── Practical7/                    # Coin Change Problem
│   ├── coinChange.java
│   └── README.md
│
├── Practical8/                    # Graph Traversals (BFS & DFS)
│   ├── BFS.java
│   ├── DFS.java
│   ├── Graph.java
│   └── README.md
│
├── Practical9/                    # Prim's MST Algorithm
│   ├── Prim.java
│   └── README.md
│
├── Practical10/                   # Kruskal's MST Algorithm
│   ├── Krushkal.java
│   └── README.md
│
├── Practical11/                   # Floyd–Warshall All-Pairs Shortest Path
│   ├── FloydWarshall.java
│   └── README.md
│
└── Practical12/                   # Travelling Salesperson Problem (TSP)
    ├── TSP.java
    └── README.md
```

---

## Algorithmic Paradigms Overview

### 1. Divide and Conquer
Breaks a problem into independent subproblems of identical type, recursively solves them, and merges results.
- **Merge Sort**: $T(n) = 2T(n/2) + O(n) \implies O(n \log n)$
- **Quick Sort**: $T(n) = T(k) + T(n - k - 1) + O(n) \implies O(n \log n)$ average
- **Binary Search**: $T(n) = T(n/2) + O(1) \implies O(\log n)$

### 2. Dynamic Programming
Solves problems displaying **Optimal Substructure** and **Overlapping Subproblems** by computing each subproblem once and tabulating results:
- **0/1 Knapsack**: Chooses whether to include or exclude item $i$ for capacity $w$.
- **Matrix Chain Multiplication**: Evaluates optimal split points $k$ over matrix subchains $A_{i..j}$.
- **Coin Change**: Builds minimum coin combinations for amounts $0 \dots W$ with reuse allowed.
- **Floyd–Warshall**: Progressively checks if intermediate vertex $k$ yields a shorter path between $(i, j)$.

### 3. Greedy Strategy
Builds a solution piece by piece, always choosing the immediate locally optimal step:
- **Prim's Algorithm**: Greedily absorbs the minimum-weight cross-edge connecting the existing MST to an outside vertex.
- **Kruskal's Algorithm**: Greedily incorporates the lowest-weight edge across the entire graph, using Disjoint Set Union (DSU) to avoid cycles.

### 4. Graph Traversals
Systematic visitation of graph vertices:
- **BFS (Queue)**: Explores concentric levels; finds shortest paths in unweighted graphs.
- **DFS (Stack / Recursion)**: Dives deeply along paths; identifies cycles, topological orders, and components.

### 5. Backtracking
Systematically navigates candidate state-space trees, abandoning ("backtracking" from) partial paths that violate problem constraints:
- **TSP**: Recursively tests city visitation orders, pruning invalid or suboptimal cycles.

---

## Prerequisites and Setup

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher (JDK 17 or 21 LTS recommended).
- **Git**: Version 2.25 or higher.

To verify your Java installation:
```bash
java -version
javac -version
```

---

## Compilation and Execution Guide

All files use explicit package declarations (`package PracticalX;`). Always execute compilation and running commands from the **repository root directory** (`DAA_LAB`).

### Compile All Practicals at Once
```bash
# On Windows (PowerShell)
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { javac $_.FullName }

# On Linux / macOS / Bash
javac Practical*/*.java
```

### Running Specific Programs

```bash
# Practical 1: Sorting Algorithms
java Practical1.bubbleSort
java Practical1.selectionSort
java Practical1.insertion_sort
java Practical1.mergeSort
java Practical1.quickSort

# Practical 2: Searching Algorithms
java Practical2.linearSearch
java Practical2.binarySearch

# Practical 3: Max-Heap Sort
java Practical3.heapSort

# Practical 4: Factorial Methods
java Practical4.factIterat
java Practical4.factRecur

# Practical 5: 0/1 Knapsack
java Practical5.tab_0_1_knapsack

# Practical 6: Matrix Chain Multiplication
java Practical6.MatrixChainMultiplication

# Practical 7: Coin Change
java Practical7.coinChange

# Practical 8: Graph Traversals
java Practical8.BFS
java Practical8.DFS
java Practical8.Graph

# Practical 9: Prim's MST
java Practical9.Prim

# Practical 10: Kruskal's MST
java Practical10.Kruskal

# Practical 11: Floyd-Warshall APSP
java Practical11.FloydWarshall

# Practical 12: Travelling Salesperson Problem
java Practical12.TSP
```

---

## Complexity Summary Reference Table

| Algorithm | Paradigm | Best Case | Average Case | Worst Case | Auxiliary Space |
|---|---|:---:|:---:|:---:|:---:|
| **Bubble Sort** | Comparison / Exchange | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| **Selection Sort** | Selection | $O(n^2)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| **Insertion Sort** | Incremental | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| **Merge Sort** | Divide & Conquer | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(n)$ |
| **Quick Sort** | Divide & Conquer | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ |
| **Linear Search** | Sequential | $O(1)$ | $O(n)$ | $O(n)$ | $O(1)$ |
| **Binary Search** | Divide & Conquer | $O(1)$ | $O(\log n)$ | $O(\log n)$ | $O(1)$ |
| **Heap Sort** | Tree / Heap | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(1)$ |
| **Factorial (Iterative)** | Iteration | $O(n)$ | $O(n)$ | $O(n)$ | $O(1)$ |
| **Factorial (Recursive)** | Recursion | $O(n)$ | $O(n)$ | $O(n)$ | $O(n)$ |
| **0/1 Knapsack** | Dynamic Programming | $O(n \cdot W)$ | $O(n \cdot W)$ | $O(n \cdot W)$ | $O(n \cdot W)$ |
| **Matrix Chain Mult.** | Dynamic Programming | $O(n^3)$ | $O(n^3)$ | $O(n^3)$ | $O(n^2)$ |
| **Coin Change** | Dynamic Programming | $O(n \cdot W)$ | $O(n \cdot W)$ | $O(n \cdot W)$ | $O(n \cdot W)$ |
| **BFS / DFS (Matrix)** | Graph Search | $O(V^2)$ | $O(V^2)$ | $O(V^2)$ | $O(V)$ |
| **Prim's Algorithm** | Greedy (Matrix) | $O(V^2)$ | $O(V^2)$ | $O(V^2)$ | $O(V)$ |
| **Kruskal's Algorithm** | Greedy (Edge sort + DSU) | $O(V^2 + E^2)$ | $O(V^2 + E^2)$ | $O(V^2 + E^2)$ | $O(V + E)$ |
| **Floyd–Warshall** | Dynamic Programming | $O(V^3)$ | $O(V^3)$ | $O(V^3)$ | $O(V^2)$ |
| **TSP (Backtracking)** | Exhaustive Search | $O(1)$ | $O((n-1)!)$ | $O((n-1)!)$ | $O(n)$ |

---

## Author & License

Developed and curated as part of the academic curriculum for the **Design and Analysis of Algorithms Laboratory**. Code and documentation are structured for educational and reference purposes.
