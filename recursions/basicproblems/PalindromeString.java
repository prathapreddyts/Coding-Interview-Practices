package recursions.basicproblems;

public class PalindromeString {
    public boolean palindromeCheck(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        return str.charAt(start) == str.charAt(end) && isPalindrome(str, start + 1, end - 1);
    }
}
