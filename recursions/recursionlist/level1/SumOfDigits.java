package recursions.recursionlist.level1;

public class SumOfDigits {
    public static int sumOfDigits(int n) {
        if (n <= 9) {
            return n;
        }
        return n % 10 + sumOfDigits(n / 10);
    }
}
