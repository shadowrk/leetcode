package weekly.contest186;

public class Problem4 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int temp  = nums[i];
            int prev = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(j - prev <= k){
                    if(nums[j] > 0){
                        temp += nums[j];
                        prev = j;
                    }
                }
                sum = Math.max(sum, temp);
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                -1, -2, -3
        };
        Problem4 p = new Problem4();
        System.out.println(p.constrainedSubsetSum(arr, 1));
    }
}
