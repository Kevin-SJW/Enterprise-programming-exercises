package AutumnRecruitment.chap2;

import java.util.Arrays;

/**
 * @Classname StaticSETofInts
 * @Description TODO
 * @Date 2019/9/28 23:11
 * @Created by 14241
 */
public class StaticSETofInts {
    public static void main(String[] args){
        int[] keys={1,2,3};
        System.out.println(new StaticSETofInts(keys));
    }
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
