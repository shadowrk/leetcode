package codinginterviews;

public class SearchInMatrix {
    /**
     * 二维数组的查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从二维矩阵右上角开始，如果target比矩阵中的值大，那么它只可能在当前行的下方，也就是row+1; 如果target比矩阵中的值小，那么它只能在当前值的左边，也就是col-1;
        if(matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0){
            if(matrix[row][col] < target)
                row ++;
            else if(matrix[row][col] > target)
                col --;
            else
                return true;
        }
        return false;
    }
}