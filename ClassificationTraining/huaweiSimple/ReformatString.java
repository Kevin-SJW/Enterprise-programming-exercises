package ClassificationTraining.huaweiSimple;

/**
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。字母后面应该跟着数字，
 * 而数字后面应该跟着字母。返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个空字符串 。
 * 输入：s = "a0b1c2"  输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2",
 * "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 */
public class ReformatString {
    public static void main(String[] args) {
        String s = "a0b1c2";
        System.out.println(reformat(s)); }
    public static String reformat(String s) {
        assert s != null;
        int numCount = 0, charCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numCount++;
            } else {
                charCount++; } }
        if (Math.abs(numCount - charCount) > 1) return "";
        int len = s.length();
        char[] cs = new char[len];
        int i = 0, j = 0, index = 0;
        boolean isNum = numCount > charCount;

        while (index < s.length()) {
            if (isNum) {
                while (i < len && !Character.isDigit(s.charAt(i)))
                    i++;
                cs[index++] = s.charAt(i++);
                isNum = !isNum;
            } else {
                while (j < len && Character.isDigit(s.charAt(j))) j++;
                cs[index++] = s.charAt(j++);
                isNum = !isNum;
            }
        }
        return new String(cs);
    }
}
