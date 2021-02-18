package ClassificationTraining.SpringSprint;

import java.util.Arrays;

/**
 * @Classname NumRescueBoats
 * @Description TODO
 * @Date 2021/2/11 17:04
 * @Created by Administrator
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        int[] people = {1, 2};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int low = 0, high = people.length - 1;
        while (low < high) {
            if (people[low] + people[high] <= limit) {
                low++;
            }
            high--;
            res++;
        }
        return res;
    }
}
