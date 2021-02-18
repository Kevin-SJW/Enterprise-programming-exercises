package ClassificationTraining.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ShortestToChar
 * @Description TODO
 * @Date 2020/9/25 0:13
 * @Created by Administrator
 * 给定一个字符串 S 和一个字符 C。
 * 返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class ShortestToChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        Arrays.stream(shortestToChar(s, c)).forEach(t -> System.out.print(t + " "));
//        System.out.println(shortestToChar(s,c));
    }

    public static int[] shortestToChar(String s, char c) {
        List<Integer> index = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                index.add(i);
            }
        }
        int[] indexArray = new int[index.size()];
        for (int i = 0; i < index.size(); i++) {
            indexArray[i] = index.get(i);
        }

        for (int i = 0; i < s.length(); i++) {
            int[] temp=new int[indexArray.length];
            for (int j = 0; j < indexArray.length; j++) {
                temp[j]=Math.abs(i-indexArray[j]);
            }
            res.add(Arrays.stream(temp).min().getAsInt());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
