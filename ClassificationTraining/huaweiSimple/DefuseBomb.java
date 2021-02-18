package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * 输入：code = [5,7,1,4], k = 3  输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。
 * 注意到数组是循环连接的。
 */
public class DefuseBomb {
    public static void main(String[] args) {
        int[] code = {2,4,9,3};
        int k = -2;
        Arrays.stream(decrypt(code, k)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                for (int j = 1; j <= k; j++) {
                    ans[i] += code[(i + j) % code.length];
                }
            }
        } else if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                for (int j = k; j <= -1; j++) {
                    ans[i] += code[(i + j + code.length) % code.length];
                }
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                ans[i] = 0;
            }
        }
        return ans;
    }
}
