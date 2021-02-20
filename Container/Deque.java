package Container;

/**
 * @Classname Deque
 * @Description TODO
 * @Date 2019/10/6 15:27
 * @Created by 14241
 */
import java.util.*;

public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<T>();
    public void addFirst(T e) { deque.addFirst(e); }
    public void addLast(T e) { deque.addLast(e); }
    public T getFirst() { return deque.getFirst(); }
    public T getLast() { return deque.getLast(); }
    public T removeFirst() { return deque.removeFirst(); }
    public T removeLast() { return deque.removeLast(); }
    public int size() { return deque.size(); }
    @Override
    public String toString() { return deque.toString(); }
    // And other methods as necessary...
} ///:~
