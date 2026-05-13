package recursions.basicproblems;

import java.util.ArrayList;

public class IsArraySorted {
    public boolean isSorted(ArrayList<Integer> nums) {
        return sortedArrayHelper(nums, 0);
    }

    private boolean sortedArrayHelper(ArrayList<Integer> nums, int index) {

        if (index == nums.size() - 1) {
            return true;
        }

        return nums.get(index) <= nums.get(index + 1)
                && sortedArrayHelper(nums, index + 1);
    }
}
