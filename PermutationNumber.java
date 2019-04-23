import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname PermutationNumber
 * @Description TODO
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @Date 2019/4/23 10:49
 * @Created by 14241
 */
public class PermutationNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] str = line.split("\\s");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        /*List<Integer> 转 int[]*/
        int[] num = list.stream().mapToInt(Integer::valueOf).toArray();
        lists = (permute(num));
        for (Object number : lists) {
            System.out.println(number);
        }


    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> array = new ArrayList<>();


        int n = nums.length;
        backtracking(list, array, 0, n, nums);
        return list;
    }

    public static void backtracking(List<List<Integer>> list, List<Integer> array, int t, int n, int[] nums) {
        if (t > n) {
            return;
        } else if (t == n) {
            list.add(new ArrayList<>(array));
        } else {
            for (int i = 0; i < n; i++) {
                if ((!array.contains(nums[i]))) {
                    array.add(nums[i]);
                    backtracking(list, array, t + 1, n, nums);
                    array.remove(array.size() - 1);
                }
            }
        }
    }
}
