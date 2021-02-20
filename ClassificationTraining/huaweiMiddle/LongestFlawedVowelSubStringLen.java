package ClassificationTraining.huaweiMiddle;

/**
 * 找出瑕疵字符串的最大长度
 */
public class LongestFlawedVowelSubStringLen {
    static String vowelStr = "aeuioAEUIO";

    public static void main(String[] args) {
        int flaw = 9;
        String input = "abibubebobAbIbUbEbo";
        System.out.println(getLongestFlawedVowelSubStringLen(flaw, input));
    }

    private static int getLongestFlawedVowelSubStringLen(int flaw, String input) {
        input = input.toLowerCase();
        int curFlow = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        char[] chars = input.toCharArray();
        while (right < input.length()) {
            if (!vowelStr.contains(String.valueOf(chars[right]))) {
                curFlow++;//右移过程中，遇到非元音字母，瑕疵度增加
            }
            //瑕疵度过大，此时左侧窗口收缩知道重新满足瑕疵
            while (curFlow > flaw) {
                //遇到非元音字母，左侧收缩，瑕疵减1
                if (!vowelStr.contains(String.valueOf(chars[left++]))) {
                    curFlow--;
                }
            }
            if (left < input.length() && vowelStr.contains(String.valueOf(chars[left]))
                    && vowelStr.contains(String.valueOf(chars[right]))) {
                //更新最大长度
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}
