package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数
 * （从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 */
public class PrefixDivByFive {
    public static void main(String[] args) {
        int[] A = {0, 1, 1};
        prefixesDivBy5(A).stream().forEach(t -> System.out.println(t + " "));

    }
    private static List<Boolean> prefixesDivByFive(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum * 2 + A[i]) % 5;
            ans.add(sum == 0);
        }
        return ans;
    }

    public static List<Boolean> prefixDivByFive2(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (A[i] * 2 + i) % 5;
            ans.add(sum == 0);
        }
        return ans;
    }

    public static List<List<Integer>> subsets(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : A) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> copyItem = new ArrayList<>(res.get(i));
                copyItem.add(num);
                res.add(copyItem);
            }
        }
        return res;
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum * 2 + A[i]) % 5;
            ans.add(sum == 0);
        }
        return ans;

    }
}
