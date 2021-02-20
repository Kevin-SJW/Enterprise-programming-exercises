package AutumnRecruitment;

import java.util.*;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/9/29 21:26
 * @Created by 14241
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        String str = sc.nextLine();
        String[] scores = str.split("\\s");

        for (String score : scores) {
            String[] data = score.split(":");
            map.put(data[0], Integer.valueOf(data[1]));
        }
        //对成绩排序
        //这里将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
        //升序排序
//        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        //升序排序
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> mapping : list) {
            System.out.print(mapping.getKey() + ":" + mapping.getValue()+" ");
        }

    }

    public static void bubbleSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;
                }
            }
        }
    }
}
