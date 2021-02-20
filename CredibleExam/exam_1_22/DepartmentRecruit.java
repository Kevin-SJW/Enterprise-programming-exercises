package CredibleExam.exam_1_22;

import java.util.*;

/**
 * 某公司正在进行招聘，1.每个部门计划招聘人数放在整形数组nums中，数组下表即各个部门编号；
 * 2.每个应聘者的面试成绩存放在整形数组scores中，数组下标即各个应聘者编号；
 * 3.每个应聘者的面试成绩放在整形数组scores中，数组下标即各个应聘者编号，应聘者最少1个，最多有三个意向部门
 * 意向部门编号存放在二维数组preference中，数组一维下标是各个应聘者的编号，
 * 招聘规则：
 * 1.编号较小的部门相对编号较大的部门有录用优先权
 * 2.部门只能录取对本部门有意向且尚未被录取的应聘者，招满即止（计划招聘的人数为0，也算完成了招聘）
 * 3.部门优先录取成绩较高者，如果成绩相同，优先录取应聘者编号较小者。
 * 4.每个应聘者最多被录取一次；
 * 请将未完成招聘任务的部门数量和没有被录用的应聘者数量，依次存放于列表返回
 * （1）将求职者按分数降序排列，分数高者优先选取部门；
 * （2）对于每个求职者选取部门时，本题要求编号小者优先，（类似第一志愿，第二志愿）
 *
 */
public class DepartmentRecruit {
    public static int[] departmentRecruit(int[] nums, int[] scores, int[][] preference) {
        List<Integer> res = new LinkedList<>();
        List<int[]> scoreList = new ArrayList<>();
        for (int[] num : preference) {
            Arrays.sort(num);
        }
        //记录已经被录用的人
        List<Integer> inCompany = new LinkedList<>();
        for (int i = 0; i < scores.length; i++) {
            scoreList.add(new int[]{scores[i], i});
        }
        Collections.sort(scoreList, (v1, v2) -> v2[0] - v1[0]);
        for (int i = 0; i < scoreList.size(); i++) {
            //查找意向部门
            int[] cur = scoreList.get(i);
            int[] wantP = preference[cur[1]];
            //查看意向部门是否有名额
            for (int j = 0; j < wantP.length; j++) {
                if (nums[wantP[j]] > 0) {
                    nums[wantP[j]]--;
                    //加入已经录用的名单
                    inCompany.add(cur[1]);
                    break;
                }
            }
        }
        //处理结果-没有完成名额的部门
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                count++;
            }
        }
        res.add(count);
        //处理结果-没有被录用的数量
        res.add(scores.length - inCompany.size());
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 0};
        int[] scores = {89, 89, 89, 89};
        int[][] preference = {{2, 1}, {1}, {1, 2}, {1}};
        int[] res = departmentRecruit(nums, scores, preference);
        System.out.println(Arrays.toString(res));
    }
}
