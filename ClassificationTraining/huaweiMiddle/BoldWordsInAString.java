package ClassificationTraining.huaweiMiddle;

/**
 * @Classname BoldWordsInAString
 * @Description TODO
 * @Date 2020/8/21 0:37
 * @Created by Administrator
 * 字符串中的加粗单词
 * "a<b>abc</b>d"
 */
public class BoldWordsInAString {
    public static void main(String[] args) {
        String[] words = {"ab", "bc"};
        String s = "aabcd";
        System.out.println(boldWords(words, s));
    }

    public static String boldWords(String[] words, String s) {
        boolean[] tempS = new boolean[s.length()];

        for (String word : words) {
            int i = s.indexOf(word);
            int size = word.length();
            while (i != -1) {
                for (int j = i; j < i + size; j++) tempS[j] = true;
                i = s.indexOf(word, i + 1);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < tempS.length; ) {
            if (tempS[i]) {
                sb.append("<b>");
                while (i < tempS.length && tempS[i]) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
