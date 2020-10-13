package weekly.contest186;

public class Problem2 {
    public int maxScore(int[] cardPoints, int k) {
        int l=0, r = 0;
        int l_sum = 0, r_sum = 0;
        int sum = 0;
        int n = 0;
        while(n < k){
            r =  cardPoints.length - 1 - n;
            r_sum += cardPoints[r];
            n ++;
        }
        n -= 1;
        sum = l_sum + r_sum;
        r = cardPoints.length - 1 - n;
        System.out.println(r);
        while (k > 0){
            l_sum += cardPoints[l++];
            r_sum -= cardPoints[r++];
            System.out.println(l_sum+" "+r_sum);
            sum = Math.max(sum, l_sum+r_sum);
            k -= 1;
        }
        return sum;

    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        int[] arr = new int[] {
                100, 40, 17, 9, 73, 75
        };
        System.out.println(p.maxScore(arr, 3));
    }
}
