package stacksandqueues.stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 *  MONOTONIC STACK — 4 DIRECTIONS × 2 VARIANTS = 8 CORE TEMPLATES
 * ═══════════════════════════════════════════════════════════════════════════════
 *
 *  MASTER THUMB RULE (ONE TABLE TO MEMORIZE):
 * ┌───────────┬────────────────┬────────────────┬───────────────┬────────────────────┐
 * │ Direction │  Stack Order   │ Traverse From  │   Pop When    │   Answer For       │
 * ├───────────┼────────────────┼────────────────┼───────────────┼────────────────────┤
 * │ NGE       │ Decreasing     │ Right → Left   │ top <= curr   │ Stack top (before) │
 * │           │ (values/idx)   │ OR Left→Right  │ top < curr    │ curr (on pop)      │
 * ├───────────┼────────────────┼────────────────┼───────────────┼────────────────────┤
 * │ NSE       │ Increasing     │ Right → Left   │ top >= curr   │ Stack top (before) │
 * │           │ (values/idx)   │ OR Left→Right  │ top > curr    │ curr (on pop)      │
 * ├───────────┼────────────────┼────────────────┼───────────────┼────────────────────┤
 * │ PGE       │ Decreasing     │ Left → Right   │ top <= curr   │ Stack top (before  │
 * │           │ (values/idx)   │                │               │ pushing current)   │
 * ├───────────┼────────────────┼────────────────┼───────────────┼────────────────────┤
 * │ PSE       │ Increasing     │ Left → Right   │ top >= curr   │ Stack top (before  │
 * │           │ (values/idx)   │                │               │ pushing current)   │
 * └───────────┴────────────────┴────────────────┴───────────────┴────────────────────┘
 *
 *  KEY INSIGHT:
 *  • "What causes a pop?" → The element that TRIGGERS the pop IS the answer for
 *    the popped element (used in LEFT→RIGHT traversal for NGE/NSE).
 *  • "What's left in stack?" → No answer found → return -1 (or n for index variant).
 *  • For PGE/PSE → answer is whatever is left at TOP after cleaning (LEFT→RIGHT).
 *
 *  VALUE vs INDEX variants:
 *  • Value variant: push values → result stores values (simple, readable)
 *  • Index variant: push indexes → result stores indexes (needed for distance / width problems)
 *
 * ═══════════════════════════════════════════════════════════════════════════════
 */
public class MonotonicStackTemplates {

