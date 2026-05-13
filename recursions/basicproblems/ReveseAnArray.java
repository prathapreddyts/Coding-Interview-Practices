package recursions.basicproblems;

public class ReveseAnArray {
    public int[] reverseArray(int[] nums) {
        reverseStringHelper(nums, 0, nums.length - 1);
        return nums;
    }
    public void reverseStringHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
        reverseStringHelper(nums, start+1, end-1);
    }
}
