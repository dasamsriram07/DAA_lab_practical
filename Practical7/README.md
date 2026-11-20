# Practical 7 — Making Change Using Dynamic Programming

## Overview

The **Coin Change Problem (Minimum Coins Formulation)** requires finding the minimum number of coins needed to form a specified target amount `W`, given a fixed set of coin denominations `coins = [c1, c2, ..., cn]`. Each denomination can be reused unlimited times.

While a **Greedy Algorithm** (repeatedly taking the largest possible coin) works for some currency systems, it often fails on general denomination sets. Dynamic Programming guarantees finding the true minimum number of coins for any arbitrary set of denominations.

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

Consider denominations `coins = [1, 5, 7]` and target amount `W = 11`:
- **Greedy Strategy**:
  - Picks largest coin `<= 11`: `7` (Remaining: `4`)
  - Picks largest coin `<= 4`: `1 x 4` (Remaining: `0`)
  - **Greedy Solution**: `7 + 1 + 1 + 1 + 1 = 11` -> **5 coins**.
- **Dynamic Programming Solution**:
  - Evaluates combinations systematically.
  - Picks `5 + 5 + 1 = 11` -> **3 coins**.
- **Conclusion**: Greedy produces a suboptimal result (5 coins vs. the optimal 3 coins).

---

## Dynamic Programming Formulation

Let `T[i][j]` represent the minimum number of coins needed to form amount `j` (`0 <= j <= W`) using only the first `i + 1` denominations (`0 <= i < n`).

### Base Cases (First Denomination `coins[0]`)
```text
T[0][0] = 0

If j is divisible by coins[0]:
    T[0][j] = j / coins[0]
Else:
    T[0][j] = Infinity  (amount cannot be formed with coins[0] alone)
```

### Recurrence Relation (For subsequent coins `i >= 1`)
For each coin `i` and amount `j`:

```text
If j < coins[i]:
    T[i][j] = T[i - 1][j]

If j >= coins[i]:
    T[i][j] = min(T[i - 1][j], 1 + T[i][j - coins[i]])
```

*Note: In the second case, `T[i][j - coins[i]]` is referenced rather than `T[i - 1][...]` because the same coin `coins[i]` can be used multiple times.*

### Backtracking to Find Coins Used
1. Start at table cell `(i = n - 1, amount = W)`.
2. While `amount > 0` and `i >= 0`:
   - If `i > 0` and `T[i][amount] == T[i - 1][amount]`, coin `i` was not used; move up: `i = i - 1`.
   - Else, coin `i` was used: increment `selected[i]`, and reduce remaining amount: `amount = amount - coins[i]`.

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | `O(n * W)` | The algorithm fills an `n x (W + 1)` table with constant-time operations per entry. |
| **Space Complexity** | `O(n * W)` | 2D table `T` of size `n x (W + 1)` and tracking array. (Can be reduced to `O(W)` using a 1D array). |

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
