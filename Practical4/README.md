# Practical 4 — Factorial Using Iterative and Recursive Methods

## Overview

The factorial of a non-negative integer `n`, written as `n!`, is the product of all positive integers less than or equal to `n`. Factorial computation is a classic computer science problem used to illustrate and contrast **iterative loop constructs** against **recursive function calls**.

This practical implements and evaluates factorial computation using both paradigms:
1. **Iterative Formulation**: Accumulator variable updated across `n` loop steps.
2. **Recursive Formulation**: Self-referential functional decomposition with a base condition.

---

## Objectives

- Understand iterative vs. recursive problem-solving approaches.
- Implement both iterative and recursive factorial algorithms in Java with dynamic user input.
- Compare memory usage: CPU registers / local variables vs. JVM Call Stack activation frames.
- Analyze asymptotic time and space complexities.

---

## Source Files

| File | Class Name | Description |
|---|---|---|
| `factIterat.java` | `factIterat` | Computes factorial via an iterative `for` loop accumulator. |
| `factRecur.java` | `factRecur` | Computes factorial via recursive function calls with base case `n <= 1`. |

---

## Mathematical Formulation

For any non-negative integer `n`:

```text
factorial(n) = 1                    if n = 0 or n = 1
factorial(n) = n * factorial(n - 1)  if n > 1
```

### 1. Iterative Approach
- Uses a local variable `factorial = 1`.
- Executes loop from `i = 1` to `n`: `factorial *= i`.
- **Memory Footprint**: Strictly constant memory (`O(1)`) using a single integer counter.

### 2. Recursive Approach
- Evaluates base case: `if (n <= 1) return 1`.
- Recursive step: `return n * fact(n - 1)`.
- **Memory Footprint**: Allocates an activation frame on the JVM Call Stack for each call from `n` down to `1`, resulting in `O(n)` memory. For very large values of `n`, this can cause a `StackOverflowError`.

---

## Complexity Analysis

| Method | Time Complexity | Auxiliary Space Complexity | Stack Frame Overhead | Stack Overflow Risk? |
|---|:---:|:---:|:---:|:---:|
| **Iterative** | `O(n)` | `O(1)` | None (in-place registers) | No |
| **Recursive** | `O(n)` | `O(n)` | `n` activation frames | Yes (for very large `n`) |

---

## Example Input & Output

**Sample Input:**
```text
Enter the number which you want to know what is it's factorial:
5
```

**Calculation Trace:**
```text
5! = 5 * 4 * 3 * 2 * 1 = 120
```

**Output:**
```text
The factorial of 5 is 120
```

---

## Compilation and Execution

From the root directory (`DAA_LAB`):

```bash
# Compile both implementations
javac Practical4/*.java

# Run Iterative Factorial
java Practical4.factIterat

# Run Recursive Factorial
java Practical4.factRecur
```

---

## Learning Outcomes

- Understood how recursion translates into runtime stack frame allocations.
- Identified base condition necessity to prevent infinite recursive descent.
- Compared space-time trade-offs between clean mathematical recursive definitions and memory-efficient iterative loops.
