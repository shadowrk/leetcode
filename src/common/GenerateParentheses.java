package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WRK
 * @date 2020-12-16 17:20
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int[] flags = new int[2];
        flags[0] = 0;
        flags[1] = 0;
        StringBuffer str = new StringBuffer();
        backtrack(result, str, flags, n);
        return result;
    }
    private void backtrack(List<String> result, StringBuffer str, int[] flags, int n){
        if(flags[0] == flags[1] && flags[0] == n){
            result.add(str.toString());
            return;
        }
        if(flags[0] < flags[1] || flags[0] > n){
            return;
        }
        flags[0] += 1;
        backtrack(result, str.append("("), flags, n);
        str.deleteCharAt(str.length() - 1);
        flags[0] -= 1;
        flags[1] += 1;
        backtrack(result, str.append(")"), flags, n);
        str.deleteCharAt(str.length() - 1);
        flags[1] -= 1;

        return;
    }

}
