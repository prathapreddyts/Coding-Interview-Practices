# Stacks & Queues — FAANG Master Sheet

## Package Structure

```
stacksandqueues/
├── stacks/
│   ├── basics/
│   │   ├── ValidParentheses.java          ← Parentheses family (#20, #921, #1249, #32, #678)
│   │   ├── MinStack.java                  ← Design stack (#155, #716, O(1) space variant)
│   │   ├── ImplementQueueUsingStacks.java ← Interconversion (#232, #225, ArrayDeque)
│   │   ├── EvaluateReversePolishNotation.java ← Expression eval (#150, #224, #227, #772, #394, #71)
│   │   ├── BackspaceStringCompare.java    ← Adjacent removal (#844, #1047, #1209, #1544)
│   │   └── StockBuySellProblems.java      ← DP/Greedy (#121, #122, #123, #188, #309, #714)
│   └── monotonic/
│       ├── MonotonicStackTemplates.java   ← START HERE (8 core templates WITH code)
│       └── MonotonicStackApplications.java ← 25+ problems grouped by pattern (TODOs)
└── queues/
    ├── basics/
    │   ├── DesignCircularQueue.java
    │   └── MovingAverage.java
    ├── slidingwindow/
    │   └── SlidingWindowMaximum.java      ← MOST ASKED queue pattern
    └── design/
        └── TaskScheduler.java
```

---

## Pattern → Problems Map

### 🔴 P1: Monotonic Stack (Most asked at FAANG)
| Problem | Leetcode | Level |
|---|---|---|
| Daily Temperatures | #739 | Medium |
| Next Greater Element I | #496 | Easy |
| Next Greater Element II (Circular) | #503 | Medium |
| Largest Rectangle in Histogram | #84 | Hard ⭐ |
| Maximal Rectangle | #85 | Hard ⭐ |
| Trapping Rain Water | #42 | Hard ⭐ |
| Sum of Subarray Minimums | #907 | Medium |
| Online Stock Span | #901 | Medium |
| Remove K Digits | #402 | Medium |
| Asteroid Collision | #735 | Medium |
| 132 Pattern | #456 | Medium |

### 🟠 P2: Stack Basics
| Problem | Leetcode | Level |
|---|---|---|
| Valid Parentheses | #20 | Easy |
| Min Stack | #155 | Medium |
| Evaluate Reverse Polish Notation | #150 | Medium |
| Basic Calculator I | #224 | Hard |
| Basic Calculator II | #227 | Medium |
| Decode String | #394 | Medium |
| Simplify Path | #71 | Medium |
| Remove Adjacent Duplicates | #1047 | Easy |
| Longest Valid Parentheses | #32 | Hard |

### 🟡 P3: Monotonic Deque / Sliding Window
| Problem | Leetcode | Level |
|---|---|---|
| Sliding Window Maximum | #239 | Hard ⭐ |
| Jump Game VI | #1696 | Medium |
| Constrained Subsequence Sum | #1425 | Hard |
| Longest Subarray Abs Diff ≤ Limit | #1438 | Medium |

### 🟢 P4: Queue Design
| Problem | Leetcode | Level |
|---|---|---|
| Design Circular Queue | #622 | Medium |
| Design Circular Deque | #641 | Medium |
| Moving Average | #346 | Easy |
| Design Hit Counter | #362 | Medium |
| Task Scheduler | #621 | Medium ⭐ |
| Reorganize String | #767 | Medium |
| Dota2 Senate | #649 | Medium |
| First Non-Repeating Char in Stream | Custom | Medium |

### 🔵 P5: Stack/Queue + Other Patterns
| Problem | Leetcode | Level |
|---|---|---|
| Best Time to Buy & Sell Stock I–VI | #121,122,123,188,309,714 | All levels |
| Container With Most Water | #11 | Medium |
| Min Add to Make Parentheses Valid | #921 | Medium |
| Minimum Remove to Make Valid | #1249 | Medium |

---

## Recommended Study Order

1. **ValidParentheses** → understand stack push/pop pattern
2. **MinStack** → understand auxiliary data structures
3. **MonotonicStackTemplates** → MASTER all 8 directions with code ⭐⭐
4. **MonotonicStackApplications Group 1** → NGE problems (Daily Temps, NGE I/II/III)
5. **MonotonicStackApplications Group 3** → Largest Rectangle in Histogram ⭐
6. **MonotonicStackApplications Group 4** → Trapping Rain Water (all 3 approaches) ⭐
7. **MonotonicStackApplications Group 5** → Contribution technique (Sum of Subarray Mins)
8. **SlidingWindowMaximum** → learn monotonic deque ⭐
9. **EvaluateRPN → BasicCalculator I, II, III** — progressive
10. **StockBuySellProblems** — state machine DP (all 6 variants)

---
