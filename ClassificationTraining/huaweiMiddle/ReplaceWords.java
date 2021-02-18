package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname ReplaceWords
 * @Description TODO
 * @Date 2020/10/4 17:16
 * @Created by Administrator
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 
 * 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 */
public class ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords2(dictionary, sentence));

    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] str = sentence.split("\\s+");
        List<String> sentenceStr = Arrays.asList(str);

        for (int i = 0; i < dictionary.size(); i++) {
            for (int j = 0; j < sentenceStr.size(); j++) {
                if (!sentenceStr.get(j).contains(dictionary.get(i))) {
                    continue;
                } else {
                    sentence = sentence.replace(sentenceStr.get(j), dictionary.get(i));
                }
            }
        }
        return sentence;
    }

    /**
     * 首先将sentence分割，保存到String数组中，
     * 然后遍历该数组，用分割的每个单词与每个词根配对，如果是以该词根开头，则用该词根替换单词
     * 用一个整数k记录替换的词根的长度，遍历得到其他词根与该单词匹配时判断新的词根的长度是否比之前的词根的长度小
     * 时间复杂度为O(nm)
     *
     * @param dictionary
     * @param sentence
     * @return
     */

    public static String replaceWords2(List<String> dictionary, String sentence) {
        String[] strings = sentence.split("\\s+");
        for (int i = 0; i < strings.length; i++) {
            int k = 10000;
            for (String s : dictionary) {
                if (strings[i].startsWith(s) && s.length() < k) {
                    strings[i] = strings[i].replaceAll(strings[i], s);
                    k = s.length();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().trim();

    }
}
