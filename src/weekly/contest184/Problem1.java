package weekly.contest184;

import java.util.*;

public class Problem1 {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                return 0;
            }
        });
        for (int i = 0; i < words.length - 1; i++) {
            for(int j = i+1; j < words.length; j++){
                if(words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        String[] words = new String[] {
                "blue","green","bu"
        };
        List<String> strings = p.stringMatching(words);
        strings.forEach(System.out::println);
    }
}