    // ═══════════════════════════════════════════════════════════════════════════
    //  1. NEXT GREATER ELEMENT — VALUES
    //     For each arr[i], find the first element GREATER to its RIGHT. Return -1 if none.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse RIGHT to LEFT
     *  → Maintain DECREASING stack (larger values stay, smaller get popped)
     *  → Pop while stack.top() <= arr[i]  (they can never be NGE for arr[i])
     *  → result[i] = stack empty ? -1 : stack.top()
     *  → Push arr[i]
     *
     * Example: arr = [4, 5, 2, 25, 7, 18]
     *          NGE = [5, 25, 25, -1, 18, -1]
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] ngeValues(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores VALUES — decreasing order
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements that are NOT greater than arr[i]
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  2. NEXT GREATER ELEMENT — INDEXES
    //     Same as above but returns INDEX of the NGE element (not the value).
    //     Returns -1 if no NGE exists.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse LEFT to RIGHT
     *  → Maintain DECREASING stack of INDEXES
     *  → While arr[stack.top()] < arr[i]: pop → result[popped] = i  ← i is the NGE index
     *  → Push i
     *  → Remaining in stack → result = -1
     *
     * Example: arr = [4, 5, 2, 25, 7, 18]
     *    NGE idx = [1, 3, 3, -1, 5, -1]
     *              (arr[1]=5, arr[3]=25, arr[5]=18)
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] ngeIndexes(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // default: no NGE found
        Stack<Integer> stack = new Stack<>(); // stores INDEXES — decreasing by value
        for (int i = 0; i < n; i++) {
            // current arr[i] is NGE for all smaller elements waiting in stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }
        // whatever remains in stack has no NGE → result stays -1
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  3. NEXT SMALLER ELEMENT — VALUES
    //     For each arr[i], find the first element SMALLER to its RIGHT. Return -1 if none.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse RIGHT to LEFT
     *  → Maintain INCREASING stack (smaller values stay, larger get popped)
     *  → Pop while stack.top() >= arr[i]  (they can never be NSE for arr[i])
     *  → result[i] = stack empty ? -1 : stack.top()
     *  → Push arr[i]
     *
     * Example: arr = [4, 8, 5, 2, 25]
     *          NSE = [2, 5, 2, -1, -1]
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] nseValues(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores VALUES — increasing order
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements that are NOT smaller than arr[i]
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  4. NEXT SMALLER ELEMENT — INDEXES
    //     Same as above but returns INDEX of the NSE element.
    //     Returns n (array length) if no NSE exists — useful for "right boundary" calculations.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse LEFT to RIGHT
     *  → Maintain INCREASING stack of INDEXES
     *  → While arr[stack.top()] > arr[i]: pop → result[popped] = i  ← i is the NSE index
     *  → Push i
     *  → Remaining in stack → result = n  (no NSE, right boundary is n)
     *
     * Example: arr = [4, 8, 5, 2, 25]  (n=5)
     *    NSE idx = [3, 2, 3,  5, 5]
     *              (arr[3]=2 is NSE of 4,8,5; arr[5]=n means no NSE)
     *
     * ⚠️ Why return n instead of -1?
     *    In problems like "Largest Rectangle" we do: width = right - left - 1
     *    Using n as right boundary makes the formula consistent.
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] nseIndexes(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, n); // default: no NSE → right boundary is n
        Stack<Integer> stack = new Stack<>(); // stores INDEXES — increasing by value
        for (int i = 0; i < n; i++) {
            // current arr[i] is NSE for all larger elements waiting in stack
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  5. PREVIOUS GREATER ELEMENT — VALUES
    //     For each arr[i], find the first element GREATER to its LEFT. Return -1 if none.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse LEFT to RIGHT
     *  → Maintain DECREASING stack (larger values stay, smaller/equal get popped)
     *  → Pop while stack.top() <= arr[i]  (they can never be PGE for arr[i] or anything after)
     *  → result[i] = stack empty ? -1 : stack.top()   ← top IS the PGE
     *  → Push arr[i]
     *
     * Example: arr = [10, 4, 2, 20, 40, 12, 30]
     *          PGE = [-1, 10, 4, -1, -1, 40, 40]
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] pgeValues(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores VALUES — decreasing order
        for (int i = 0; i < n; i++) {
            // Remove elements that CANNOT be PGE for arr[i]
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // top is PGE
            stack.push(arr[i]);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  6. PREVIOUS GREATER ELEMENT — INDEXES
    //     Same as above but returns INDEX of the PGE element. Returns -1 if none.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse LEFT to RIGHT
     *  → Maintain DECREASING stack of INDEXES (by value)
     *  → Pop while arr[stack.top()] <= arr[i]
     *  → result[i] = stack empty ? -1 : stack.top()   ← top index IS the PGE index
     *  → Push i
     *
     * Example: arr = [10, 4, 2, 20, 40, 12, 30]
     *    PGE idx = [-1,  0,  1, -1, -1,  4,  4]
     *              (arr[0]=10, arr[4]=40)
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] pgeIndexes(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>(); // stores INDEXES — decreasing by value
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // top index is PGE index
            stack.push(i);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  7. PREVIOUS SMALLER ELEMENT — VALUES
    //     For each arr[i], find the first element SMALLER to its LEFT. Return -1 if none.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse LEFT to RIGHT
     *  → Maintain INCREASING stack (smaller values stay, larger/equal get popped)
     *  → Pop while stack.top() >= arr[i]  (they can never be PSE for arr[i] or anything after)
     *  → result[i] = stack empty ? -1 : stack.top()   ← top IS the PSE
     *  → Push arr[i]
     *
     * Example: arr = [4, 5, 2, 10, 8]
     *          PSE = [-1, 4, -1, 2, 2]
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] pseValues(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores VALUES — increasing order
        for (int i = 0; i < n; i++) {
            // Remove elements that CANNOT be PSE for arr[i]
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // top is PSE
            stack.push(arr[i]);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  8. PREVIOUS SMALLER ELEMENT — INDEXES
    //     Same as above but returns INDEX of the PSE element. Returns -1 if none.
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * THUMB RULE:
     *  → Traverse LEFT to RIGHT
     *  → Maintain INCREASING stack of INDEXES (by value)
     *  → Pop while arr[stack.top()] >= arr[i]
     *  → result[i] = stack empty ? -1 : stack.top()   ← top index IS the PSE index
     *  → Push i
     *
     * Example: arr = [4, 5, 2, 10, 8]  (n=5)
     *    PSE idx = [-1,  0, -1,  2,  2]
     *              (arr[0]=4, arr[2]=2)
     *
     * ⚠️ Why return -1 instead of -1?
     *    In problems like "Largest Rectangle" we do: width = right - left - 1
     *    Using -1 as left boundary makes the formula consistent.
     *    left[i] = i - pseIndex[i] - 1  →  when pseIndex[i] = -1, left[i] = i
     *
     * Time: O(n) | Space: O(n)
     */
    public int[] pseIndexes(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>(); // stores INDEXES — increasing by value
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // top index is PSE index
            stack.push(i);
        }
        return result;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  QUICK SUMMARY — HOW THE 4 DIRECTIONS COMBINE IN HARD PROBLEMS
    // ═══════════════════════════════════════════════════════════════════════════
    /*
     *  Problem                      → Directions Used
     *  ─────────────────────────────────────────────────────────────
     *  Daily Temperatures           → NGE (index variant → distance = i - popped)
     *  Stock Span                   → PGE (accumulated span trick)
     *  Next Greater Element I/II    → NGE (value variant + map)
     *  Largest Rectangle Histogram  → PSE (left) + NSE (right) → width = R - L - 1
     *  Sum of Subarray Minimums     → PSE (left count) + NSE (right count) → contribution
     *  Sum of Subarray Ranges       → (PGE+NGE for max) - (PSE+NSE for min)
     *  Trapping Rain Water          → PSE/NSE for boundaries (or two-pointer)
     *  Visible People in Queue      → NGE from right (count pops)
     *  Remove K Digits              → Increasing stack (greedy pop)
     *  132 Pattern                  → Decreasing stack from right (track "third")
     *  Asteroid Collision           → Stack with collision logic
     */

    // ═══════════════════════════════════════════════════════════════════════════
    //  MAIN — VERIFY ALL 8 TEMPLATES
    // ═══════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        MonotonicStackTemplates t = new MonotonicStackTemplates();

        System.out.println("=== NGE Values ===");
        System.out.println(Arrays.toString(t.ngeValues(new int[]{4, 5, 2, 25, 7, 18})));
        // Expected: [5, 25, 25, -1, 18, -1]

        System.out.println("=== NGE Indexes ===");
        System.out.println(Arrays.toString(t.ngeIndexes(new int[]{4, 5, 2, 25, 7, 18})));
        // Expected: [1, 3, 3, -1, 5, -1]

        System.out.println("=== NSE Values ===");
        System.out.println(Arrays.toString(t.nseValues(new int[]{4, 8, 5, 2, 25})));
        // Expected: [2, 5, 2, -1, -1]

        System.out.println("=== NSE Indexes ===");
        System.out.println(Arrays.toString(t.nseIndexes(new int[]{4, 8, 5, 2, 25})));
        // Expected: [3, 2, 3, 5, 5]

        System.out.println("=== PGE Values ===");
        System.out.println(Arrays.toString(t.pgeValues(new int[]{10, 4, 2, 20, 40, 12, 30})));
        // Expected: [-1, 10, 4, -1, -1, 40, 40]

        System.out.println("=== PGE Indexes ===");
        System.out.println(Arrays.toString(t.pgeIndexes(new int[]{10, 4, 2, 20, 40, 12, 30})));
        // Expected: [-1, 0, 1, -1, -1, 4, 4]

        System.out.println("=== PSE Values ===");
        System.out.println(Arrays.toString(t.pseValues(new int[]{4, 5, 2, 10, 8})));
        // Expected: [-1, 4, -1, 2, 2]

        System.out.println("=== PSE Indexes ===");
        System.out.println(Arrays.toString(t.pseIndexes(new int[]{4, 5, 2, 10, 8})));
        // Expected: [-1, 0, -1, 2, 2]
    }
}

