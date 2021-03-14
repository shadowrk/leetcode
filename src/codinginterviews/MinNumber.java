package codinginterviews;

/**
 * @author WRK
 * @date 2020-12-03 21:26
 */
public class MinNumber {
    public int minArray(int[] numbers) {
        int result = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i+1] < numbers[i]){
                result = numbers[i + 1];
                break;
            }
        }

        return result;
    }
}
