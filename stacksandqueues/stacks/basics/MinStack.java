package stacksandqueues.stacks.basics;

import java.util.Stack;

/**
 * MIN STACK — LeetCode #155 | FAANG Frequency: ⭐⭐⭐⭐⭐
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * Operations:
 *  - push(val)  → push element onto stack
 *  - pop()      → remove top element
 *  - top()      → get top element
 *  - getMin()   → retrieve the minimum element  ← must be O(1)
 *
 * Example:
 *  push(-2), push(0), push(-3)
 *  getMin() → -3
 *  pop()
 *  top()    → 0
 *  getMin() → -2
 *
 * Constraints: -2^31 <= val <= 2^31 - 1
 *
 * Pattern: Auxiliary min-tracking stack
 * Time: O(1) for all ops | Space: O(n)
 */
public class MinStack {

    // Approach 1: Two stacks (main + minStack)
    public static class MinStackTwoStacks {
        // TODO: implement with two stacks

        public MinStackTwoStacks() {}

        public void push(int val) {}

        public void pop() {}

        public int top() { return 0; }

        public int getMin() { return 0; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Max Stack — LeetCode #716 (Hard)
    // Design stack with push, pop, top, peekMax, popMax all in O(log n)
    // -----------------------------------------------------------------------

    /**
     * MaxStack with O(log n) operations using TreeMap + DoubleLinkedList
     */
    public static class MaxStack {

        public MaxStack() {}

        /** Push element x onto stack. */
        public void push(int x) {}

        /** Remove element on top and return it. */
        public int pop() { return 0; }

        /** Get top element. */
        public int top() { return 0; }

        /** Retrieve the maximum element. */
        public int peekMax() { return 0; }

        /** Remove the element that is at the top, but also the max. */
        public int popMax() { return 0; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Min Stack using O(1) extra space (single stack trick)
    // Store encoded value: push(val - currentMin), update min on the fly
    // -----------------------------------------------------------------------

    public static class MinStackO1Space {
        // Uses a single stack storing encoded values
        // Actual min tracked in a variable

        private Stack<Long> stack = new Stack<>();
        private long min;

        public MinStackO1Space() {}

        public void push(int val) {
            // TODO: encode and push
        }

        public void pop() {
            // TODO: decode on pop, restore min if needed
        }

        public int top() { return 0; }

        public int getMin() { return (int) min; }
    }

    public static void main(String[] args) {
        MinStackTwoStacks ms = new MinStackTwoStacks();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin()); // -3
        ms.pop();
        System.out.println(ms.top());    // 0
        System.out.println(ms.getMin()); // -2
    }
}

