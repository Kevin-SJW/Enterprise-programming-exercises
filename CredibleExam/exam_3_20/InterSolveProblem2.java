package CredibleExam.exam_3_20;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname InterSolveProblem2
 * @Description TODO
 * @Date 2020/8/2 14:49
 * @Created by Administrator
 */
public class InterSolveProblem2 {

    public int[] solve(int k, int[][] update, int[][] out) {
        TreeSet<Integer> outSet = new TreeSet<>();
        TreeMap<Integer, Integer> updateMap = new TreeMap<>();
        int endDay = parseInput(update, out, outSet, updateMap);
        List<Integer> res = new ArrayList<>();
        //课程数
        int lesson = 0;
        //从第0天开始学习
        for (int day = 0; day <= endDay; day++) {
            //先更新课程
            lesson = updateMap.getOrDefault(day, 0);
            //判断是否有外出
            if (outSet.contains(day)) {
                continue;
            }
            if (lesson > 0) {
                lesson -= k;
                lesson = Math.max(0, lesson);
                continue;
            }
            res.add(day);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();


    }

    public static int parseInput(int[][] update, int[][] out, TreeSet<Integer> outSet,
                                 TreeMap<Integer, Integer> updateMap) {

        for (int[] outSchool : out) {
            if (outSchool.length != 2) {
                break;
            }
            for (int day = outSchool[0]; day <= outSchool[1]; day++) {
                outSet.add(day);
            }
        }
        for (int[] updateDay : update) {
            if (updateDay.length != 2) {
                break;
            }
            for (int update_ = updateDay[0]; update_ <= updateDay[1]; update_++) {
                updateMap.put(updateDay[0], updateDay[1]);
            }
        }

        return updateMap.lastKey();
    }

}



