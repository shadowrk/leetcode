package springseason2020;


import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    private int count = 0;
    public int numWays(int n, int[][] relation, int k) {
//        boolean[] flag = new boolean[n];
//        for (int i = 0; i < flag.length; i++) {
//            flag[i] = false;
//        }
//        dfs(0, n-1, relation, k, flag);
//        return count;

        List<List<Integer>> relations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < relation.length; j++) {
                if(relation[j][0] == i){
                    list.add(relation[j][1]);
                }
            }
            relations.add(i, list);
        }

        dfs(0, n-1, relations, k);

        return count;


    }


    private void dfs(int start, int end, List<List<Integer>> relations, int k){
        if(k == 0 && start == end){
            count += 1;
            return;
        }
        if(k == 0){
            return;
        }
        List<Integer> targets = relations.get(start);
        for (Integer target : targets) {
            dfs(target, end, relations, k-1);
        }
        return;
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        int[][] relation = new int[7][2];
        relation[0] = new int[]{
                0, 2
        };
        relation[1] = new int[]{
                2, 1
        };
        relation[2] = new int[]{
                3, 4
        };
        relation[3] = new int[]{
                2, 3
        };
        relation[4] = new int[]{
                1, 4
        };
        relation[5] = new int[]{
                2, 0
        };
        relation[6] = new int[]{
                0, 4
        };
        System.out.println(p.numWays(5, relation, 3));
    }
}
