package ClassificationTraining.huaweiSimple;

/**
 * @Classname ConvertANumberToHexdecimal
 * @Description TODO
 * @Date 2020/8/23 11:46
 * @Created by Administrator
 */
public class ConvertANumberToHexdecimal {
    public static void main(String[] args) {
        int num=26;
        System.out.println(toHex(num));

    }
    public static String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        char[] hex = "0123456789abcdef".toCharArray();
        while(num != 0){
            result.append(hex[num & 15]);
            //无符号右移
            num >>>= 4;
        }
        return result.reverse().toString();

    }
}
