package common;

import java.util.*;

public class ThreeSumCloest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int cloest = 0;
        int cloestNum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2;i++){                         //Doing length-2, because we want two elems j and k after i.
            int j =i+1;
            int k = nums.length-1;
            while(j<k){

                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target)
                    return sum;
                else if (sum > target)
                    k--;
                else
                    j++;
                int diff = Math.abs(sum - target);
                if(diff < cloestNum){
                    cloestNum = diff;
                    cloest = sum;
                }
            }

        }

        return cloest;
    }

}
