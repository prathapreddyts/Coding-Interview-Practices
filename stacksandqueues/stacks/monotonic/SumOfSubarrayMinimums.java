package stacksandqueues.stacks.monotonic;

/**
 * SUM OF SUBARRAY MINIMUMS — LeetCode #907 | FAANG Frequency: ⭐⭐⭐⭐⭐
 * Asked at: Amazon, Google
 *
 * Given array arr, find the sum of min(b) over every subarray b of arr.
 * Answer may be large, return it modulo 10^9 + 7.
 *
 * Example 1: arr = [3,1,2,4]  → 17
 *   Subarrays: [3]→3, [1]→1, [2]→2, [4]→4, [3,1]→1, [1,2]→1, [2,4]→2,
 *              [3,1,2]→1, [1,2,4]→1, [3,1,2,4]→1 → sum = 17
 *
 * KEY INSIGHT — Contribution Technique:
 *   For each element arr[i] as minimum, count subarrays where arr[i] is min.
 *   Find: left[i] = distance to previous smaller (or equal) element
 *         right[i] = distance to next strictly smaller element
 *   Contribution of arr[i] = arr[i] * left[i] * right[i]
 *
 * Pattern: Monotonic Stack (find Previous Smaller + Next Smaller in single pass)
 * Time: O(n) | Space: O(n)
 */
public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        // TODO: implement with monotonic stack and contribution technique
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Sum of Subarray Ranges — LeetCode #2104 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Sum of (max - min) for every subarray.
     * = Sum of subarray maximums - Sum of subarray minimums
     *
     * Example: nums = [1,2,3] → 4
     *   [1,2]: 2-1=1, [2,3]: 3-2=1, [1,2,3]: 3-1=2 → total = 4
     *
     * Time: O(n) | Space: O(n)
     */
    public long subArrayRanges(int[] nums) {
        // TODO: reuse sumSubarrayMins logic for both min and max
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Number of Visible People in a Queue — LeetCode #1944 (Hard)
    // -----------------------------------------------------------------------

    /**
     * n people stand in a queue. Person i can see person j if:
     *   i < j and max(heights[i+1..j-1]) < min(heights[i], heights[j])
     * Return count of people each person can see.
     *
     * Example: heights = [10,6,8,5,11,9]
     *          output = [3, 1, 2, 1, 1, 0]
     *
     * Pattern: Monotonic decreasing stack
     * Time: O(n) | Space: O(n)
     */
    public int[] canSeePersonsCount(int[] heights) {
        // TODO: implement
        return new int[]{};
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Asteroid Collision — LeetCode #735 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Array of asteroids moving in space. Positive = right, Negative = left.
     * Absolute value = size. On collision, smaller explodes; equal both explode.
     * Find state after all collisions.
     *
     * Example: asteroids = [5,10,-5]      → [5,10]
     * Example: asteroids = [8,-8]          → []
     * Example: asteroids = [10,2,-5]       → [10]
     * Example: asteroids = [-2,-1,1,2]     → [-2,-1,1,2]
     *
     * Pattern: Stack — collisions only happen when top>0 and current<0
     * Time: O(n) | Space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        // TODO: implement
        return new int[]{};
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 4: Remove K Digits — LeetCode #402 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Remove k digits from number string to make it the smallest possible number.
     *
     * Example: num = "1432219", k = 3 → "1219"
     * Example: num = "10200",   k = 1 → "200"
     * Example: num = "10",      k = 2 → "0"
     *
     * Pattern: Monotonic Increasing Stack — pop when current < top and k > 0
     * Trim leading zeros in result
     * Time: O(n) | Space: O(n)
     */
    public String removeKdigits(String num, int k) {
        // TODO: implement
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 5: 132 Pattern — LeetCode #456 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Find if there exists i < j < k such that nums[i] < nums[k] < nums[j].
     *
     * Example: nums = [1,2,3,4]   → false
     * Example: nums = [3,1,4,2]   → true  (1,4,2 forms 132)
     * Example: nums = [-1,3,2,0]  → true
     *
     * Pattern: Iterate from right, monotonic stack tracks potential "3" values,
     *          k (the "2") is the largest value popped below current
     * Time: O(n) | Space: O(n)
     */
    public boolean find132pattern(int[] nums) {
        // TODO: implement
        return false;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums s = new SumOfSubarrayMinimums();
        System.out.println(s.sumSubarrayMins(new int[]{3, 1, 2, 4})); // 17
        System.out.println(s.removeKdigits("1432219", 3));             // 1219
        System.out.println(s.find132pattern(new int[]{3, 1, 4, 2}));  // true

        int[] collision = s.asteroidCollision(new int[]{5, 10, -5});
        for (int c : collision) System.out.print(c + " ");             // 5 10
        System.out.println();
    }
}

