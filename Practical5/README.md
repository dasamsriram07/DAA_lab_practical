# Practical 5 — 0/1 Knapsack Problem Using Dynamic Programming

## Overview

The **0/1 Knapsack Problem** is a canonical combinatorial optimization problem. Given a collection of `n` items, each characterized by a weight `wt[i]` and a profit/value `val[i]`, and a knapsack of maximum weight capacity `W`, the objective is to choose a subset of items that maximizes the total value without exceeding capacity `W`.

The name **0/1** denotes that each item must either be completely included (1) or excluded (0); fractional items are not permitted (unlike the Fractional Knapsack problem solved via Greedy approach).

---

## Objectives

- Understand the principles of **Optimal Substructure** and **Overlapping Subproblems** in dynamic programming.
- Implement bottom-up 2D tabulation for the 0/1 Knapsack problem in Java.
- Reconstruct the exact subset of selected items via table backtracking.
- Analyze the pseudo-polynomial time and space complexity (`O(n * W)`).

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `tab_0_1_knapsack.java` | `tab_0_1_knapsack` | Bottom-up DP tabulation, prints the full DP matrix, maximum profit, and backtracks selected items. |

---

## Dynamic Programming Formulation

Let `dp[i][w]` represent the maximum profit achievable considering the first `i` items with a knapsack capacity of `w` (where `0 <= i <= n` and `0 <= w <= W`).

### Base Cases
```text
dp[i][0] = 0   for all i (when knapsack capacity is 0)
dp[0][w] = 0   for all w (when 0 items are available)
```

### Recurrence Relation
For each item `i` with weight `wt[i - 1]` and value `val[i - 1]`:

```text
If weight is less than or equal to current capacity (wt[i - 1] <= w):
    dp[i][w] = max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]])

If weight exceeds current capacity (wt[i - 1] > w):
    dp[i][w] = dp[i - 1][w]
```

Where:
- `dp[i - 1][w]`: The profit if we exclude item `i`.
- `val[i - 1] + dp[i - 1][w - wt[i - 1]]`: The profit if we include item `i` plus the best solution for the remaining capacity.

### Backtracking Selected Items
To find which items contributed to the maximum profit:
1. Start at cell `(i = n, w = W)`.
2. While `i > 0` and `w > 0`:
   - If `keep[i][w]` is true (or `dp[i][w] > dp[i - 1][w]`):
     - Item `i` is included in the knapsack.
     - Reduce capacity: `w = w - wt[i - 1]`.
   - Decrement item pointer: `i = i - 1`.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | `O(n * W)` | A nested loop fills each of the `(n + 1) * (W + 1)` table entries in constant time `O(1)`. |
| **Space Complexity** | `O(n * W)` | 2D table of size `(n + 1) * (W + 1)` used for tabulation and backtracking. |
| **Problem Classification** | **Pseudo-polynomial** | Polynomial with respect to the numerical value `W`, exponential in terms of its bit length. |

---

## Example Walkthrough

### Given Data
- **Knapsack Capacity (W):** `5`
- **Number of items (n):** `4`

| Item (i) | Weight | Value |
|:---:|:---:|:---:|
| 1 | 2 | 12 |
| 2 | 1 | 10 |
| 3 | 3 | 20 |
| 4 | 2 | 15 |

### Optimal Subset Choice
- **Selected Items:** Items 1, 2, and 4
- **Total Weight:** `2 + 1 + 2 = 5 <= 5` (Valid, fully uses capacity)
- **Total Profit:** `12 + 10 + 15 = 37`

*(Notice: Picking Items 2, 3, and 4 gives weight `1 + 3 + 2 = 6`, which exceeds capacity 5 and is not allowed).*

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
- Avoided exponential recalculation (`O(2^n)` in naive recursion) using memoization/tabulation.
- Implemented state tracking to reconstruct the exact items forming the maximum profit.
