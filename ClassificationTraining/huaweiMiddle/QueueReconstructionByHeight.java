package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname QueueReconstructionByHeight
 * @Description TODO
 * @Date 2020/8/28 23:27
 * @Created by Administrator
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people
 * in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Arrays.stream(reconstructQueue(people)).forEach(t ->
                Arrays.stream(t).forEach(p -> System.out.print(p + " ")));
    }

    public static int[][] reconstructQueue(int[][] people) {
        //两数不等，按照左边数降序，两边相等，按照右边数升序
        Arrays.sort(people,(o1,o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int []> list =  new LinkedList<>();
        for(int [] p :people){
            // 把p加到p[1]下标为右边数的位置
            // 高个子先站好位， 矮个子插入到k位置上， 前面肯定有k个高个子，矮个子再插到前面也           满足k的要求
            list.add(p[1],p);
        }
        // 返回新数组，注意设置长度 几行2列
        return list.toArray(new int[list.size()][2]);

    }
}
