package LeetCodeSimple;

/**
 * @Classname AddBinary
 * @Description TODO
 * @Date 2020/6/26 16:55
 * @Created by Administrator
 * Input: a = "11", b = "1"
 * Output: "100"
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;

        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();

    }
}
