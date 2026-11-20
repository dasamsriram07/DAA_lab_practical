# Practical 6 — Matrix Chain Multiplication Using Dynamic Programming

## Overview

**Matrix Chain Multiplication (MCM)** is an optimization problem that seeks the most computationally efficient order (parenthesization) in which to multiply a sequence of matrices. 

Because matrix multiplication is **associative**, the mathematical result is identical regardless of how parentheses are placed:
$$(A \times B) \times C = A \times (B \times C)$$
However, the number of individual scalar multiplications varies drastically based on the sequence of multiplications. Dynamic programming computes the optimal parenthesization in $O(n^3)$ time, compared to the exponential Catalan number sequence ($O(4^n / n^{3/2})$) required by brute-force evaluation.

---

## Objectives

- Understand the associative property of matrix multiplication and its computational impact.
- Formulate the MCM problem using the Dynamic Programming paradigm.
- Construct the DP cost matrix ($m$) and split table ($k$/$s$) to trace optimal split points.
- Implement recursive parenthesization formatting to output human-readable groupings.
- Analyze the $O(n^3)$ asymptotic time complexity and $O(n^2)$ auxiliary space.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `MatrixChainMultiplication.java` | `MatrixChainMultiplication` | Implements interval-length DP table construction, prints DP and K tables, and reconstructs optimal parenthesization. |

---

## Dynamic Programming Formulation

Let a sequence of $n$ matrices be $\langle A_1, A_2, \dots, A_n \rangle$, where matrix $A_i$ has dimension $p_{i-1} \times p_i$. The dimensions array is represented as:
$$p = [p_0, p_1, p_2, \dots, p_n]$$

Let $m[i][j]$ denote the minimum number of scalar multiplications required to compute the product subchain $A_{i..j} = A_i \times A_{i+1} \times \dots \times A_j$ (for $1 \le i \le j \le n$).

### Base Case
A chain consisting of a single matrix requires zero multiplications:
$$m[i][i] = 0 \quad \forall \ 1 \le i \le n$$

### Recurrence Relation
For a subchain of length $L \ge 2$, where $1 \le i < j \le n$:

$$
m[i][j] = \min_{i \le k < j} \Big( m[i][k] + m[k+1][j] + p_{i-1} \cdot p_k \cdot p_j \Big)
$$

Where:
- $m[i][k]$: Cost of multiplying subchain $A_{i..k}$
- $m[k+1][j]$: Cost of multiplying subchain $A_{k+1..j}$
- $p_{i-1} \cdot p_k \cdot p_j$: Cost of multiplying the two resulting matrices ($p_{i-1} \times p_k$ and $p_k \times p_j$)
- $split[i][j]$: Stores the index $k$ that achieved the minimum cost.

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
| **Time Complexity** | $O(n^3)$ | Three nested loops: chain length $L$ ($2 \dots n$), start index $i$ ($1 \dots n-L+1$), and split position $k$ ($i \dots j-1$). |
| **Space Complexity** | $O(n^2)$ | Requires two $(n+1) \times (n+1)$ 2D arrays: DP cost matrix $m$ and split point table $split$. |

---

## Example Walkthrough

Consider 3 matrices with dimension array $p = [10, 30, 5, 60]$:
- $A_1$: $10 \times 30$
- $A_2$: $30 \times 5$
- $A_3$: $5 \times 60$

### Comparison of Parenthesizations

1. **Option 1: $(A_1 A_2) A_3$**
   - Multiply $A_1 \times A_2$: $10 \times 30 \times 5 = 1,500$ multiplications (produces $10 \times 5$ matrix).
   - Multiply result by $A_3$: $10 \times 5 \times 60 = 3,000$ multiplications.
   - **Total multiplications:** $1,500 + 3,000 = \mathbf{4,500}$

2. **Option 2: $A_1 (A_2 A_3)$**
   - Multiply $A_2 \times A_3$: $30 \times 5 \times 60 = 9,000$ multiplications (produces $30 \times 60$ matrix).
   - Multiply $A_1$ by result: $10 \times 30 \times 60 = 18,000$ multiplications.
   - **Total multiplications:** $9,000 + 18,000 = \mathbf{27,000}$

**Optimal Choice:** $(A_1 A_2) A_3$ with **4,500** scalar multiplications (a 6x speedup over Option 2).

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
- Understood why brute-force evaluation is intractable due to exponential growth ($C_n = \frac{1}{n+1}\binom{2n}{n}$).
- Mastered split-point memoization and recursive reconstruction of optimal operation trees.
