package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ProductOfNumbers
 * @Description TODO
 * @Date 2021/2/14 10:59
 * @Created by Administrator
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 * 1. add(int num)
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 *
 */
public class ProductOfNumbers {
    List<Integer> numList;
    int res=1;
    int mark=1;
    public ProductOfNumbers() {
        numList=new ArrayList<>();
    }

    public void add(int num) {
        if(num!=0){
            numList.add(num);
            mark++;
        }else{
            mark=1;
            numList.clear();
        }
    }

    public int getProduct(int k) {
        if(k >= mark)
            return 0;
        int count = 0;
        res = 1;
        for (int i = numList.size() - 1; count < k; i--){
            int cur = (int)numList.get(i);
            if (cur == 0)
                return 0;
            res *= cur;
            count ++;
        }
        return res;

    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println( productOfNumbers.getProduct(2));; // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3));; // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4));; // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2));; // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32

    }
}
