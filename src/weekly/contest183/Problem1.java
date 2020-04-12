package weekly.contest183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Problem1 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int total = Arrays.stream(nums).reduce((a, b)->a+b).getAsInt();
        result.add(nums[nums.length-1]);
        for(int i=nums.length-2; i>=0; i--){
            int r = result.stream().reduce((a, b) -> a+b).get();
            if(r > total-r) break;
            result.add(nums[i]);
        }

        return result;
        

    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        List<Integer> list = p.minSubsequence(new int[]{
            3, 5, 7, 1, 5
        });
        list.forEach(System.out::println);
    }

}