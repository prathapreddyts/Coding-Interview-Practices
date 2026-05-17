package recursions.recursionlist.level1;

public class SumOfNNumbers {

    public static int sumOfNnumbers(int n) {
        if (n == 0) {
            return n;
        }
        return n + sumOfNnumbers(n - 1);
    }
}
