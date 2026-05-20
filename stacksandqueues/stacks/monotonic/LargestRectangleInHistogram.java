package stacksandqueues.stacks.monotonic;

/**
 * LARGEST RECTANGLE IN HISTOGRAM — LeetCode #84 | FAANG Frequency: ⭐⭐⭐⭐⭐
 * Asked at: Google, Amazon, Facebook, Microsoft
 *
 * Given array of heights (histogram bars of width=1), find the largest rectangle.
 *
 * Example 1: heights = [2,1,5,6,2,3]  → 10  (bars at index 2,3 with height 5)
 * Example 2: heights = [2,4]           → 4
 *
 * Pattern: Monotonic Increasing Stack — pop when current < top, compute area
 * Key: When popping bar i with height h, width = current_index - stack.peek() - 1
 *
 * Time: O(n) | Space: O(n)
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        // TODO: implement with monotonic increasing stack
        // Append 0 at end to flush all remaining bars
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Maximal Rectangle — LeetCode #85 (Hard)
    // Asked at: Amazon, Google, Microsoft
    // -----------------------------------------------------------------------

    /**
     * Given a binary matrix filled with '0' and '1', find the largest rectangle
     * containing only '1's and return its area.
     *
     * Example:
     *  matrix = [["1","0","1","0","0"],
     *            ["1","0","1","1","1"],
     *            ["1","1","1","1","1"],
     *            ["1","0","0","1","0"]]
     *  output = 6
     *
     * Pattern: Build histogram row by row, apply largestRectangleArea on each row
     * Time: O(m*n) | Space: O(n)
     */
    public int maximalRectangle(char[][] matrix) {
        // TODO: implement using LargestRectangleArea as subroutine
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Maximal Square — LeetCode #221 (Medium) [DP variant]
    // -----------------------------------------------------------------------

    /**
     * Find the largest square containing only '1's and return its area.
     *
     * Example:
     *  matrix = [["1","0","1","0","0"],
     *            ["1","0","1","1","1"],
     *            ["1","1","1","1","1"],
     *            ["1","0","0","1","0"]]
     *  output = 4
     *
     * Pattern: DP — dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     * Time: O(m*n) | Space: O(m*n), optimizable to O(n)
     */
    public int maximalSquare(char[][] matrix) {
        // TODO: implement with DP
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Count of Submatrices That Sum to Target — LeetCode #1074 (Hard)
    // -----------------------------------------------------------------------

    /**
     * Given a matrix, return number of submatrices that sum to target.
     *
     * Pattern: Prefix sum rows + hash map for subarray sum equals target
     * Time: O(m^2 * n) | Space: O(n)
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        System.out.println(lr.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(lr.largestRectangleArea(new int[]{2, 4}));              // 4

        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(lr.maximalRectangle(matrix)); // 6
        System.out.println(lr.maximalSquare(matrix));    // 4
    }
}

