package weekly.contest184;

public class Problem4 {
    public int numOfWays(int n) {
        long patternA = 6;
        long patternB = 6;
        int mod = 1000000007;
        long resultA=patternA, resultB=patternB;
        for(int i=2; i<=n; i++){
            resultA = (patternA*3 % mod + patternB*2 % mod) % mod;
            resultB = (patternA*2 % mod + patternB*2 % mod) % mod;

            patternA = resultA;
            patternB = resultB;

        }

        return (int)(resultA+resultB) % mod;

    }

    public static void main(String[] args) {
        Problem4 p = new Problem4();
        System.out.println(p.numOfWays(5000));
    }
}
