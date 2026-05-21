package stacksandqueues.stacks.basics;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * BEST TIME TO BUY AND SELL STOCK — ALL 6 VARIANTS
 * ═══════════════════════════════════════════════════════════════════════════════
 *
 * Pattern: Greedy / DP with states (NOT Monotonic Stack)
 *
 * ┌─────────┬──────────────────────────────────┬──────────────────────────────┐
 * │ Problem │ Constraint                       │ Pattern                      │
 * ├─────────┼──────────────────────────────────┼──────────────────────────────┤
 * │ #121    │ 1 transaction                    │ Track minSoFar               │
 * │ #122    │ Unlimited transactions           │ Greedy (sum positive diffs)  │
 * │ #123    │ At most 2 transactions           │ DP: buy1/sell1/buy2/sell2    │
 * │ #188    │ At most k transactions           │ DP: dp[k][day] with states   │
 * │ #309    │ Unlimited + 1-day cooldown       │ State machine: held/sold/rest│
 * │ #714    │ Unlimited + transaction fee      │ DP: cash/hold states         │
 * └─────────┴──────────────────────────────────┴──────────────────────────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════════
 */
public class StockBuySellProblems {

    // ─────────────────────────────────────────────────────────────────────────
    //  #121 — Best Time to Buy and Sell Stock (Easy) — ONE transaction
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Example: prices = [7,1,5,3,6,4] → 5  (buy at 1, sell at 6)
     * Example: prices = [7,6,4,3,1]   → 0  (no profit possible)
     *
     * Pattern: Track min price so far; profit = price - minSoFar
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitI(int[] prices) {
        // TODO: implement
        return 0;
    }

    // ─────────────────────────────────────────────────────────────────────────
    //  #122 — Best Time to Buy and Sell Stock II (Medium) — UNLIMITED
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Example: prices = [7,1,5,3,6,4] → 7  (buy 1 sell 5, buy 3 sell 6)
     *
     * Pattern: Greedy — sum all positive differences between consecutive days
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitII(int[] prices) {
        // TODO: implement
        return 0;
    }

    // ─────────────────────────────────────────────────────────────────────────
    //  #123 — Best Time to Buy and Sell Stock III (Hard) — AT MOST 2
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Example: prices = [3,3,5,0,0,3,1,4] → 6  (buy 0 sell 3, buy 1 sell 4)
     *
     * Pattern: DP with 4 states — buy1, sell1, buy2, sell2
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitIII(int[] prices) {
        // TODO: implement
        return 0;
    }

    // ─────────────────────────────────────────────────────────────────────────
    //  #188 — Best Time to Buy and Sell Stock IV (Hard) — AT MOST K
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Example: k=2, prices = [2,4,1] → 2
     *
     * Pattern: DP — dp[i][j] = max profit with at most i transactions up to day j
     * Time: O(k×n) | Space: O(k)
     */
    public int maxProfitIV(int k, int[] prices) {
        // TODO: implement
        return 0;
    }

    // ─────────────────────────────────────────────────────────────────────────
    //  #309 — Best Time to Buy and Sell Stock with Cooldown (Medium)
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * After selling, must wait 1 day before buying again.
     * Example: prices = [1,2,3,0,2] → 3  (buy 1 sell 3, cooldown, buy 0 sell 2)
     *
     * Pattern: State machine DP — held, sold, rest
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitCooldown(int[] prices) {
        // TODO: implement
        return 0;
    }

    // ─────────────────────────────────────────────────────────────────────────
    //  #714 — Best Time to Buy and Sell Stock with Transaction Fee (Medium)
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Unlimited transactions but each has a fee.
     * Example: prices = [1,3,2,8,4,9], fee = 2 → 8
     *
     * Pattern: DP — cash (not holding) and hold (holding stock) states
     * Time: O(n) | Space: O(1)
     */
    public int maxProfitFee(int[] prices, int fee) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        StockBuySellProblems s = new StockBuySellProblems();
        System.out.println(s.maxProfitI(new int[]{7, 1, 5, 3, 6, 4}));        // 5
        System.out.println(s.maxProfitII(new int[]{7, 1, 5, 3, 6, 4}));       // 7
        System.out.println(s.maxProfitIII(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(s.maxProfitCooldown(new int[]{1, 2, 3, 0, 2}));    // 3
        System.out.println(s.maxProfitFee(new int[]{1, 3, 2, 8, 4, 9}, 2));   // 8
    }
}

