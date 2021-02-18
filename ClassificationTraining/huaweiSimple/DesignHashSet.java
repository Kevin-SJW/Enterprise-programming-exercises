package ClassificationTraining.huaweiSimple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DesignHashSet
 * @Description TODO
 * @Date 2020/9/2 22:26
 * @Created by Administrator
 */
public class DesignHashSet {
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public DesignHashSet() {
        map=new HashMap<>();
    }

    public void add(int key) {
        map.put(key,map.getOrDefault(key,0)+1);
    }

    public void remove(int key) {
            map.remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
