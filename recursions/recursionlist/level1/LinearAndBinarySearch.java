package recursions.recursionlist.level1;

public class LinearAndBinarySearch {
    public static int linearSearch(int index, int[] nums, int target) {
        if (index == nums.length) {
            return -1;
        }
        if (nums[index] == target) {
            return index;
        }
        return linearSearch(index + 1, nums, target);
    }

    public static int binarySearch(int start, int end, int target, int[] nums) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }

        return binarySearch(start, end, target, nums);
    }
}
