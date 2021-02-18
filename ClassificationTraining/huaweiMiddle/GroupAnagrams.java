package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname GroupAnagrams
 * @Description TODO
 * @Date 2020/9/2 23:12
 * @Created by Administrator
 * 字母异位词分组
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).stream().forEach(t -> t.stream()
                .forEach(p -> System.out.print(p + " ")));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, ArrayList> map = new HashMap<>();
        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());


    }
}
