package recursions.recursionlist.level1;

public class ReversePalindromeString {
    public static void reverseString(int start, int end, char[] arr) {

        if (start >= end) {
            return;
        }
        char tempChar = arr[start];
        arr[start] = arr[end];
        arr[end] = tempChar;

        reverseString(start + 1, end - 1, arr);
    }

    public static boolean isPalindromeString(String usrString, int start, int end) {
        if (start > end) {
            return true;
        }
        return usrString.charAt(start) == usrString.charAt(end) && isPalindromeString(usrString, start + 1, end - 1);
    }
}
