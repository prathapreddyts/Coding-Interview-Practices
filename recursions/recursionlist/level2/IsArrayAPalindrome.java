package recursions.recursionlist.level2;

public class IsArrayAPalindrome {

    public static boolean isPalindromArray(int start, int end, int[] nums) {

        if (start >= end) {
            return true;
        }
        return nums[start] == nums[end] && isPalindromArray(start + 1, end - 1, nums);
    }
}
