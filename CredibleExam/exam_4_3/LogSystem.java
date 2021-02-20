package CredibleExam.exam_4_3;


import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LogSystem
 * @Description TODO
 * @Date 2020/7/26 18:03
 * @Created by Administrator
 */
public class LogSystem {
    public static void main(String[] args) {

    }

    private Map<Integer, Integer> logSystem = new HashMap<>();


    public void add(int id, int timeStamp) {
        logSystem.put(id, timeStamp);
    }

    public int delete(int id) {
        if (!logSystem.containsKey(id)) {
            return -1;

        } else {
            logSystem.remove(id);
            return 0;
        }

    }
    public int query(int startTime, int endTime) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : logSystem.entrySet()) {
            int value = entry.getValue();
            if (value >= startTime && value <= endTime) {
                count++;
            } else {
                break;
            }
        }
        return count;

//        return (int) logSystem.values().stream().filter(x->x>=startTime&&x<=endTime).count();

    }
}
