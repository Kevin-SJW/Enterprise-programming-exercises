package ClassificationTraining.huaweiSimple;

/**
 * @Classname CalculateTime
 * @Description TODO
 * @Date 2020/8/22 0:44
 * @Created by Administrator
 */
public class CalculateTime {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba";
        System.out.println(calculateTime(keyboard, word));
    }

    public static int calculateTime(String keyboard, String word) {
        int index = -1;
        int time = 0, prev = 0;
        for (int i = 0; i < word.length(); i++) {
            index = keyboard.indexOf(word.charAt(i));
            time += Math.abs(index - prev);
            prev = index;
        }
        return time;
    }
}
