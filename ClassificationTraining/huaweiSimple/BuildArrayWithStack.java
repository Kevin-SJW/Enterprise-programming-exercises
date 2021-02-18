package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 * 请使用下述操作来构建目标数组 target ：
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * 请返回构建目标数组所用的操作序列。题目数据保证答案是唯一的。
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 */
public class BuildArrayWithStack {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        //类似于双指针, 一一对照，如果n里面的数在target里就是 push，
        // 如果不在就是push pop，因为有序递增
        List<String> res = new ArrayList<>();
        int count = 0;
        for(int i=1; i<=target[target.length-1]; i++){
            if(i==target[count]) {
                res.add("Push");
                count++;
            }
            else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}
