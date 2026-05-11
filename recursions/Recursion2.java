package recursions;

public class Recursion2 {
    public static void main(String[] args) {
        pringNto1AsTail(0, 3);
    }

    public static void printName(int count, int n) {
        if (count == n) {
            return;
        }
        System.out.println("Welcome to recursion");
        count++;
        printName(count, n);
    }

    public static void pring1toN(int n, int counter) {
        if (n == counter) {
            return;
        }
        System.out.println(counter);
        counter++;
        pring1toN(n, counter);
    }

    public static void print1toNAsTail(int n, int counter) {
        if (n == counter) {
            return;
        }
        n = n - 1;
        print1toNAsTail(n, counter);
        System.out.println(n);
    }

    public static void pringNto1(int n, int counter) {
        if (n == counter) {
            return;
        }
        counter++;
        pringNto1(n, counter);
        System.out.println(counter);

    }
    public static void pringNto1AsTail(int n, int counter) {
        if (n == counter) {
            return;
        }
        n=n+1;
        pringNto1AsTail(n, counter);
        System.out.println(n);

    }
}
