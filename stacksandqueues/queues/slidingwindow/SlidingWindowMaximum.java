package stacksandqueues.queues.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ═══════════════════════════════════════════════════════════════
 *  SLIDING WINDOW MAXIMUM — LeetCode #239 | FAANG Frequency: ⭐⭐⭐⭐⭐
 *  Asked at: Amazon, Google, Facebook, Microsoft, Apple
 * ═══════════════════════════════════════════════════════════════
 *
 * Given array nums and window size k, return max in each sliding window.
 *
 * Example:
 *  nums = [1,3,-1,-3,5,3,6,7], k = 3
 *  Windows: [1,3,-1]→3, [3,-1,-3]→3, [-1,-3,5]→5, [-3,5,3]→5,
 *           [5,3,6]→6, [3,6,7]→7
 *  Output: [3,3,5,5,6,7]
 *
 * PATTERN: Monotonic Deque (Decreasing)
 *   - Deque stores INDICES in decreasing order of their values
 *   - Front = max of current window
 *   - Remove front if it's out of window (index < i-k+1)
 *   - Remove back while nums[back] <= nums[i] (can never be max)
 *
 * Time: O(n) | Space: O(k)
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // TODO: implement with monotonic deque
        return new int[]{};
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Sliding Window Minimum (symmetric problem)
    // -----------------------------------------------------------------------

    /**
     * Return min of each sliding window of size k (monotonic increasing deque)
     */
    public int[] minSlidingWindow(int[] nums, int k) {
        // TODO: implement — flip comparison from max version
        return new int[]{};
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Jump Game VI — LeetCode #1696 (Medium)
    // -----------------------------------------------------------------------

    /**
     * You start at index 0 in array nums. In each move, jump at most k steps,
     * collect score of landing position. Maximize total score reaching index n-1.
     *
     * Example: nums = [1,-1,-2,4,-7,3], k = 2 → 7  (1→4→3 = 1+4+3=7? no)
     *          Actually: 0→1→3→5 = 1 + (-1) + 4 + 3 = 7
     * Example: nums = [10,-5,-2,4,0,3], k = 3 → 17  (10+4+3)
     *
     * Pattern: DP + Sliding Window Maximum Deque
     *   dp[i] = nums[i] + max(dp[i-k..i-1])
     * Time: O(n) | Space: O(n)
     */
    public int maxResult(int[] nums, int k) {
        // TODO: implement with DP + deque for O(n)
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Longest Continuous Subarray With Absolute Diff ≤ Limit
    //              LeetCode #1438 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Return longest subarray where abs(a[i] - a[j]) <= limit for all pairs.
     *
     * Example: nums = [8,2,4,7], limit = 4 → 2
     * Example: nums = [10,1,2,4,7,2], limit = 5 → 4  (subarray [2,4,7,2])
     *
     * Pattern: Sliding window + two monotonic deques (one for max, one for min)
     *   Shrink window if max - min > limit
     * Time: O(n) | Space: O(n)
     */
    public int longestSubarray(int[] nums, int limit) {
        // TODO: implement with two deques (maxDeque, minDeque) + two pointers
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 4: Constrained Subsequence Sum — LeetCode #1425 (Hard)
    // -----------------------------------------------------------------------

    /**
     * Find max sum of non-empty subsequence where for any two consecutive
     * indices i < j in the subsequence, j - i <= k.
     *
     * Example: nums = [10,2,-10,5,20], k = 2 → 37  (10+2+5+20)
     * Example: nums = [-1,-2,-3],      k = 1 → -1
     *
     * Pattern: DP + Sliding Window Maximum
     *   dp[i] = nums[i] + max(0, max(dp[i-k..i-1]))
     * Time: O(n) | Space: O(n)
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        // TODO: implement with DP + deque
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 5: First Non-Repeating Character in Stream — (Amazon Classic)
    // -----------------------------------------------------------------------

    /**
     * Given a stream of characters, at each step return the first non-repeating
     * character. Return '#' if none exists.
     *
     * Example: stream = "aabcbc"
     *  After 'a' → 'a'
     *  After 'a' → '#'  (a repeated, no non-repeating)
     *  After 'b' → 'b'
     *  After 'c' → 'b'  (b came before c)
     *  After 'b' → 'c'
     *  After 'c' → '#'
     *
     * Pattern: Queue (insertion order) + frequency map
     *   Queue maintains candidates; poll front while freq[front] > 1
     * Time: O(1) amortized per character | Space: O(1) — at most 26 in queue
     */
    public char[] firstNonRepeatingInStream(String stream) {
        // TODO: implement with queue + int[26] frequency array
        return new char[]{};
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();

        int[] result = swm.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int r : result) System.out.print(r + " "); // 3 3 5 5 6 7
        System.out.println();

        System.out.println(swm.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3)); // 17
        System.out.println(swm.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5)); // 4
    }
}

