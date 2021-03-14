package codinginterviews;

/**
 * @author WRK
 * @date 2021-01-27 15:25
 */
public class AdjustPosition {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if(nums[left] % 2 == 0 && nums[right] % 2 != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }else if(nums[left] % 2 == 0 && nums[right] % 2 == 0){
                right --;
            }else if(nums[left] % 2 != 0 && nums[right] % 2 != 0){
                left ++;
            }else{
                left ++;
                right --;
            }
        }
        return nums;
    }
}
