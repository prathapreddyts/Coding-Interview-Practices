# Stacks & Queues — FAANG Master Sheet

## Package Structure

```
stacksandqueues/
├── stacks/
│   ├── basics/
│   │   ├── ValidParentheses.java
│   │   ├── MinStack.java
│   │   ├── ImplementQueueUsingStacks.java
│   │   ├── EvaluateReversePolishNotation.java
│   │   └── BackspaceStringCompare.java
│   └── monotonic/
│       ├── DailyTemperatures.java         ← START HERE (monotonic template)
│       ├── LargestRectangleInHistogram.java
│       ├── TrappingRainWater.java
│       ├── SumOfSubarrayMinimums.java
│       └── OnlineStockSpan.java
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
3. **DailyTemperatures** → learn monotonic stack template
4. **NextGreaterElement I, II** → reinforce template
5. **LargestRectangleInHistogram** → hardest monotonic stack ⭐
6. **TrappingRainWater** (all 3 approaches) ⭐
7. **SlidingWindowMaximum** → learn monotonic deque ⭐
8. **TaskScheduler** → heap + queue simulation
9. **EvaluateRPNExpression → BasicCalculator I, II, III** — progressive
10. **Stock problems** — state machine DP

---

## Monotonic Stack Template (Memorize This)

```java
// NEXT GREATER ELEMENT template
Stack<Integer> stack = new Stack<>();
int[] result = new int[n];
Arrays.fill(result, -1);

for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        result[stack.pop()] = nums[i]; // nums[i] is NGE for popped element
    }
    stack.push(i);
}
```

## Monotonic Deque Template (Memorize This)

```java
// SLIDING WINDOW MAXIMUM template
Deque<Integer> deque = new ArrayDeque<>(); // stores indices

for (int i = 0; i < n; i++) {
    // 1. Remove indices outside window
    while (!deque.isEmpty() && deque.peekFirst() < i - k + 1)
        deque.pollFirst();

    // 2. Maintain decreasing order — remove useless smaller elements
    while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
        deque.pollLast();

    deque.offerLast(i);

    // 3. Window is full — record answer
    if (i >= k - 1)
        result[i - k + 1] = nums[deque.peekFirst()];
}
```

