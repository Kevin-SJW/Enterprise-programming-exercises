package CredibleExam.exam_3_27;

import java.util.Locale;

/**
 * @Classname TLVEncoding2
 * @Description TODO
 * @Date 2020/8/2 15:18
 * @Created by Administrator
 * 输入：
 * "00 00 00 00 00 0a 68 65 6c 4c 6f 20 77 6f 72 64 64"
 * 输出：
 * "T:0,L:10,V:hello word0"
 */
public class TLVEncoding2 {
    public static void main(String[] args) {
//        System.out.println(Integer.valueOf("0a",16));
        String lineStr = "00 00 00 00 00 0a 68 65 6c 4c 6f 20 77 6f 72 64 64";
        System.out.println(parseTlvStream(lineStr));

    }

    public static String parseTlvStream(String lineStr) {
        String[] str = lineStr.split("\\s+");
        int first = Integer.parseInt(str[0] + str[1], 16);
        int second = Integer.parseInt(str[2] + str[3] + str[4] + str[5], 16);
        if (second + 6 > str.length) {
            return String.format(Locale.ROOT, "{T:%d,L:%d,V:%s}",
                    first, second, "Invalid");
        }
        if (second == 0) {
            return String.format(Locale.ROOT, "{T:%d,L:%d,V:%s}",
                    first, second, "");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 6; i < second + 6; i++) {
            int s = Integer.parseInt(str[i], 16);
            if (s >= 65 && s <= 90) {
                sb.append((char) (s + 32));
            } else if (s >= 97 && s <= 122) {
                sb.append((char) (s - 32));
            } else {
                sb.append((char)s);
            }
        }
        return String.format(Locale.ROOT, "{T:%d,L:%d,V:%s}", first, second, sb.toString());


    }
}
