package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname BoatsToSavePeople
 * @Description TODO
 * @Date 2020/8/20 0:53
 * @Created by Administrator
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * <p>
 * Each boat carries at most 2 people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person. 
 * (It is guaranteed each person can be carried by a boat.)
 */
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {1, 2};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));

    }

    public static int numRescueBoats(int[] people, int limit) {
        int n = people.length, res = 0, low = 0, high = n - 1;
        Arrays.sort(people);
        while (low <= high) {
            if (people[low] + people[high] <= limit)//将当前最大和最小相加，如果小于限制则上船
            {
                low++;
            }
            high--;
            res++;
        }
        return res;


    }
}
