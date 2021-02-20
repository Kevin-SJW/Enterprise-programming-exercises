package Container;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description TODO
 * @Date 2019/9/15 12:44
 * @Created by 14241
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private static final int MAX_ENTRIES=3;

    @Override
    protected  boolean removeEldestEntry(Map.Entry eldest){

        return size()>MAX_ENTRIES;
    }

    LRUCache(){
        super(MAX_ENTRIES,0.75f,true);
    }

    public static void main(String[] args){
            LRUCache<Integer,String> cache=new LRUCache<Integer, String>();
            cache.put(1,"a");
            cache.put(2,"b");
            cache.put(3,"c");
            cache.get(1);
            cache.put(4,"d");
            System.out.println(cache.keySet());
    }
}
