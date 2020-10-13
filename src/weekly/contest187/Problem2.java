package weekly.contest187;

public class Problem2 {
    public boolean kLengthApart(int[] nums, int k) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                start = i;
                break;
            }
        }
//        if(start > k)
//            return false;
        int index = start;
        for(int i = index+1; i < nums.length; i++){
            if(nums[i] == 1){
                if(i - start <= k)
                    return false;
                else
                    start = i;
            }
        }

        return true;
    }
}
