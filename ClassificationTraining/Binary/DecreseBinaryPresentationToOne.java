package ClassificationTraining.Binary;

/**
 * @Classname DecreseBinaryPresentationToOne
 * @Description TODO
 * @Date 2020/9/25 23:38
 * @Created by Administrator
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * <p>
 * 如果当前数字为偶数，则将其除以 2 。
 * <p>
 * 如果当前数字为奇数，则将其加上 1 。
 * <p>
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * <p>
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14 
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4 
 * Step 5) 4  是偶数，除 2 得到 2 
 * Step 6) 2  是偶数，除 2 得到 1 
 */
public class DecreseBinaryPresentationToOne {
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));

    }

    public static int numSteps(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0 &&carry == 0) {
                break;
            }
            if (s.charAt(i) - '0' != carry) {
                carry = 1;
                ans += 1;
            }
            ans += 1;
        }
        return ans;
    }
}
//    int step = 0;
//
//        //二进制转换
//        BigInteger b=new BigInteger(s,2);
//        BigInteger one=new BigInteger("1");
//        BigInteger two=new BigInteger("2");
//        while (!b.equals(one)) {
//            BigInteger mod=b.mod(two);
//            if (!mod.equals(one)) {
//                b=b.divide(two);
//            } else {
//                b=b.add(one);
//            }
//            step++;
//        }
//
//        return step;

