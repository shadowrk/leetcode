package common;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int toReplace=1;
        for(int i=1; i< nums.length; i++){
            if(nums[i] > nums[i-1]){
                nums[toReplace++] = nums[i];
            }
        }
        return toReplace;
    }
}
