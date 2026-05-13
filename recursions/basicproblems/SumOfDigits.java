package recursions.basicproblems;

public class SumOfDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return addDigits(sumDigits(num));
    }

    private int sumDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + sumDigits(num / 10);
    }
}
