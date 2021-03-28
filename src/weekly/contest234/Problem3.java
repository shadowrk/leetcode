package weekly.contest234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WRK
 * @date 2021/3/28 11:14
 */
public class Problem3 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        knowledge.forEach(item -> {
            knowledgeMap.put(item.get(0), item.get(1));
        });
        StringBuilder resultBuffer = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if(s.charAt(i) == '('){
                String key = searchKey(i, s);
                resultBuffer.append(knowledgeMap.getOrDefault(key, "?"));
                i += key.length() + 2;
            }else{
                resultBuffer.append(s.charAt(i));
                i ++;
            }
        }

        return resultBuffer.toString();
    }

    private String searchKey(int i, String s){
        for (int j = i+1; j < s.length(); j++) {
            if(s.charAt(j) == ')')
                return s.substring(i+1, j);
        }
        return "";
    }
}
