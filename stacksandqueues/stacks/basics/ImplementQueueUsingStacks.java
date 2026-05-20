package stacksandqueues.stacks.basics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * IMPLEMENT QUEUE USING STACKS — LeetCode #232 | FAANG Frequency: ⭐⭐⭐⭐
 *
 * Implement a FIFO queue using only two stacks.
 * Implement push, pop, peek, empty — all amortized O(1).
 *
 * Example:
 *  push(1), push(2)
 *  peek() → 1
 *  pop()  → 1
 *  empty()→ false
 *
 * Pattern: Lazy transfer between two stacks
 * Time: push O(1), pop amortized O(1) | Space: O(n)
 */
public class ImplementQueueUsingStacks {

    public static class MyQueue {

        public MyQueue() {}

        /** Push element to back of queue. */
        public void push(int x) {}

        /** Removes element from front of queue and returns it. */
        public int pop() { return 0; }

        /** Get front element. */
        public int peek() { return 0; }

        /** Returns true if queue is empty. */
        public boolean empty() { return true; }
    }

    // -----------------------------------------------------------------------
    // REVERSE PROBLEM: IMPLEMENT STACK USING QUEUES — LeetCode #225
    // -----------------------------------------------------------------------

    /**
     * Implement a LIFO stack using only two queues.
     *
     * Example:
     *  push(1), push(2)
     *  top()  → 2
     *  pop()  → 2
     *  empty()→ false
     *
     * Pattern: On every push, rotate queue so newest is always at front
     * Time: push O(n), pop O(1) | Space: O(n)
     */
    public static class MyStack {

        public MyStack() {}

        /** Push element x onto stack. */
        public void push(int x) {}

        /** Removes the element on top of the stack and returns it. */
        public int pop() { return 0; }

        /** Get the top element. */
        public int top() { return 0; }

        /** Returns whether the stack is empty. */
        public boolean empty() { return true; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP: Design a stack / queue using a Deque (most efficient)
    // -----------------------------------------------------------------------

    /**
     * Stack using single Deque (ArrayDeque) — FAANG prefers this over Stack class
     */
    public static class StackViaDeque {
        // Use ArrayDeque<Integer> instead of Stack (faster, no synchronisation overhead)
        // push → addFirst, pop → removeFirst, peek → peekFirst

        public void push(int x) {}
        public int pop() { return 0; }
        public int peek() { return 0; }
        public boolean isEmpty() { return true; }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());  // 1
        System.out.println(q.pop());   // 1
        System.out.println(q.empty()); // false

        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());   // 2
        System.out.println(s.pop());   // 2
        System.out.println(s.empty()); // false
    }
}

