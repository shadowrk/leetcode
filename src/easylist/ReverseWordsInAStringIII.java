package easylist;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        int start = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                reverse(stringBuilder, s.substring(start, i));
                stringBuilder.append(" ");
                start = i + 1;
            }
            if(i == s.length() - 1){
                reverse(stringBuilder, s.substring(start, i));
            }
        }

        return stringBuilder.toString();
    }

    private void reverse(StringBuilder str, String temp) {

        for (int j = temp.length() - 1; j >= 0; j--) {
            str.append(temp.charAt(j));
        }
    }
}
