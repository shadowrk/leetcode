package weekly.contest187;

import java.util.*;

public class Problem1 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), map.getOrDefault(path.get(0), 0) + 1);
            map.put(path.get(1), map.getOrDefault(path.get(1), 0) + 1);
        }
        String[] arr = new String[2];
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 1){
                arr[i++] = entry.getKey();
            }
        }
        for (List<String> path : paths) {
            if(path.get(1).equals(arr[0]))
                return arr[0];
            if(path.get(1).equals(arr[1]))
                return arr[1];
        }
        return arr[0];
    }
}
