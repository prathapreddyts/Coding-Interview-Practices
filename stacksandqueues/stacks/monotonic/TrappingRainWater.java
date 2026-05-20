package stacksandqueues.stacks.monotonic;

/**
 * TRAPPING RAIN WATER — LeetCode #42 | FAANG Frequency: ⭐⭐⭐⭐⭐
 * Asked at: Amazon, Google, Facebook, Apple, Microsoft
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1: height = [0,1,0,2,1,0,1,3,2,1,2,1] → 6
 * Example 2: height = [4,2,0,3,2,5]              → 9
 *
 * Constraints: n == height.length, 0 <= n <= 3*10^4
 *
 * THREE APPROACHES — know all three for FAANG:
 */
public class TrappingRainWater {

    // -----------------------------------------------------------------------
    // APPROACH 1: Pre-compute prefix max / suffix max arrays
    // Time: O(n) | Space: O(n)
    // -----------------------------------------------------------------------

    public int trapPrefixSuffix(int[] height) {
        // For each index: water[i] = min(maxLeft[i], maxRight[i]) - height[i]
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // APPROACH 2: Monotonic Stack — useful when you think "width of container"
    // Time: O(n) | Space: O(n)
    // -----------------------------------------------------------------------

    public int trapStack(int[] height) {
        // Pop when current > top, compute horizontal water layer by layer
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // APPROACH 3: Two Pointers — O(1) space (OPTIMAL — preferred at FAANG)
    // Time: O(n) | Space: O(1)
    // -----------------------------------------------------------------------

    public int trap(int[] height) {
        // left and right pointers, track maxLeft and maxRight
        // Move the pointer with smaller max inward
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Container With Most Water — LeetCode #11 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Find two lines that together with x-axis forms a container holding max water.
     * You may not slant the container. Line width is 1.
     *
     * Example: height = [1,8,6,2,5,4,8,3,7] → 49
     *
     * Key insight: area = min(h[l], h[r]) * (r - l)
     * Always move the pointer with smaller height inward.
     *
     * Time: O(n) | Space: O(1)
     */
    public int maxArea(int[] height) {
        // TODO: two pointer approach
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Trapping Rain Water II — LeetCode #407 (3D) (Hard)
    // -----------------------------------------------------------------------

    /**
     * Given m x n matrix of heights, return total water it can trap.
     *
     * Example:
     *  heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
     *  output = 4
     *
     * Pattern: Min-Heap (Priority Queue) — BFS from boundary inward (Dijkstra-like)
     * Time: O(m*n*log(m*n)) | Space: O(m*n)
     */
    public int trapRainWater(int[][] heightMap) {
        // TODO: implement with min-heap
        return 0;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        System.out.println(trw.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(trw.trap(new int[]{4, 2, 0, 3, 2, 5}));                    // 9
        System.out.println(trw.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));        // 49
    }
}

