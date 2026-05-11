package recursions;

public class Recursion4 {

    public static void reverserArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverserArray(arr, start + 1, end - 1);
    }

    public static void reverserArray1(int[] arr, int index) {
        if (index >= arr.length / 2) {
            return;
        }

        int temp = arr[index];
        arr[index] = arr[arr.length - index - 1];
        arr[arr.length - index - 1] = temp;

        reverserArray1(arr, index + 1);
    }

    public static boolean isPalindrome(String usrString, int start, int end) {
        if (start >= end) {
            return true;
        }
        return usrString.charAt(start) == usrString.charAt(end) && isPalindrome(usrString, start + 1, end - 1);
    }

    public static boolean isPalindrome2(String str, int index) {

        if (index >= str.length() / 2) {
            return true;
        }

        if (str.charAt(index) != str.charAt(str.length() - index - 1)) {
            return false;
        }

        return isPalindrome2(str, index + 1);
    }
}
