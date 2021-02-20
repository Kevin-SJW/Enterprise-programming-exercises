package AutumnRecruitment.chap1;

/**
 * @Classname ex09
 * @Description TODO
 * @Date 2019/9/15 21:06
 * toBinaryString
 * @Created by 14241
 *
 * version2:
 * String s =" ";
 * for(int n=N;n>0;n/=2){
 *     s=(n%2)+s;
 *         }
 */
public class Ex09 {
    public static String toBinaryString(int value) {
        if (value == 0) {
            return "0";
        }
        int bufLen = 32;
        int index = bufLen;
        char[] result = new char[bufLen];
        do {
            // 使用 & 符合相对除 2 提升一定性能
            result[--index] = (char)('0' + (value & 1));
            value = value >>> 1;
        } while (value != 0);
        return new String(result, index, bufLen - index);
    }

    public static void main(String[] args) {
        int value = -1024;
        System.out.println("value:"+ value + "; result for toBinaryString>>>\r\n\t" + toBinaryString(value));
    }
}

