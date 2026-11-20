# Practical 6 — Matrix Chain Multiplication Using Dynamic Programming

## Overview

**Matrix Chain Multiplication (MCM)** is an optimization problem that seeks the most computationally efficient order (parenthesization) in which to multiply a sequence of matrices. 

Because matrix multiplication is **associative**, the mathematical result is identical regardless of how parentheses are placed:
```text
(A * B) * C = A * (B * C)
```
However, the number of individual scalar multiplications varies drastically based on the sequence of multiplications. Dynamic programming computes the optimal parenthesization in `O(n^3)` time, compared to the exponential growth (`O(4^n / n^(3/2))`) required by brute-force evaluation.

---

## Objectives

- Understand the associative property of matrix multiplication and its computational impact.
- Formulate the MCM problem using the Dynamic Programming paradigm.
- Construct the DP cost matrix (`m`) and split table (`k`) to trace optimal split points.
- Implement recursive parenthesization formatting to output human-readable groupings.
- Analyze the `O(n^3)` asymptotic time complexity and `O(n^2)` auxiliary space.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `MatrixChainMultiplication.java` | `MatrixChainMultiplication` | Implements interval-length DP table construction, prints DP and K tables, and reconstructs optimal parenthesization. |

---

## Dynamic Programming Formulation

Let a sequence of `n` matrices be `A1, A2, ..., An`, where matrix `Ai` has dimensions `p[i - 1] x p[i]`. The dimension array is:
```text
p = [p0, p1, p2, ..., pn]
```

Let `m[i][j]` denote the minimum number of scalar multiplications required to compute the product subchain `Ai...Aj` (for `1 <= i <= j <= n`).

### Base Case
A chain consisting of a single matrix requires zero multiplications:
```text
m[i][i] = 0   for all 1 <= i <= n
```

### Recurrence Relation
For a subchain from matrix `i` to matrix `j` (where `i < j`), we test all possible split points `k` such that `i <= k < j`:

```text
m[i][j] = min { m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]) }   for i <= k < j
```

Where:
- `m[i][k]`: Cost of multiplying subchain `Ai...Ak`.
- `m[k + 1][j]`: Cost of multiplying subchain `A(k+1)...Aj`.
- `p[i - 1] * p[k] * p[j]`: Cost of multiplying the two resulting matrices.
- `split[i][j]`: Stores the split index `k` that achieved the minimum multiplication cost.

### Parenthesization Reconstruction
```java
public static String grouping(int i, int j) {
    if (i == j) return "A" + i;
    int k = split[i][j];
    return "(" + grouping(i, k) + grouping(k + 1, j) + ")";
}
```

---

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|:---:|---|
| **Time Complexity** | `O(n^3)` | Three nested loops: chain length `L` (2 to n), starting index `i` (1 to n - L + 1), and split position `k` (i to j - 1). |
| **Space Complexity** | `O(n^2)` | Requires two `(n + 1) x (n + 1)` 2D tables: cost matrix `m` and split table `split`. |

---

## Example Walkthrough

Consider 3 matrices with dimension array `p = [10, 30, 5, 60]`:
- Matrix `A1`: `10 x 30`
- Matrix `A2`: `30 x 5`
- Matrix `A3`: `5 x 60`

### Comparison of Parenthesizations

1. **Option 1: (A1 * A2) * A3**
   - Multiply `A1 * A2`: `10 * 30 * 5 = 1,500` multiplications (produces `10 x 5` matrix).
   - Multiply result by `A3`: `10 * 5 * 60 = 3,000` multiplications.
   - **Total multiplications:** `1,500 + 3,000 = 4,500`

2. **Option 2: A1 * (A2 * A3)**
   - Multiply `A2 * A3`: `30 * 5 * 60 = 9,000` multiplications (produces `30 x 60` matrix).
   - Multiply `A1` by result: `10 * 30 * 60 = 18,000` multiplications.
   - **Total multiplications:** `9,000 + 18,000 = 27,000`

**Optimal Choice:** `(A1 * A2) * A3` with **4,500** scalar multiplications (6 times fewer operations than Option 2).

---

## Sample Execution

**Sample Input:**
```text
Enter number of matrices: 3
Enter dimensions:
10 30 5 60
```

**Output:**
```text
DP Matrix:
-	1500	4500	
-	-	9000	
-	-	-	

K Table:
-	1	2	
-	-	2	
-	-	-	

Minimum multiplications = 4500
Grouped ((A1A2)A3)
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile
javac Practical6/MatrixChainMultiplication.java

# Run
java Practical6.MatrixChainMultiplication
```

---

## Learning Outcomes

- Learned interval-length dynamic programming where smaller subproblems correspond to shorter subchains.
- Understood why brute-force evaluation is intractable due to Catalan number exponential growth.
- Mastered split-point memoization and recursive reconstruction of optimal operation trees.
