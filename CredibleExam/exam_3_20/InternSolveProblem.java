package CredibleExam.exam_3_20;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname InternSolveProblem
 * @Description TODO
 * @Date 2020/7/26 20:23
 * @Created by Administrator
 */
public class InternSolveProblem {
    public int[] solve(int k, int[][] update, int[][] out) {
        TreeSet<Integer> outSet = new TreeSet<>();
        TreeMap<Integer, Integer> updateMap = new TreeMap<>();
        int endDay = parseInput(update, out, outSet, updateMap);
        //剩余要学习的课程
        int lesson = 0;
        List<Integer> result = new ArrayList<>();
        //从第0天开始，到结束
        for (int day = 0; day <= endDay; day++) {
            //先更新课程，如果当天没有数据，则新增为0
            lesson = updateMap.getOrDefault(day, 0);
            //如果当天外出，没法刷题
            if (outSet.contains(day)) {
                continue;
            }
            //还有课要上，必须先上课
            if (lesson > 0) {
                lesson -= k;
                lesson = Math.max(0, lesson);
                continue;
            }
            //记录可刷题的天数
            result.add(day);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int parseInput(int[][] update, int[][] out, TreeSet<Integer> outSet,
                          TreeMap<Integer, Integer> updateMap) {
        for (int[] outSchool : out) {
            if (outSchool.length != 2) {
                break;
            }
            //记录外出时间，区间内的每天都要记录
            for (int day = outSchool[0]; day <= outSchool[1]; day++) {
                outSet.add(day);
            }
        }
        for (int[] updateDay : update) {
            if (update.length != 2) {
                break;
            }
            updateMap.put(updateDay[0], updateDay[1]);
        }
        //返回最后的课程更新时间
        return updateMap.lastKey();
    }
}
