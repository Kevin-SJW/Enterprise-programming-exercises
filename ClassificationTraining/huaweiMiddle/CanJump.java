package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CanJump
 * @Description TODO
 * @Date 2020/10/3 17:15
 * @Created by Administrator
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int last = nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last=i;
            }
        }
        return last==0;
    }

}
