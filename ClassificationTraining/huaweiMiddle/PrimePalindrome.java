package ClassificationTraining.huaweiMiddle;

/**
 * @Classname PrimePalindrome
 * @Description TODO
 * @Date 2020/9/8 23:21
 * @Created by Administrator
 */
public class PrimePalindrome {
    public static void main(String[] args) {
        int N = 13;
        System.out.println(primePalindrome(N));

    }

    public static int primePalindrome(int N) {
        for (; ; ) {
            boolean isPrime = true, isPalindrome = true;
            // 判断是否为素数
            for (int i = 2, len = (int) Math.sqrt(N); i <= len; ++i) {
                if (N % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // 判断是否为回文数
            String cs = String.valueOf(N);
            for (int j = 0, len = cs.length() >> 1; j < len; ++j) {
                if (cs.charAt(j) != cs.charAt(cs.length() - j - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            // 是回文数和素数
            if (isPrime && isPalindrome) {
                return N;
            } else {
                N++;
            }

        }


    }


}
