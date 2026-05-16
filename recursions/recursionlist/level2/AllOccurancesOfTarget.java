package recursions.recursionlist.level2;

import java.util.ArrayList;
import java.util.List;


public class AllOccurancesOfTarget {

    public static List<Integer> findAllOccurrences(int index, int target, int[] nums) {
        if (index == nums.length) {
            return new ArrayList<>();
        }
        List<Integer> answerFromBelowLevels = findAllOccurrences(index + 1, target, nums);
        if (nums[index] == target) {
            answerFromBelowLevels.add(0, index);
        }
        return answerFromBelowLevels;
    }

    public void findAllOccurrencesMethod2(int index, int target, int[] nums, List<Integer> result) {

        if (index == nums.length) {
            return;
        }
        if (nums[index] == target) {
            result.add(index);
        }
        findAllOccurrencesMethod2(index + 1, target, nums, result);
    }
}
