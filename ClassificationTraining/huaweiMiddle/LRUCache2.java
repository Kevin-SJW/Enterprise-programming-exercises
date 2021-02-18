package ClassificationTraining.huaweiMiddle;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCache2
 * @Description TODO
 * @Date 2020/12/20 11:34
 * @Created by Administrator
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
