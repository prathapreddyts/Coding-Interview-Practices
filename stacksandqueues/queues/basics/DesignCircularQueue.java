package stacksandqueues.queues.basics;

/**
 * DESIGN CIRCULAR QUEUE — LeetCode #622 | FAANG Frequency: ⭐⭐⭐⭐
 * Asked at: Amazon, Microsoft
 *
 * Design a circular queue (ring buffer) with fixed capacity.
 * Operations: enQueue, deQueue, Front, Rear, isEmpty, isFull
 *
 * Example:
 *  CircularQueue(3)
 *  enQueue(1) → true
 *  enQueue(2) → true
 *  enQueue(3) → true
 *  enQueue(4) → false (full)
 *  Rear()     → 3
 *  isFull()   → true
 *  deQueue()  → true
 *  enQueue(4) → true
 *  Rear()     → 4
 *
 * Pattern: Array with head/tail pointers and size counter
 * Time: O(1) for all ops | Space: O(k)
 */
public class DesignCircularQueue {

    public static class MyCircularQueue {

        public MyCircularQueue(int k) {}

        /** Insert an element. Return true if successful. */
        public boolean enQueue(int value) { return false; }

        /** Delete front element. Return true if successful. */
        public boolean deQueue() { return false; }

        /** Get front item. Return -1 if empty. */
        public int Front() { return -1; }

        /** Get last item. Return -1 if empty. */
        public int Rear() { return -1; }

        public boolean isEmpty() { return true; }

        public boolean isFull() { return false; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Design Circular Deque — LeetCode #641 (Medium)
    // Double-ended circular queue
    // -----------------------------------------------------------------------

    /**
     * Circular Deque — supports insert/delete from both front and rear.
     *
     * Example:
     *  CircularDeque(3)
     *  insertLast(1)  → true
     *  insertLast(2)  → true
     *  insertFront(3) → true
     *  insertFront(4) → false (full)
     *  getRear()      → 2
     *  isFull()       → true
     *  deleteLast()   → true
     *  insertFront(4) → true
     *  getFront()     → 4
     */
    public static class MyCircularDeque {

        public MyCircularDeque(int k) {}

        public boolean insertFront(int value) { return false; }
        public boolean insertLast(int value)  { return false; }
        public boolean deleteFront()          { return false; }
        public boolean deleteLast()           { return false; }
        public int getFront()                 { return -1; }
        public int getRear()                  { return -1; }
        public boolean isEmpty()              { return true; }
        public boolean isFull()               { return false; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Design Front Middle Back Queue — LeetCode #1670 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Queue with push/pop at front, middle, AND back.
     *
     * Example:
     *  FrontMiddleBackQueue q
     *  pushFront(1)   → [1]
     *  pushBack(2)    → [1,2]
     *  pushMiddle(3)  → [1,3,2]
     *  pushMiddle(4)  → [1,4,3,2]
     *  popFront()     → 1
     *  popMiddle()    → 3
     *  popMiddle()    → 4
     *  popBack()      → 2
     *  popFront()     → -1
     *
     * Pattern: Two deques (left half + right half) maintain balance invariant
     *          left.size() == right.size() OR left.size() == right.size() - 1
     */
    public static class FrontMiddleBackQueue {

        public FrontMiddleBackQueue() {}

        public void pushFront(int val)  {}
        public void pushMiddle(int val) {}
        public void pushBack(int val)   {}
        public int popFront()           { return -1; }
        public int popMiddle()          { return -1; }
        public int popBack()            { return -1; }
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        System.out.println(q.enQueue(1)); // true
        System.out.println(q.enQueue(2)); // true
        System.out.println(q.enQueue(3)); // true
        System.out.println(q.enQueue(4)); // false — full
        System.out.println(q.Rear());     // 3
        System.out.println(q.deQueue());  // true
        System.out.println(q.enQueue(4)); // true
        System.out.println(q.Rear());     // 4
    }
}

