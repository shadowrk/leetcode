package easylist;

import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length() || s == null || t == null)
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        map1.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        map2.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        for(Map.Entry<Character, Integer> entry : map1.entrySet()){

            if(!map2.containsKey(entry.getKey()) || !entry.getValue().equals(map2.get(entry.getKey())))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("aacc", "ccac"));
    }
}
