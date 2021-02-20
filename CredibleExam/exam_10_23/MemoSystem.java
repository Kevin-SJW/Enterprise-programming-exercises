package CredibleExam.exam_10_23;

import java.util.*;

/**
 * @Classname MemoSystem
 * @Description TODO
 * @Date 2020/11/11 23:48
 * @Created by Administrator
 * addEvent:添加从startDate起间隔period周期一共num个的event，内容为content，
 * 如果已存在失败，则添加失败，返回添加成功的个数。
 * finishEvent，标记已完成，若不存在或已完成则返回false
 * removeEvent移除event
 * queryTodo查询起止时间内未完成的event，并按字典序排序
 */
public class MemoSystem {
    HashMap<Integer, List<Event>> map;

    public MemoSystem() {
        map = new HashMap<>();
    }

    public int addEvent(int startDate, String content, int num, int period) {
        int count = 0;
        for (int i = startDate; i <= startDate + (num - 1) * period; i += period) {
            List<Event> events = map.getOrDefault(i, new ArrayList<>());
            boolean flag = false;
            flag = checkFlag(events, false, content);
            if (flag) {
                continue;
            }
            events.add(new Event(content, false));
            map.put(i, events);
            count++;
        }
        return count;
    }

    public boolean checkFlag(List<Event> events, boolean flag, String content) {
        if (!events.isEmpty()) {
            for (Event event : events) {
                if (event.content.equals(content)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean finishEvent(int date, String content) {
        List<Event> events = map.get(date);
        if (events == null) {
            return false;
        }
        for (Event event : events) {
            if (event.content.equals(content)) {
                if (event.isFinished) {
                    return false;
                }
                event.isFinished = true;
                return true;
            }
        }
        return false;
    }

    public boolean removeEvent(int date, String content) {
        List<Event> events = map.get(date);
        if (events == null) {
            return false;
        }
        for (Iterator<Event> it = events.iterator(); it.hasNext();) {
            Event iterator = it.next();
            if (iterator.content.equals(content)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public String[] queryTodo(int startDate, int endDate) {
        List<String> res = new ArrayList<>();
        for (int i = startDate; i <= endDate; i++) {
            List<Event> events = map.get(i);
            putEvent(events, res);
        }
        return res.toArray(new String[res.size()]);
    }

    public void putEvent(List<Event> events, List<String> res) {
        if (events != null) {
            Collections.sort(events, Comparator.comparing(a -> a.content));
            for (Event event : events) {
                if (!event.isFinished) {
                    res.add(event.content);
                }
            }
        }
    }

    public static void main(String[] args) {
        MemoSystem memoSystem = new MemoSystem();
        System.out.println(memoSystem.addEvent(0, "eat burger", 5, 2));
        System.out.println(memoSystem.addEvent(2, "save file", 1, 1));
        System.out.println(memoSystem.finishEvent(0, "eat burger"));
        System.out.println(memoSystem.removeEvent(4, "save file"));
        Arrays.stream(memoSystem.queryTodo(0, 6)).forEach(t-> System.out.print(t+" "));
    }
}

class Event {
    String content;
    boolean isFinished;

    public Event(String content, boolean isFinished) {
        this.content = content;
        this.isFinished = isFinished;
    }
}
