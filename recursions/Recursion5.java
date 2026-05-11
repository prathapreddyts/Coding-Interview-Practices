package recursions;

public class Recursion5 {
    public static void main(String[] args) {

    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return last + secondLast;
    }
}
