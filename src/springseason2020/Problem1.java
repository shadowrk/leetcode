package springseason2020;

public class Problem1 {
    public int minCount(int[] coins) {
        int minCount = 0;
        for (int coin : coins) {
            if(coin % 2 == 0)
                minCount += (coin / 2);
            else
                minCount += (coin / 2 + 1);
        }

        return minCount;

    }
}
