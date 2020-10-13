package weekly.contest186;

public class Problem1 {
    public int maxScore(String s) {
        int score;
        int lScore = 0, rScore = 0;
        char[] str = s.toCharArray();
        for (int i = 1; i < str.length; i++) {
            if(str[i] == '1')
                rScore ++;
        }
        lScore = str[0] == '0' ? 1 : 0;
        score = lScore + rScore;
        for (int i = 1; i < str.length-1; i++) {
            if(str[i] == '0'){
                lScore ++;
            }
            if(str[i] == '1'){
                rScore --;
            }
            score = Math.max(score, lScore + rScore);


        }

        return score;
    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        System.out.println( p.maxScore("1111"));
    }
}
