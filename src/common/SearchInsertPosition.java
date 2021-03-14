package common;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
            else
                return mid;
        }
        if(nums[left] < target){
           return left + 1;
        }
        else
            return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{
                1, 3, 5, 6
        }, 7));
    }
}
