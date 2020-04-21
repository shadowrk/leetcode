package springseason2020;

public class Problem3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[][] everydayAttr = new int[increase.length+1][3];
        int C=0, R=0, H=0;
        int index = 0;
        everydayAttr[index++] = new int[]{
                0, 0, 0
        };
        for (int i = 0; i < increase.length; i++) {
            int[] todayAttr = new int[3];
            C+=increase[i][0];
            R+=increase[i][1];
            H+=increase[i][2];
            todayAttr[0] = C;
            todayAttr[1] = R;
            todayAttr[2] = H;
            everydayAttr[index++] = todayAttr;
        }

        int[] result = new int[requirements.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < requirements.length; i++) {
            for (int j = 0; j < everydayAttr.length; j++) {
                if(everydayAttr[j][0] >= requirements[i][0] && everydayAttr[j][1] >= requirements[i][1] && everydayAttr[j][2] >= requirements[i][2]){
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] increase = new int[][]{
                {1, 1, 1}
        };
        int[][] requirements = new int[][]{
                {0, 0, 0}, {1, 1, 1}
        };
        Problem3 p = new Problem3();
        int[] triggerTime = p.getTriggerTime(increase, requirements);
        for (int i : triggerTime) {
            System.out.print(i+" ");
        }
    }
}
