package stacksandqueues.stacks.monotonic;

/**
 * ONLINE STOCK SPAN — LeetCode #901 | FAANG Frequency: ⭐⭐⭐⭐⭐
 * Asked at: Amazon, Microsoft, Google
 *
 * Design an algorithm that collects daily price quotes for a stock and
 * returns the span of the stock's price for the current day.
 * Span = max consecutive days (ending today) where price <= today's price.
 *
 * Example:
 *  prices = [100, 80, 60, 70, 60, 75, 85]
 *  spans  = [1,   1,  1,  2,  1,  4,  6]
 *
 * Pattern: Monotonic Decreasing Stack of (price, span) pairs
 * Time: O(1) amortized per call | Space: O(n)
 */
public class OnlineStockSpan {

    // -----------------------------------------------------------------------
    // STOCK SPAN (Online — streaming data)
    // -----------------------------------------------------------------------

    public static class StockSpanner {

        public StockSpanner() {}

        /**
         * Returns span of current price.
         * Accumulate spans of all smaller/equal prices below current.
         */
        public int next(int price) {
            // TODO: implement with monotonic stack of (price, accumulated span)
            return 0;
        }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Best Time to Buy and Sell Stock — LeetCode #121 (Easy)
    // -----------------------------------------------------------------------

    /**
     * One transaction allowed. Maximize profit.
     * Example: prices = [7,1,5,3,6,4] → 5  (buy at 1, sell at 6)
     * Example: prices = [7,6,4,3,1]   → 0  (no profit possible)
     *
     * Pattern: Track min so far; profit = price - minSoFar
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitI(int[] prices) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Best Time to Buy and Sell Stock II — LeetCode #122 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Multiple transactions allowed (but can't hold two stocks at once).
     * Example: prices = [7,1,5,3,6,4] → 7  (buy 1 sell 5, buy 3 sell 6)
     *
     * Pattern: Greedy — sum all positive differences between consecutive days
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitII(int[] prices) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Best Time to Buy and Sell Stock III — LeetCode #123 (Hard)
    // -----------------------------------------------------------------------

    /**
     * At most TWO transactions allowed.
     * Example: prices = [3,3,5,0,0,3,1,4] → 6  (buy 0 sell 3, buy 1 sell 4)
     *
     * Pattern: DP with states (buy1, sell1, buy2, sell2)
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitIII(int[] prices) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 4: Best Time to Buy and Sell Stock IV — LeetCode #188 (Hard)
    // -----------------------------------------------------------------------

    /**
     * At most k transactions allowed.
     * Example: k=2, prices = [2,4,1] → 2
     *
     * Pattern: DP — dp[i][j] = max profit using at most i transactions up to day j
     * Time: O(k*n) | Space: O(k*n), optimizable to O(k)
     */
    public int maxProfitIV(int k, int[] prices) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 5: Best Time to Buy and Sell with Cooldown — LeetCode #309
    // -----------------------------------------------------------------------

    /**
     * After selling, must wait 1 day (cooldown) before buying again.
     * Example: prices = [1,2,3,0,2] → 3  (buy 1 sell 3 cooldown buy 0 sell 2)
     *
     * Pattern: State machine DP — held, sold, rest
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitCooldown(int[] prices) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 6: Best Time to Buy and Sell with Transaction Fee — LeetCode #714
    // -----------------------------------------------------------------------

    /**
     * Unlimited transactions but each transaction has a fee.
     * Example: prices = [1,3,2,8,4,9], fee = 2 → 8
     *
     * Pattern: DP — cash and hold states
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitFee(int[] prices, int fee) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        OnlineStockSpan oss = new OnlineStockSpan();
        System.out.println(oss.maxProfitI(new int[]{7, 1, 5, 3, 6, 4}));        // 5
        System.out.println(oss.maxProfitII(new int[]{7, 1, 5, 3, 6, 4}));       // 7
        System.out.println(oss.maxProfitIII(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(oss.maxProfitCooldown(new int[]{1, 2, 3, 0, 2}));    // 3

        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100)); // 1
        System.out.println(spanner.next(80));  // 1
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(70));  // 2
        System.out.println(spanner.next(85));  // 6
    }
}

