package ClassificationTraining.huaweiSimple;

/**
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
 * 那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 */
public class maxisumRepeatingSubstring {
    public static void main(String[] args) {
        String sequence = "ababc", word = "ab";
        System.out.println(maxRepeating(sequence, word));
    }

    public static int maxRepeating(String sequence, String word) {
        int res=0;
        if(!isSubstring(word,sequence)){
            return 0;
        }
        int k=1;

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(word);
            String kRepeatStr=sb.toString();
            if(isSubstring(kRepeatStr,sequence)){
                k++;
            }else{
                res=k-1;
            }
        }

        return res;

    }

    public static boolean isSubstring(String s, String str) {
        if (!str.contains(s)) {
            return false;
        }
        return true;

    }
}
