package weekly;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for (int i = 0; i < targetList.size(); i++) {
            target[i] = targetList.get(i);
        }



        return target;
    }
}
