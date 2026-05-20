package stacksandqueues.queues.basics;

/**
 * MOVING AVERAGE FROM DATA STREAM — LeetCode #346 | FAANG Frequency: ⭐⭐⭐⭐
 * Asked at: Google, Facebook, Amazon
 *
 * Given a stream of integers and a window size, calculate the moving average
 * of all integers in the sliding window.
 *
 * Example:
 *  MovingAverage(size=3)
 *  next(1) → 1.0
 *  next(10)→ 5.5
 *  next(3) → 4.666...
 *  next(5) → 6.0  (window=[10,3,5])
 *
 * Pattern: Circular buffer (array) or Queue + running sum
 * Time: O(1) per next() call | Space: O(size)
 */
public class MovingAverage {

    public static class MovingAverageWindow {

        public MovingAverageWindow(int size) {}

        public double next(int val) { return 0.0; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Number of Recent Calls — LeetCode #933 (Easy)
    // -----------------------------------------------------------------------

    /**
     * Count recent requests within 3000 ms window.
     * ping(t) = 1 + number of previous pings in [t-3000, t]
     *
     * Example:
     *  ping(1)    → 1
     *  ping(100)  → 2
     *  ping(3001) → 3
     *  ping(3002) → 3  (ping(1) dropped — outside window)
     *
     * Pattern: Queue — add t, poll while front < t-3000
     * Time: O(1) amortized | Space: O(1) amortized
     */
    public static class RecentCounter {

        public RecentCounter() {}

        public int ping(int t) { return 0; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Design Hit Counter — LeetCode #362 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Count hits received in last 5 minutes (300 seconds).
     *
     * Methods:
     *  hit(timestamp)        — record a hit
     *  getHits(timestamp)    — return hits in [timestamp-299, timestamp]
     *
     * Example:
     *  hit(1), hit(2), hit(3)
     *  getHits(4)   → 3
     *  hit(300)
     *  getHits(300) → 4
     *  getHits(301) → 3  (hit at t=1 dropped)
     *
     * Approach 1: Queue — O(1) hit, O(n) getHits worst
     * Approach 2: Circular buffer of 300 buckets — O(1) both ← preferred for FAANG
     *
     * Follow-up: What if hits can arrive out of order (distributed system)?
     * → Use TreeMap<timestamp, count>
     */
    public static class HitCounter {

        public HitCounter() {}

        public void hit(int timestamp) {}

        public int getHits(int timestamp) { return 0; }
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Logger Rate Limiter — LeetCode #359 (Easy)
    // -----------------------------------------------------------------------

    /**
     * Allow printing a message only if it hasn't been printed in last 10 seconds.
     *
     * shouldPrintMessage(timestamp, message):
     *  → true if message not printed in [timestamp-9, timestamp]
     *  → false otherwise
     *
     * Example:
     *  shouldPrintMessage(1,"foo")  → true
     *  shouldPrintMessage(2,"bar")  → true
     *  shouldPrintMessage(3,"foo")  → false  (printed at t=1, within 10s)
     *  shouldPrintMessage(11,"foo") → true   (10s elapsed since t=1)
     *
     * Pattern: HashMap<message, lastTimestamp>
     * Time: O(1) | Space: O(n)
     */
    public static class Logger {

        public Logger() {}

        public boolean shouldPrintMessage(int timestamp, String message) { return false; }
    }

    public static void main(String[] args) {
        MovingAverageWindow ma = new MovingAverageWindow(3);
        System.out.println(ma.next(1));  // 1.0
        System.out.println(ma.next(10)); // 5.5
        System.out.println(ma.next(3));  // 4.666
        System.out.println(ma.next(5));  // 6.0

        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));    // 1
        System.out.println(rc.ping(100));  // 2
        System.out.println(rc.ping(3001)); // 3
        System.out.println(rc.ping(3002)); // 3

        HitCounter hc = new HitCounter();
        hc.hit(1); hc.hit(2); hc.hit(3);
        System.out.println(hc.getHits(4));   // 3
        hc.hit(300);
        System.out.println(hc.getHits(300)); // 4
        System.out.println(hc.getHits(301)); // 3
    }
}

