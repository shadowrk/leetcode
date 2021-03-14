package common;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length-1;
        while (i < j){
            int h = Math.min(height[i], height[j]);
            maxWater = Math.max(maxWater, (j - i)*h);
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
                };
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(height));

    }
}
