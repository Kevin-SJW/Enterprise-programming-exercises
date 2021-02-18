package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。a
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 * 输入：[3,1,2,4]  输出：17
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 */
public class SumSubArrayMins {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack.empty() && stack.peek().val >= A[i]) {
                Pair pair = stack.pop();
                count += pair.count;
                tmp -= pair.val * pair.count;
            }
            stack.push(new Pair(A[i], count));
            tmp += A[i] * count;
            res += tmp;
            res %= MOD;
        }
        return res;
    }

    public static int sumSubArrayMins2(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int temp = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[i]) {
                Pair pair = stack.pop();
                count += pair.count;
                temp -= pair.val * pair.count;
            }
            stack.push(new Pair(A[i], count));
            temp += A[i] * count;
            res += temp;
            res %= MOD;
        }
        return res;
    }
}

class Pair {
    public int val;
    public int count;

    public Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }

}

//    static Set<List<Integer>> set = new HashSet<>();

//    public static void main(String[] args) {

//        int[] arr = {3, 1, 2, 4};
//        boolean[] booleans = new boolean[arr.length];
//        find(arr, 0, booleans);
//        System.out.println(set);
//        System.out.println(sumSubarrayMins(arr));
//    }
//    public static int sumSubarrayMins2(int[] arr) {
//        boolean[] booleans = new boolean[arr.length];
//        find(arr, 0, booleans);
//        int sum = 0;
//        for (List<Integer> list : set) {
//            sum += getMin(list);
//        }
//        return sum % (1000000007);
//    }
//
//    public static int getMin(List<Integer> list) {
//        if (list.isEmpty()) {
//            return 0;
//        }
//        return list.stream().mapToInt(Integer::valueOf).min().getAsInt();
//    }
//
//    public static void find(int[] arr, int position, boolean[] isIns) {
//        if (position == arr.length) {
//            List<Integer> list = new LinkedList<>();
//            for (int i = 0; i < arr.length; i++) {
//                if (isIns[i]) {
//                    list.add(arr[i]);
//                }
//            }
//            set.add(list);
//        } else {
//            isIns[position] = true;
//            find(arr, position + 1, isIns);
//            isIns[position] = false;
//            find(arr, position + 1, isIns);
//        }
//    }
//}

