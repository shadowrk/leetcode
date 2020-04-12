package weekly.contest184;


public class Problem2 {
    public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m];
        for (int i = 0; i < p.length; i++) {
            p[i] = i+1;
        }
        int[] result = new int[queries.length];
        int iter = 0;
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            int index = search(p, temp);
            result[iter++] = index;
            p = convert(p, index, temp);
        }

        return result;

    }

    private int[] convert(int[] p, int index, int target) {
        for (int i = index; i > 0; i--) {
            p[i] = p[i-1];
        }
        p[0] = target;
        return p;
    }

    private int search(int[] p, int target) {
        for (int i = 0; i < p.length; i++) {
            if(p[i] == target)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        int[] ints = p.processQueries(new int[]{
                10,7,3,3,9,4,1,4,9,9
        }, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
