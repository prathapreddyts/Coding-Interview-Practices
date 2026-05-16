package recursions.implementationProblems;

import java.util.ArrayList;
import java.util.List;


public class PowerSet {
    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        // Base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]); //TAKE
        backtrack(index + 1, nums, current, ans);
        current.remove(current.size() - 1);  //BACKTRACK NOT TAKE
        backtrack(index + 1, nums, current, ans);
    }

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums, current, ans);
        return ans;
    }
}
