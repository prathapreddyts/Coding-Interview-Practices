package recursions.recursionlist.level1;

public class MaxAndMinElements {
    public static int maxNumber(int index, int nums[]) {
        if (index == nums.length-1) {
            return nums[index];
        }
        int currentMax = maxNumber(index + 1, nums);
        return Math.max(currentMax, nums[index]);

    }
    public static int minNumber(int index, int nums[]) {
        if (index == nums.length-1) {
            return nums[index];
        }
        int currentMin = minNumber(index + 1, nums);
        return Math.min(currentMin, nums[index]);

    }
}
