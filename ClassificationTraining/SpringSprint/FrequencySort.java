package ClassificationTraining.SpringSprint;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname FrequencySort
 * @Description TODO
 * @Date 2021/2/10 21:35
 * @Created by Administrator
 */
public class FrequencySort {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));

    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        Queue<Map.Entry<Character,Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }

        while(!queue.isEmpty()){
            Map.Entry<Character,Integer> entry=queue.poll();
            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
