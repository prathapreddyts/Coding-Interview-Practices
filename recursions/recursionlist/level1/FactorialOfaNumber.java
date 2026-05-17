package recursions.recursionlist.level1;

public class FactorialOfaNumber {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
