import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            String temp = String.valueOf((i == s.length() - 1 ? s.charAt(i) : s.charAt(i)+""+s.charAt(i+1)));
            System.out.println(temp);
            if(map.containsKey(temp)){
                result += map.get(temp);
                i += temp.length();
            }else{
                result += map.get(String.valueOf(s.charAt(i)));
                i ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("IV"));

    }
}
