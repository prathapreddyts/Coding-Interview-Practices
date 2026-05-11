package recursions;

public class Recursion3 {
    public static void main(String[] args) {
        int sumOfN = sumofN(3);
        System.out.println(sumOfN);
    }

    public static int sumofN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumofN(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
