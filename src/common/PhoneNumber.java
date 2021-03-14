package common;

import java.util.*;

/**
 * @author WRK
 * @date 2020-12-15 10:35
 */
public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Character>> numberAndCharMapping = new HashMap<Character, List<Character>>(){
            {
                put('2', new ArrayList<Character>(){
                    {
                        add('a');
                        add('b');
                        add('c');
                    }
                });
                put('3', new ArrayList<Character>(){
                    {
                        add('d');
                        add('e');
                        add('f');
                    }
                });
                put('4', new ArrayList<Character>(){
                    {
                        add('g');
                        add('h');
                        add('i');
                    }
                });
                put('5', new ArrayList<Character>(){
                    {
                        add('j');
                        add('k');
                        add('l');
                    }
                });
                put('6', new ArrayList<Character>(){
                    {
                        add('m');
                        add('n');
                        add('o');
                    }
                });
                put('7', new ArrayList<Character>(){
                    {
                        add('p');
                        add('q');
                        add('r');
                        add('s');
                    }
                });
                put('8', new ArrayList<Character>(){
                    {
                        add('t');
                        add('u');
                        add('v');
                    }
                });
                put('9', new ArrayList<Character>(){
                    {
                        add('w');
                        add('x');
                        add('y');
                        add('z');
                    }
                });
            }
        };


        return backtrack(result, numberAndCharMapping, new StringBuilder(), digits);

    }

    private List<String> backtrack(List<String> result, Map<Character, List<Character>> mapping, StringBuilder combination, String digits){
        System.out.println(digits);
        if(digits == null || digits.length() == 0)
            result.add(combination.toString());
        else{
            List<Character> characters = mapping.get(digits.charAt(0));
            for (int i = 0; i < characters.size(); i++) {
                combination.append(characters.get(i));

                backtrack(result, mapping, combination, digits.substring(1));
                combination.deleteCharAt(combination.length()-1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        List<String> strings = phoneNumber.letterCombinations("23");
        System.out.printf(Arrays.toString(strings.toArray()));
    }
}
