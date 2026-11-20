# Practical 5 — 0/1 Knapsack Problem Using Dynamic Programming

## Overview

The **0/1 Knapsack Problem** is a canonical combinatorial optimization problem. Given a collection of $n$ items, each characterized by a weight $w_i$ and a value/profit $v_i$, and a knapsack of maximum weight capacity $W$, the objective is to choose a subset of items that maximizes the total value without exceeding capacity $W$.

The prefix **0/1** denotes that each item must either be completely included ($1$) or excluded ($0$); items cannot be divided into fractional units (unlike the Fractional Knapsack problem solved via Greedy approach).

---

## Objectives

- Understand the principles of **Optimal Substructure** and **Overlapping Subproblems** in dynamic programming.
- Implement bottom-up 2D tabulation for the 0/1 Knapsack problem in Java.
- Reconstruct the exact subset of selected items via backtracking/keep-tracking.
- Analyze the pseudo-polynomial time and space complexity ($O(n \cdot W)$).

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `tab_0_1_knapsack.java` | `tab_0_1_knapsack` | Bottom-up DP tabulation, prints the full DP matrix, maximum profit, and backtracks selected items. |

---

## Dynamic Programming Formulation

Let $dp[i][w]$ represent the maximum value achievable considering the first $i$ items with a sub-capacity of $w$ (where $0 \le i \le n$ and $0 \le w \le W$).

### Base Cases
$$dp[i][0] = 0 \quad \forall \ 0 \le i \le n$$
$$dp[0][w] = 0 \quad \forall \ 0 \le w \le W$$

### Recurrence Relation
For each item $i$ (with weight $wt[i-1]$ and value $val[i-1]$):

$$
dp[i][w] = \begin{cases}
\max\Big(dp[i-1][w], \; val[i-1] + dp[i-1][w - wt[i-1]]\Big) & \text{if } wt[i-1] \le w \\
dp[i-1][w] & \text{if } wt[i-1] > w
\end{cases}
$$

### Backtracking Selected Items
To find which items contributed to the optimal solution:
1. Start at cell $(i = n, w = W)$.
2. If $dp[i][w] > dp[i-1][w]$ (or `keep[i][w] == true`), item $i$ was included:
   - Output item $i$.
   - Decrement capacity: $w \leftarrow w - wt[i-1]$.
3. Decrement item pointer: $i \leftarrow i - 1$.
4. Repeat until $i = 0$ or $w = 0$.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | $O(n \cdot W)$ | A nested loop fills each of the $(n+1) \times (W+1)$ cells in constant time $O(1)$. |
| **Space Complexity** | $O(n \cdot W)$ | Space required for the 2D DP matrix and decision boolean table. |
| **Type** | **Pseudo-polynomial** | Polynomial in value of $W$, exponential in number of bits required to represent $W$. |

---

## Example Walkthrough

### Given Data
- **Knapsack Capacity ($W$):** $5$
- **Number of items ($n$):** $4$

| Item ($i$) | Weight ($wt$) | Value ($val$) |
|:---:|:---:|:---:|
| 1 | 2 | 12 |
| 2 | 1 | 10 |
| 3 | 3 | 20 |
| 4 | 2 | 15 |

### Optimal Solution Evaluation
- **Subset:** Items 1, 2, and 4
- **Total Weight:** $2 + 1 + 2 = 5 \le 5$ (Valid)
- **Total Value:** $12 + 10 + 15 = 37$

*(Notice: Selecting Items 2, 3, and 4 yields weight $1 + 3 + 2 = 6 > 5$, which exceeds capacity and is invalid).*

---

## Sample Execution

**Sample Input:**
```text
Enter capacity of the bag: 
5
Enter the no.of items of the bag: 
4
enter the values of the profit
12 10 20 15
enter the values of the weights
2 1 3 2
```

**Output:**
```text
0 0 0 0 0 0 
0 0 12 12 12 12 
0 10 12 22 22 22 
0 10 12 22 30 32 
0 10 15 25 32 37 

Maximum profit = 37
Selected items:
Item 4:Weight = 2:profit = 15
Item 2:Weight = 1:profit = 10
Item 1:Weight = 2:profit = 12
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical5/tab_0_1_knapsack.java

# Run
java Practical5.tab_0_1_knapsack
```

---

## Learning Outcomes

- Formulated optimization decisions as recursive subproblems and converted them to iterative bottom-up table fills.
- Avoided exponential recalculation ($O(2^n)$ in naive recursion) using memoization/tabulation.
- Implemented state tracking to reconstruct the exact items forming the maximum profit.
