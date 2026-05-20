package stacksandqueues.queues.design;

import java.util.PriorityQueue;

/**
 * TASK SCHEDULER — LeetCode #621 | FAANG Frequency: ⭐⭐⭐⭐⭐
 * Asked at: Amazon, Facebook, Google
 *
 * Given tasks (list of chars) and cooldown n, find minimum intervals
 * for CPU to execute all tasks. CPU can be idle if no valid task.
 *
 * Example 1: tasks = ["A","A","A","B","B","B"], n = 2
 *   → 8  (A→B→idle→A→B→idle→A→B)
 *
 * Example 2: tasks = ["A","A","A","B","B","B"], n = 0
 *   → 6  (no cooldown)
 *
 * Example 3: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 *   → 16
 *
 * APPROACH 1: Math/Greedy — O(n) time
 *   maxCount = frequency of most frequent task
 *   minTime = (maxCount - 1) * (n + 1) + (count of tasks with freq == maxCount)
 *   answer = max(minTime, tasks.length)
 *
 * APPROACH 2: Simulation with Max Heap + Queue — O(n log 26) = O(n)
 *   Max heap for next available task; queue tracks cooldown
 */
public class TaskScheduler {

    /** Math/Greedy approach — O(n) */
    public int leastInterval(char[] tasks, int n) {
        // TODO: implement with frequency count and formula
        return 0;
    }

    /** Simulation with Max Heap — good for follow-up variations */
    public int leastIntervalSimulation(char[] tasks, int n) {
        // TODO: implement with PriorityQueue (max heap) + cooldown Queue
        // Each cycle: pick top task, decrement count, add to cooldown queue
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Reorganize String — LeetCode #767 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Rearrange string so no two adjacent characters are the same.
     * Return "" if impossible.
     *
     * Example: s = "aab" → "aba"
     * Example: s = "aaab"→ ""
     *
     * Rule: Impossible if maxFreq > ceil(n/2)
     * Pattern: Max heap (greedy pick most frequent at each step)
     * Time: O(n log 26) = O(n) | Space: O(26)
     */
    public String reorganizeString(String s) {
        // TODO: implement with max heap
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Rearrange String k Distance Apart — LeetCode #358 (Hard)
    // -----------------------------------------------------------------------

    /**
     * Rearrange so same characters are at least k apart.
     * Return "" if impossible.
     *
     * Example: s = "aabbcc", k = 3 → "abcabc"
     * Example: s = "aaabc",  k = 3 → ""
     *
     * Pattern: Max heap + cooldown queue of size k
     * Time: O(n log 26) = O(n)
     */
    public String rearrangeString(String s, int k) {
        // TODO: implement — generalization of TaskScheduler
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Find the Order of Characters (Alien Dictionary-like)
    //              Process with Queue — BFS Topological Sort
    // -----------------------------------------------------------------------

    /**
     * Given list of tasks with prerequisites, find minimum time to finish all.
     * Each task takes 1 unit. Tasks without prerequisites can start immediately.
     *
     * Example: n=6, relations=[[5,2],[5,3],[3,1],[3,4]], time=[1,2,3,4,5,6]
     *   → minimum time considering parallelism
     *
     * Pattern: BFS (Kahn's Algorithm) + topological order + longest path in DAG
     */
    public int minimumTime(int n, int[][] relations, int[] time) {
        // TODO: implement with BFS topological sort tracking max time
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 4: Dota2 Senate — LeetCode #649 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Two parties (R, D) take turns banning opponents or declaring victory.
     * Each senator can either ban one opponent's right or declare win if no opponents.
     * Simulate and return which party wins.
     *
     * Example: senate = "RD"   → "Radiant"
     * Example: senate = "RDD"  → "Dire"
     *
     * Pattern: Two queues (one for R indices, one for D indices)
     *   Compare front of both — smaller index wins, loser is removed,
     *   winner re-enqueued with index += n
     * Time: O(n) | Space: O(n)
     */
    public String predictPartyVictory(String senate) {
        // TODO: implement with two queues
        return "";
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(
            new char[]{'A','A','A','B','B','B'}, 2)); // 8
        System.out.println(ts.reorganizeString("aab"));   // aba
        System.out.println(ts.rearrangeString("aabbcc", 3)); // abcabc
        System.out.println(ts.predictPartyVictory("RDD")); // Dire
    }
}

