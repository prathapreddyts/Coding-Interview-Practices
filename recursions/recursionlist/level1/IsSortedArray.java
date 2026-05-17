package recursions.recursionlist.level1;

public class IsSortedArray {
    public static boolean isSortedArray(int index, int[] nums) {
        if (index == nums.length - 1) {
            return true;
        }
        // if duplicates are allowed
        return (nums[index] <= nums[index + 1]) && isSortedArray(index + 1, nums);
    }
}
