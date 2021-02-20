package CredibleExam.exam_12_27;

/**
 * @Classname TLVEncoding
 * @Description TODO
 * @Date 2020/7/19 11:10
 * @Created by Administrator
 * 5421编码和tlv编码
 * 输入：
 * “456”
 * 输出
 * “00 01 00 00 00 02 04 89”
 * 输入
 * “abc”
 * 输出
 * “00 02 00 00 00 03 61 62 63”
 */
public class TLVEncoding {

    //5421编码的十六进制表示
    private static final String[] ENCODER = new String[]{"0", "1", "2", "3", "4", "8", "9", "a", "b", "c"};

    public static void main(String[] args) {
        String str = "456";
        System.out.print(tlvEncoding(str));

    }

    public static String tlvEncoding(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.isEmpty()) {
            return "";
        }
        if (isAllDigits(str)) {
            int len = (str.length() + 1) >> 1;//除2并向上取整
            sb.append("00 01 00 00 00 ").append(String.format("%02x", len));
            boolean isOdd = str.length() % 2 != 0;
            if (isOdd) {
                sb.append(" 0").append(ENCODER[str.charAt(0) - '0']);
            }
            for (int i = 1; i < str.length(); i += 2) {
                sb.append(" ").append(ENCODER[str.charAt(i) - '0']).append(ENCODER[str.charAt(i + 1) - '0']);
            }
        } else {
            sb.append(" 00 02 00 00 00 ").append(String.format("%02x", str.length()));
            for (char c : str.toCharArray()) {
                sb.append(" ").append(Integer.toHexString(c));
            }
        }
        return sb.toString();

    }

    public static boolean isAllDigits(String str) {
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
