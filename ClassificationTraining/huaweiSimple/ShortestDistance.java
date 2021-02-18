package ClassificationTraining.huaweiSimple;

/**
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 */
public class ShortestDistance {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        System.out.println(shortestDistance(words, word1, word2));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0 || word1.equals(word2)) {
            return 0;
        }
        int res = words.length;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }

        }
        return res;
    }
}
