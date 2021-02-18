package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname LogSystem
 * @Description TODO
 * @Date 2020/8/14 0:46
 * @Created by Administrator
 */
public class LogSystem {
    private Map<Integer, String> map;
    private Map<String, Integer> dict;
    public LogSystem() {
        map = new HashMap<>();
        dict = new HashMap<>();
        dict.put("Year", 4);
        dict.put("Month", 7);
        dict.put("Day", 10);
        dict.put("Hour", 13);
        dict.put("Minute", 16);
        dict.put("Second", 19);
    }
    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }
    // 2017:01:01:23:59:59
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ans = new ArrayList<>();
        Integer len = dict.get(gra);
        s = s.substring(0, len);
        e = e.substring(0, len);
        for (Integer id : map.keySet()) {
            String time = map.get(id).substring(0, len);
            if (time.compareTo(s) >= 0 && time.compareTo(e) <= 0) {
                ans.add(id);
            }
        }
        return ans;
    }
}
