package recursions;

import java.util.ArrayList;
import java.util.List;

public class Recursion6 {
    public void subsequence(int index, List<Integer> subseq, int[] arr) {
        if (subseq.size() == index) {
            System.out.println(subseq);
            return;
        }
        subseq.add(arr[index]);
        subsequence(index + 1, subseq, arr);
        subseq.remove(subseq.size() - 1);
        subsequence(index + 1, subseq, arr);
    }


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

    private void backtrackWithLoop(int start, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                          // CHOOSE
            backtrackWithLoop(i + 1, nums, current, ans); // EXPLORE
            current.remove(current.size() - 1);            // UN-CHOOSE (backtrack)
        }
    }

    public List<List<Integer>> powerSetWithLoop(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrackWithLoop(0, nums, current, ans);
        return ans;
    }

}
