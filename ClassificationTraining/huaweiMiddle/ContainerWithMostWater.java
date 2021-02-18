package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ContainerWithMostWater
 * @Description TODO
 * @Date 2020/8/23 17:54
 * @Created by Administrator
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }
}
