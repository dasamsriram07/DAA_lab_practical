# Practical 12 — Travelling Salesperson Problem (TSP) Using Backtracking

## Overview

The **Travelling Salesperson Problem (TSP)** is a classic NP-hard problem in combinatorial optimization and graph theory. Given a set of $n$ cities and the pairwise distances (costs) between each pair, the objective is to find a closed tour that:
1. Starts from a designated home city.
2. Visits every other city **exactly once** (forming a Hamiltonian Cycle).
3. Returns to the starting city.
4. Minimizes the total distance/cost traveled.

TSP has widespread real-world applications in logistics delivery route planning, DNA sequencing, printed circuit board (PCB) drill scheduling, and microchip manufacturing.

---

## Objectives

- Understand the formulation of TSP as finding a minimum-cost Hamiltonian Cycle.
- Implement a state-space tree traversal using **Backtracking** in Java.
- Manage visited vertex state tracking and restoration (backtracking step).
- Analyze the factorial time complexity of exhaustive search ($O(n!)$) vs. dynamic programming ($O(n^2 2^n)$).

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `TSP.java` | `TSP` | Implements recursive depth-first backtracking to explore all valid city permutations, returning the global minimum tour cost. |

---

## Backtracking Formulation & State-Space Tree

The algorithm generates candidate tours by incrementally extending paths:

1. **State Parameters**:
   - `curr`: The city currently being visited.
   - `count`: Number of cities visited so far (starts at `1`).
   - `total`: Cumulative cost accumulated along the current path.
   - `visited[]`: Boolean array preventing revisiting already chosen cities.

2. **Base Condition (Complete Tour)**:
   - When `count == n` (all cities visited):
     - Check if a return edge to origin city `0` exists (`cost[curr][0] != 0`).
     - If so, update global minimum:
       $$\text{minCost} = \min(\text{minCost}, \; \text{total} + cost[curr][0])$$
     - Backtrack.

3. **Recursive Step & Backtracking**:
   - For every unvisited city $i$ ($0 \le i < n$):
     - If `!visited[i]` and `cost[curr][i] != 0`:
       - **Choose**: `visited[i] = true`.
       - **Explore**: `tsp(i, count + 1, total + cost[curr][i], visited)`.
       - **Un-choose (Backtrack)**: `visited[i] = false`.

---

## Complexity Analysis

| Approach | Time Complexity | Auxiliary Space Complexity | Scalability Limit |
|---|:---:|:---:|:---:|
| **Backtracking (Implemented)** | $O((n - 1)!)$ | $O(n)$ *(Call stack + visited)* | $n \approx 12 - 15$ |
| **Branch and Bound (with lower bound pruning)** | $O((n - 1)!)$ worst, faster average | $O(n)$ | $n \approx 20 - 25$ |
| **Held-Karp Dynamic Programming** | $O(n^2 \cdot 2^n)$ | $O(n \cdot 2^n)$ | $n \approx 20 - 23$ |
| **Approximation Heuristics (e.g., Christofides, 2-opt)** | Polynomial ($O(n^3)$) | $O(n)$ | $n \ge 1000$ |

---

## Example Walkthrough

Consider 4 cities with the following distance matrix:

```text
       City 0   City 1   City 2   City 3
City 0    0       10       15       20
City 1   10        0       35       25
City 2   15       35        0       30
City 3   20       25       30        0
```

### Valid Tours Starting at City 0:
1. $0 \to 1 \to 2 \to 3 \to 0$: $10 + 35 + 30 + 20 = 95$
2. $0 \to 1 \to 3 \to 2 \to 0$: $10 + 25 + 30 + 15 = \mathbf{80}$
3. $0 \to 2 \to 1 \to 3 \to 0$: $15 + 35 + 25 + 20 = 95$
4. $0 \to 2 \to 3 \to 1 \to 0$: $15 + 30 + 25 + 10 = \mathbf{80}$
5. $0 \to 3 \to 1 \to 2 \to 0$: $20 + 25 + 35 + 15 = 95$
6. $0 \to 3 \to 2 \to 1 \to 0$: $20 + 30 + 35 + 10 = 95$

**Minimum Tour Cost:** $\mathbf{80}$ (e.g., Tour $0 \to 1 \to 3 \to 2 \to 0$).

---

## Sample Execution

**Sample Input:**
```text
Enter number of cities: 4
Enter cost matrix:
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0
```

**Output:**
```text
Minimum Cost: 80
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical12/TSP.java

# Run
java Practical12.TSP
```

---

## Learning Outcomes

- Modeled an NP-hard optimization problem using permutation search trees.
- Mastered the recursive Backtracking pattern (Choose $\to$ Explore $\to$ Un-choose).
- Understood why exhaustive search scales factorially and motivates pruning/branch-and-bound strategies.
