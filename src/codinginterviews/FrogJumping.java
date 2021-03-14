package codinginterviews;

/**
 * @author WRK
 * @date 2020-12-03 20:59
 */
public class FrogJumping {
    public int numWays(int n) {
        if(n == 1 || n == 0)
            return 1;
        int a = 1;
        int b = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = (a + b) % 1000000007;
            a = b;
            b = result;
        }

        return result;
    }

    public static void main(String[] args) {
        FrogJumping frogJumping = new FrogJumping();
        System.out.println(frogJumping.numWays(7));
//        System.out.println(frogJumping.numWays(3));
    }
}
