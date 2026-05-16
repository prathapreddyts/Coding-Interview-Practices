package recursions.recursionlist.level2;

import java.util.ArrayList;
import java.util.List;


public class MoveAllXtoStringEnd {
    public String moveAllX(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char currentChar = str.charAt(0);
        String remainingString = moveAllX(str.substring(1));
        if (currentChar == 'X') {
            return remainingString + currentChar;
        } else {
            return currentChar + remainingString;
        }

    }

    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        moveZeroesHelper(0, list);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

    public void moveZeroesHelper(int index, List<Integer> nums) {
        if (index >= nums.size()) {
            return;
        }
        if (nums.get(index) == 0) {
            nums.remove(index);
            nums.add(0);
            moveZeroesHelper(index, nums);
        } else {
            moveZeroesHelper(index + 1, nums);
        }
    }

}
