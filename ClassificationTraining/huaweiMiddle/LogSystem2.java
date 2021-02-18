package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname LogSystem2
 * @Description TODO
 * @Date 2020/10/17 19:02
 * @Created by Administrator
 * 你将获得多条日志，每条日志都有唯一的 id 和 timestamp，timestamp 是形如 Year:Month:Day:Hour:Minute:Second 的字符串，例如 2017:01:01:23:59:59，所有值域都是零填充的十进制数。
 * <p>
 * 设计一个日志存储系统实现如下功能：
 * <p>
 * void Put(int id, string timestamp)：给定日志的 id 和 timestamp，
 * 将这个日志存入你的存储系统中。
 * <p>
 * int[] Retrieve(String start, String end, String granularity)：
 * 返回在给定时间区间内的所有日志的 id。start 、 end 和 timestamp 的格式相同，
 * granularity 表示考虑的时间级。比如，start = "2017:01:01:23:59:59",
 * end = "2017:01:02:23:59:59", granularity = "Day"
 * 代表区间 2017 年 1 月 1 日到 2017 年 1 月 2 日。
 */
public class LogSystem2 {
    private Map<Integer, String> map;
    private Map<String, Integer> dict;

    public LogSystem2() {
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
        int len = dict.get(gra);
        List<Integer> res = new ArrayList<>();
        String start = s.substring(0, len);
        String end = e.substring(0, len);
        for (int id : map.keySet()) {
            String time = map.get(id).substring(0, len);
            if (start.compareTo(time) <= 0 && end.compareTo(time) >= 0) {
                res.add(id);
            }
        }
        return res;

    }
}
