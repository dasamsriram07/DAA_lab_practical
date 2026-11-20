# Practical 7 — Making Change Using Dynamic Programming

## Overview

The **Coin Change Problem (Minimum Coins Formulation)** requires finding the minimum number of coins needed to form a specified target amount $W$, given a fixed set of coin denominations $C = \{c_1, c_2, \dots, c_n\}$. Each denomination is assumed to be available in unlimited supply (unbounded choice).

While a **Greedy Algorithm** (repeatedly taking the largest possible denomination) works for canonical currency systems like US coins, it fails on general denomination sets. Dynamic Programming guarantees the global optimal minimum for any arbitrary currency set.

---

## Objectives

- Understand why greedy heuristics fail on arbitrary coin denomination sets.
- Model the Coin Change Problem as an unbounded dynamic programming recurrence.
- Implement 2D bottom-up tabulation to compute the minimum coin count.
- Backtrack through the DP table to extract the exact denomination counts used.
- Formally analyze time and space complexity.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `coinChange.java` | `coinChange` | 2D dynamic programming tabulation for minimum coin count and backtracking of chosen coin denominations. |

---

## Why Greedy Fails (Motivating Example)

Consider denominations $C = \{1, 5, 7\}$ and target amount $W = 11$:
- **Greedy Strategy**:
  - Picks largest coin $\le 11$: $7$ (Remaining: $4$)
  - Picks largest coin $\le 4$: $1 \times 4$ (Remaining: $0$)
  - **Greedy Solution**: $7 + 1 + 1 + 1 + 1 = 11 \implies \mathbf{5 \text{ coins}}$.
- **Dynamic Programming Solution**:
  - Explores all optimal combinations.
  - Picks $5 + 5 + 1 = 11 \implies \mathbf{3 \text{ coins}}$.
- **Conclusion**: Greedy produces a suboptimal result (5 coins vs. the optimal 3 coins).

---

## Dynamic Programming Formulation

Let $T[i][j]$ represent the minimum number of coins needed to form amount $j$ ($0 \le j \le W$) using a subset of the first $i+1$ denominations ($0 \le i < n$).

### Base Cases (First Coin $coins[0]$)
$$
T[0][j] = \begin{cases}
0 & \text{if } j = 0 \\
j / coins[0] & \text{if } j \pmod{coins[0]} = 0 \\
\infty \ (W + 1) & \text{otherwise (unreachable)}
\end{cases}
$$

### Recurrence Relation (For $i \ge 1$)
For each coin $i$ and amount $j$:

$$
T[i][j] = \begin{cases}
T[i-1][j] & \text{if } j < coins[i] \\
\min\Big(T[i-1][j], \; 1 + T[i][j - coins[i]]\Big) & \text{if } j \ge coins[i]
\end{cases}
$$

*Note: In the second term, we use $T[i][j - coins[i]]$ rather than $T[i-1][\dots]$ because a denomination can be reused multiple times.*

### Backtracking to Find Coins Used
1. Start at cell $(i = n - 1, \text{amount} = W)$.
2. While $\text{amount} > 0$ and $i \ge 0$:
   - If $i > 0$ and $T[i][\text{amount}] == T[i - 1][\text{amount}]$, the $i$-th coin was not used; decrement $i \leftarrow i - 1$.
   - Else, the $i$-th coin was included: increment `selected[i]`, and decrement $\text{amount} \leftarrow \text{amount} - coins[i]$.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | $O(n \cdot W)$ | The algorithm fills a matrix of size $n \times (W + 1)$ with $O(1)$ operations per state. |
| **Space Complexity** | $O(n \cdot W)$ | Space allocated for the 2D DP matrix $T$ and tracking array. *(Can be optimized to $O(W)$ using a 1D array).* |

---

## Sample Execution

**Sample Input:**
```text
Enter number of coins: 3
Enter 3 coin denominations:
1 5 7
Enter target amount: 11
```

**Output:**
```text
Minimum number of coins: 3
Selected denominations:
1 denomination: 1 coin
5 denomination: 2 coin
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical7/coinChange.java

# Run
java Practical7.coinChange
```

---

## Learning Outcomes

- Demonstrated the limitation of greedy algorithms and proved optimality via Dynamic Programming.
- Formulated an unbounded knapsack variant with infinite supply per item.
- Implemented state reconstruction to determine the frequency distribution of selected coins.
