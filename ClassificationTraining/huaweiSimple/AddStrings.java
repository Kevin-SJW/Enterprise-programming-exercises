package ClassificationTraining.huaweiSimple;

/**
 * @Classname AddStrings
 * @Description TODO
 * @Date 2020/9/13 14:52
 * @Created by Administrator
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "34";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 ) {

            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';

            int sum = x + y + carry;
            sb.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        if(carry!=0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
