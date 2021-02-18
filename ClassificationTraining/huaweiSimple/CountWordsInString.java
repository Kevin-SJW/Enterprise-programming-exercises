package ClassificationTraining.huaweiSimple;

/**
 * @Classname CountWordsInString
 * @Description TODO
 * @Date 2020/10/3 20:12
 * @Created by Administrator
 */
public class CountWordsInString {
    public static void main(String[] args) {
        String s = "Hello, my name is John";
        System.out.println(countSegments2(s));

    }

    public static int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;

    }

    public static int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

}
