package AutumnRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> rangeSum(int size, String[] stringList, List<List<Integer>> rangeLR) {
        List<String> result = new ArrayList<String>();
//        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        //遍历查询列表
        for (List<Integer> range : rangeLR) {
            TreeMap<String, Integer> map = new TreeMap<>();
            for (int i = range.get(0) - 1; i < range.get(1) - 1; i++) {
                map.put(stringList[i], map.getOrDefault(stringList[i], 0) + 1);
            }
            int max = -1;
            String key = null;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            result.add(key);
        }
        return result;
    }

    // METHOD SIGNATURE ENDS
}