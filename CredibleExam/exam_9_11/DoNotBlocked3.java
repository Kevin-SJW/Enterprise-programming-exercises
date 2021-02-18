package CredibleExam.exam_9_11;

import java.util.*;

/**
 * @Classname DoNotBlocked
 * @Description TODO
 * @Date 2020/9/12 19:53
 * @Created by Administrator
 * 数组speed记录了一批仓鼠的爬行速度，数组下标为仓鼠的编号，若将这批仓鼠按编号降序全部放入管道，
 * 管径大小仅容一只仓鼠通过，仓鼠自左向右，同时爬行，（假设管道无限长）
 * 请根据speed预判一下不会被其他仓鼠阻塞的仓鼠有哪些，并将其在speed数组中的下标以升序数组形式返回
 * 注意速度相同的相邻仓鼠不会被阻塞
 * 输入1：speed=[4,5,3,2,8,7,1],输出[6]
 * 解释：speed[6]速度为1的仓鼠不会被其他仓鼠阻塞，但会阻塞其他仓鼠
 * 输入2：speed=[4,5,5,3,2,8,7],输出[4,6]
 * 解释：speed[6]速度为7的仓鼠背会被其他仓鼠阻塞，但会堵住speed[5]速度为8的仓鼠。speed[4]速度为2的仓鼠不会
 * 被速度为7,8的仓鼠，但会堵住speed[0],speed[1],speed[2]和speed[3]对应的仓鼠
 * 提示：0<=speed[i],speed.length<=10^5
 */
public class DoNotBlocked {
    public static void main(String[] args) {
//        int[] speed = {4, 5, 3, 2, 8, 7, 1};
        int[] speed1 = {4, 5, 5, 3, 2, 8, 7};
        int[] speed2 = {5, 5, 5};
        Arrays.stream(doNotBlocked(speed1)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] doNotBlocked(int[] speed) {

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = speed.length - 1; i > 0; i--) {

            if (res.isEmpty()) {
                res.addLast(speed[i]);
            } else {
                if (res.peek() < speed[i]) {
                    continue;
                } else {
                    res.push(i);
                }
            }

            Collections.reverse(res);

        }
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }
}
