package ClassificationTraining.huaweiMiddle;

import java.util.Random;

/**
 * @Classname ArrayShuffle
 * @Description TODO
 * @Date 2020/10/5 20:10
 * @Created by Administrator
 */
public class ArrayShuffle {
    int[] origin;
    int[] reshuffle;

    public ArrayShuffle(int[] nums) {
        this.origin = nums.clone();
        this.reshuffle = nums;

    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = reshuffle.length;
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            int a = random.nextInt(len);
            int temp = reshuffle[a];
            reshuffle[a] = reshuffle[i];
            reshuffle[i] = temp;
        }
        return reshuffle;

    }


}
