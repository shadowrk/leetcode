public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0, j=0;
        for(; i<nums.length; i++){
            if(nums[i] == 0){
                continue;
            }else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = new int[] {
                1, 0, 3
        };
        moveZeros.moveZeroes(nums);
        for(int num : nums)
            System.out.print(num + " ");
    }
}
