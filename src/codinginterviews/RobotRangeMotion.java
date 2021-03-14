package codinginterviews;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WRK
 * @date 2021-01-27 11:26
 */
public class RobotRangeMotion {
    public int movingCount(int m, int n, int k) {
        if(k == 0)
            return 1;

        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        result += 1;
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if(calculate(tx) + calculate(ty) > k || tx >= m || tx < 0 || ty >= n || ty < 0 || visited[tx][ty])
                    continue;

                queue.offer(new int[]{tx, ty});
                System.out.println(tx + ", " + ty);
                visited[tx][ty] = true;
                result ++;
            }
        }

        return result;

    }



    private int calculate(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotRangeMotion motion = new RobotRangeMotion();
        motion.movingCount(2, 3, 1);
    }
}
