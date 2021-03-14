package codinginterviews;

/**
 * @author WRK
 * @date 2021-01-27 14:13
 */
public class DoublePower {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        if(x == 1 || n == 0)
            return 1;
        if(x == -1 && n % 2 == 0)
            return 1;
        else if(x == -1 && n % 2 != 0)
            return -1;
        if(n < -1000)
            return 0;
        if(n < 0 && n != Integer.MIN_VALUE){
            n = -n;
            x = 1/x;
        }
        double result = x;
        for (int i = 1; i < n; i++) {
            result = calculate(result, x);
        }

        return result;
    }

    private double calculate(double x, double y){
        return x * y;
    }

    public static void main(String[] args) {
        DoublePower doublePower = new DoublePower();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(doublePower.myPow(2.00000, -2147483648));
    }
}
