public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j=0;
        int temp, counter = 0;
        for(; i<nums.length; i++){
            if(nums[i] == val){
                counter ++;
                continue;
            }else{
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums.length - counter;
    }
}
