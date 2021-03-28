package weekly.contest234;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author WRK
 * @date 2021/3/28 10:31
 */
public class Problem1 {
    /**
     * 使用滑动窗口判断
     * @param word
     * @return
     */
    public int numDifferentIntegers(String word) {
        int start = -1;
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                chars[i] = ' ';
                start = i;
            }
        }
        Set<String> result = new HashSet<>();
        String temp = new String(chars);
        String[] s = temp.split(" ");
        Arrays.stream(s).forEach(item -> {
            if(item.length() > 0){
                while (item.charAt(0) == '0' && item.length() > 1){
                    item = item.substring(1);
                }
                result.add(item);
            }
        });
        return result.size();
    }

    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        System.out.println(p1.numDifferentIntegers("0a0"));
        System.out.println(p1.numDifferentIntegers("a123bc34d8ef34"));

    }
}
