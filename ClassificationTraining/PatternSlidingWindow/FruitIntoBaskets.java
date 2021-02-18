package ClassificationTraining.PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FruitIntoBaskets
 * @Description TODO
 * @Date 2020/7/19 20:17
 * @Created by Administrator
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * <p>
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * <p>
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * <p>
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * <p>
 * What is the total amount of fruit you can collect with this procedure?
 * <p>
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] tree = {1, 2, 1};
        System.out.println(totalFruit(tree));
    }

    public static int totalFruit(int[] tree) {
        int res = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < tree.length) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            right++;
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) {
                    map.remove(tree[left]);
                }
                left++;
            }
            res = Math.max(res, right - left);

        }
        return res;
    }

}
