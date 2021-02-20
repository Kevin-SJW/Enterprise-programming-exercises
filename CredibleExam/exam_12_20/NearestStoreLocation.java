package CredibleExam.exam_12_20;

import java.util.Arrays;

/**
 * @Classname NearestStoreLocation
 * @Description TODO
 * @Date 2020/7/17 0:01
 * @Created by Administrator
 * 计算出距离每个安装点最近的供给点位置，并返回供给点位置的列表
 */
public class NearestStoreLocation {
    public static void main(String[] args) {
        int[] stores = {1, 5};
        int[] sites = {5, 10, 18};
        Arrays.stream(dosest(stores, sites)).forEach(t -> System.out.print(t + " "));
//        System.out.println(dist(stores,sites));
    }
    public static int[] dosest(int[] stores, int[] sites) {
        Arrays.sort(stores);
        int[] ans = new int[sites.length];
        for (int i = 0; i < sites.length; i++) {
            int index = Arrays.binarySearch(stores, sites[i]);
            if (index < 0) {
                //1.搜索值不是数组元素，且在数组范围内，从1开始计数，得“-插入点索引值”
                //2.搜索值不是数组元素，且大鱼数组内元素，索引值为-（length）;
                //3.搜索值不是数组元素，且小于数组内元素，索引值为-1；
                index = -index - 1;
                if (index == stores.length) {
                    ans[i] = stores[index - 1];
                    continue;
                }
                if (index >= 1 && (sites[i] - stores[index - 1])
                        <= (stores[index] - sites[i])) {
                    ans[i] = stores[index - 1];
                } else {
                    ans[i] = stores[index];
                }

            } else {
                ans[i] = stores[index];
            }
        }
        return ans;
    }

}
