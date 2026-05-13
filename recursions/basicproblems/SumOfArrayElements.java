package recursions.basicproblems;

public class SumOfArrayElements {
    public int arraySum(int[] nums) {
        return arraySumHelper(0, nums);
    }

    public int arraySumHelper(int index, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        return nums[index] + arraySumHelper(index + 1, nums);
    }
}
