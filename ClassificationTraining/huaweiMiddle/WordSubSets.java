package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。
 * 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
 * 你可以按任意顺序以列表形式返回 A 中所有的通用单词。
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * 输出：["facebook","google","leetcode"]
 */
public class WordSubSets {
    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"e", "o"};
        System.out.println(wordSubsets(A, B));
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> list = new ArrayList<>();
        int[] check = new int[26]; // 用于存储 B 中单词字母最大出现次数的数组
        for (String b : B) {
            int[] temp = new int[26]; // 计算单词 b 的各字母数量
            for (int i = 0; i < b.length(); i++) {
                temp[b.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) { // 获取单个字母出现次数的最大值
                check[i] = Math.max(check[i], temp[i]);
            }
        }
        for (String a : A) { // 对 A 中的单词进行遍历，查看是否符合要求
            int[] arr = new int[26];
            for (char c : a.toCharArray()) {
                arr[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (arr[i] < check[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(a);
        }
        return list;
    }
}
