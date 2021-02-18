package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname InsertDigit
 * @Description TODO
 * @Date 2021/1/29 21:34
 * @Created by Administrator
 * 两个数字字符串，为score，digit，可将digit插入到score的任意位置（含开头和结尾），
 * 形成一个新的数字字符串，请问所有形成的新数字字符串能表示的最大数字是多少，并返回
 * score含数字0-9，表示数值>0,无前缀；digit含数字0-9，>0,有前缀0，如099
 */
public class InsertDigit {
    public static void main(String[] args) {
        String score = "523";
        String digit = "4";
        System.out.println(insertDigit(score, digit));
    }

    public static int insertDigit(String score, String digit) {
        if (digit.charAt(0) == '0') {
            digit = digit.substring(1);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int digitLen = digit.length();
        for (int i = 0; i < score.length()+digitLen; i++) {
            if (i == 0) {
                sb = sb.append(digit).append(score.substring(i));
            }
            else if (i==score.length()+digitLen-1) {
                sb=sb.append(score).append(digit);
            }
            else {
                sb = sb.append(score.substring(0, i)).append(digit).append(score.substring(i + digitLen - 1));
            }
            res.add(sb.toString());
            sb = new StringBuilder();

        }
        int[] ans= res.stream().mapToInt(Integer::valueOf).toArray();
        List<Integer> result=new ArrayList<>();
        for(int i:ans){
            result.add(i);
        }
        return Collections.max(result);
    }
}
