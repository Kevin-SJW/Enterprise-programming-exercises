package AutumnRecruitment.chap3_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname ArrayST
 * @Description TODO
 * @Date 2019/12/5 17:26
 * @Created by 14241
 */
public class ArrayST<Key, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        N = 0;
    }

    public void put(Key key, Value val) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[N] = key;
        vals[N] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                keys[i] = keys[N - 1];
                vals[i] = vals[N - 1];
                keys[N - 1] = null;
                vals[N - 1] = null;
                N--;
                return;
            }
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(keys[i]);
        }
        return queue;
    }
}
