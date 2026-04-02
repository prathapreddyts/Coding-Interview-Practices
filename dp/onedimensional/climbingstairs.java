package dp.onedimensional;

public class climbingstairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int prev = 1;   // f(0)
        int prev1 = 1;  // f(1)
        int cur = 0;

        for (int i = 2; i <= n; i++) {
            cur = prev + prev1;
            prev = prev1;
            prev1 = cur;
        }

        return cur;
    }
}
