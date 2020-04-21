package weekly.contest185;

public class Problem1 {
    public String reformat(String s) {
        StringBuilder str = new StringBuilder();
        StringBuilder nStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp >= '0' && temp <= '9'){
                nStr.append(temp);
            }
            if(temp >= 'a' && temp <= 'z'){
                str.append(temp);
            }
        }
        StringBuilder result = new StringBuilder();

        if(Math.abs(str.length() - nStr.length()) == 1 || Math.abs(str.length() - nStr.length()) == 0){
            if(nStr.length() > str.length()){
                int n = 0;
                while (n < str.length()){
                    result.append(nStr.charAt(n));
                    result.append(str.charAt(n));
                    n++;
                }
                result.append(nStr.charAt(nStr.length()-1));
            }
            else if(str.length() > nStr.length()){
                int n = 0;
                while (n < nStr.length()){
                    result.append(str.charAt(n));
                    result.append(nStr.charAt(n));
                    n++;
                }
                result.append(str.charAt(str.length()-1));
            }else{
                int n = 0;
                while (n < nStr.length()){
                    result.append(str.charAt(n));
                    result.append(nStr.charAt(n));
                    n++;
                }
            }

            return result.toString();
        }
        return "";

    }

}
