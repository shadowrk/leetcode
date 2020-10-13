package easylist;

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                Character c = map.get(s.charAt(i));
                if(!c.equals(t.charAt(i)))
                    return false;
            }else
                map.put(s.charAt(i), t.charAt(i));
        }
        List<Character> keys = new ArrayList<>();
        List<Character> values = new ArrayList<>();
        map.forEach((k, v) -> {
            keys.add(k);
            values.add(v);
        });
        return keys.size() == map.keySet().size() && values.size() == new HashSet<Character>(map.values()).size();


    }

    public static void main(String[] args) {
        IsomorphicStrings s = new IsomorphicStrings();
        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "bar"));
        System.out.println(s.isIsomorphic("paper", "title"));
    }
}
