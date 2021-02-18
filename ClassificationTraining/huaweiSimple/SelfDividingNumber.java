package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class SelfDividingNumber {
    public static void main(String[] args) {
        int left = 1, right = 22;
        selfDividingNumbers(left, right).stream()
                .forEach(t -> System.out.print(t + "　"));
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)&&!containsZero(i)) {
                res.add(i);
            }
        }
        return res;
    }
    public static boolean isSelfDividingNumber(int n) {
        if (n == 0) {
            return false;
        }
        List<Integer> div = divide(n);
        for (int i = 0; i < div.size(); i++) {
            if (div.get(i) == 0) {
                continue;
            } else {
                if (n % div.get(i) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean containsZero(int n){
        String s=String.valueOf(n);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                return true;
            }
        }
        return false;
    }
    public static List<Integer> divide(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        String s = String.valueOf(n);
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {  // 判断是否是数字
                    int num = Integer.parseInt(String.valueOf(s.charAt(i)));

                    if(num!=0){
                        res.add(num);
                    }
                }
            }
        }
        return res;
    }

}
