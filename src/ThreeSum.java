import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> threeSumSet  = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2;i++){                         //Doing length-2, because we want two elems j and k after i.
            int j =i+1;

            int k = nums.length-1;

            while(j<k){

                int sum = nums[i]+nums[j]+nums[k];

                if(sum==0){
                    threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                }
                else if (sum > 0){
                    k--;
                }
                else if (sum < 0){
                    j++;
                }
            }

        }

        return new ArrayList<>(threeSumSet);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{
                -1, 0, 1, 2, -1, -4
        });
        for (List<Integer> list : lists) {
            System.out.println(list.toArray());
        }
    }
}
