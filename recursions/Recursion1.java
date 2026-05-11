package recursions;

public class Recursion1 {
    public static int count = 0;

    public static void main(String[] args) {
        printData();
    }

    public static void printData() {
        if (count == 3) {
            return;
        }
        System.out.printf("Hey :Welcome to Recursion 1!\n");
        count++;
        printData();

    }

}
