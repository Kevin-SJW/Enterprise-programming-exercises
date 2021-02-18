package ClassificationTraining.huaweiMiddle;

/**
 * @Classname PartitionDisjoint
 * @Description TODO
 * @Date 2020/12/12 10:24
 * @Created by Administrator
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 */
public class PartitionDisjoint {
    public static void main(String[] args) {
        int[] A = {5, 0, 3, 8, 6};
        int[] A2 = {1, 1, 1, 0, 6, 12};
        int[] A3={1,1};
        System.out.println(partitionDisjoint(A2));
    }

    public static int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = A[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }

        m = A[N-1];
        for (int i = N-1; i >= 0; --i) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i-1] <= minright[i])
                return i;

        throw null;
    }
}
