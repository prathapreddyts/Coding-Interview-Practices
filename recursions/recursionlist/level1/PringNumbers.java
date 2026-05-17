package recursions.recursionlist.level1;

public class PringNumbers {
    public static void main(String[] args) {
        print1toN(5);
        printNto1(5);
    }
    public static void print1toN(int n) {
        if (n == 0) {
            System.out.println(n);
            return;
        }
        print1toN(n - 1);
        System.out.println(n);
    }

    public static void printNto1(int n) {
        if (n == 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNto1(n - 1);

    }
}
