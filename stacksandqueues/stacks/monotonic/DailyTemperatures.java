package stacksandqueues.stacks.monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ═══════════════════════════════════════════════════════════════
 * MONOTONIC STACK — THE MOST IMPORTANT FAANG STACK PATTERN
 * ═══════════════════════════════════════════════════════════════
 * <p>
 * A Monotonic Stack maintains elements in increasing or decreasing order.
 * <p>
 * KEY INSIGHT:
 * "When does an element get popped?" → when the NEXT GREATER (or smaller)
 * element is found. That's the answer for the popped element.
 * <p>
 * Template (Next Greater Element):
 * for each element:
 * while stack not empty AND stack.top() < current:
 * answer[stack.pop()] = current   ← current is NGE for popped element
 * stack.push(current index)
 * <p>
 * ═══════════════════════════════════════════════════════════════
 * <p>
 * DAILY TEMPERATURES — LeetCode #739 | FAANG Frequency: ⭐⭐⭐⭐⭐
 * <p>
 * Given array temperatures, return array answer where answer[i] is number
 * of days until a warmer temperature. If no future warmer day, answer[i] = 0.
 * <p>
 * Example: temperatures = [73,74,75,71,69,72,76,73]
 * output        = [1, 1, 4, 2, 1, 1, 0, 0]
 * <p>
 * Pattern: Monotonic Decreasing Stack of indices
 * Time: O(n) | Space: O(n)
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty()
                    && temperatures[i] >
                    temperatures[monotonicStack.peek()]) {
                int index = monotonicStack.pop();
                result[index] = i - index;
            }
            monotonicStack.push(i);
        }
        return result;
    }
    // -----------------------------------------------------------------------
    // NEXT GREATER ELEMENT I — LeetCode #496 | FAANG Frequency: ⭐⭐⭐⭐⭐
    // -----------------------------------------------------------------------

    /**
     * nums1 is subset of nums2. For each element in nums1, find its
     * next greater element in nums2. Return -1 if none exists.
     * <p>
     * Example: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * output = [-1, 3, -1]
     * <p>
     * Pattern: Process nums2 with monotonic stack + HashMap for O(n) lookup
     * Time: O(n+m) | Space: O(n)
     */
    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> monotonicStack = new Stack<>();
        int[] nge = new int[len];
        Arrays.fill(nge, -1);
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty()
                    && nums2[i] > nums2[monotonicStack.peek()]) {
                nge[monotonicStack.pop()] = nums2[i];
            }
            monotonicStack.push(i);
        }
        for (int i = 0; i < len; i++) {
            ngeMap.put(nums2[i], nge[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.get(nums1[i]);
        }
        return result;
    }
    // -----------------------------------------------------------------------
    // NEXT GREATER ELEMENT II (Circular) — LeetCode #503 | ⭐⭐⭐⭐⭐
    // -----------------------------------------------------------------------

    /**
     * Circular array — the next element of last element is the first element.
     * Find next greater number for every element.
     * <p>
     * Example: nums = [1,2,1]
     * output = [2,-1,2]
     * <p>
     * Trick: Iterate 2*n (simulate circular), use i % n for index
     * Time: O(n) | Space: O(n)
     */
    public int[] nextGreaterElementsCircularIndex(int[] nums) {
        int len = nums.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] ngeResult = new int[len];
        Arrays.fill(ngeResult, -1);
        for (int i = 0; i < 2 * len; i++) {
            int circularIndex = i % len;
            while (!monotonicStack.isEmpty()
                    && nums[circularIndex] >
                    nums[monotonicStack.peek()]) {
                ngeResult[monotonicStack.pop()]
                        = nums[circularIndex];
            }
            if (i < len) {
                monotonicStack.push(circularIndex);
            }
        }
        return ngeResult;
    }

    public int[] nextGreaterElementsValue(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int circularIndex = i % n;
            while (!monotonicStack.isEmpty()
                    && monotonicStack.peek() <= nums[circularIndex]) {
                monotonicStack.pop();
            }
            if (i < n) {
                result[circularIndex] =
                        monotonicStack.isEmpty()
                                ? -1
                                : monotonicStack.peek();
            }
            monotonicStack.push(nums[circularIndex]);
        }
        return result;
    }
    // -----------------------------------------------------------------------
    // NEXT GREATER ELEMENT III — LeetCode #556 | ⭐⭐⭐
    // -----------------------------------------------------------------------

    /**
     * Given integer n, find smallest integer > n using same digits.
     * Return -1 if impossible or result overflows int.
     * <p>
     * Example: n = 12  → 21
     * Example: n = 21  → -1
     * <p>
     * Pattern: Next permutation — find rightmost descent, swap, reverse suffix
     */
    public int nextGreaterElementIII(int n) {
        // TODO: implement
        return 0;
    }
    // -----------------------------------------------------------------------
    // PREVIOUS SMALLER ELEMENT (custom — asked at Google/Amazon)
    // -----------------------------------------------------------------------

    /**
     * For each element, find the nearest previous element that is smaller.
     * Return -1 if none.
     * <p>
     * Example: arr = [4, 5, 2, 10, 8]
     * output = [-1, 4, -1, 2, 2]
     * <p>
     * Pattern: Monotonic Increasing Stack
     */
    public int[] previousSmallerElement(int[] arr) {
        int len = arr.length;
        int[] pse = new int[len];
        Arrays.fill(pse, -1);
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty()
                    && arr[monotonicStack.peek()] >= arr[i]) {
                monotonicStack.pop();
            }
            pse[i] = monotonicStack.isEmpty()
                    ? -1
                    : arr[monotonicStack.peek()];
            monotonicStack.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temps);
        for (int r : result) System.out.print(r + " "); // 1 1 4 2 1 1 0 0
        System.out.println();
        int[] nge = dt.nextGreaterElementsCircularIndex(new int[]{1, 2, 1});
        for (int r : nge) System.out.print(r + " "); // 2 -1 2
        System.out.println();
    }
}

