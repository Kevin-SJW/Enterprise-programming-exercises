package Container;

import java.util.*;

import static Container.Countries.print;

/**
 * @Classname Lists
 * @Description TODO
 * @Date 2019/10/6 17:00
 * @Created by 14241
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        // Add at location 1
        a.add(1, "x");
        // Add at end
        a.add("x");
        // Add a collection:
        a.addAll(Countries.names(5));
        // Add a collection starting at location 3:
        a.addAll(3, Countries.names(5));
        // Is it in there?
        b = a.contains("1");
        // Is the entire collection in there?
        b = a.containsAll(Countries.names(5));
        // Lists allow random access, which is cheap
        // for ArrayList, expensive for LinkedList:
        // Get (typed) object at location 1
        s = a.get(1);
        // Tell index of object
        i = a.indexOf("1");
        // Any elements inside?
        b = a.isEmpty();
        // Ordinary Iterator
        it = a.iterator();
        // ListIterator
        lit = a.listIterator();
        // Start at loc 3
        lit = a.listIterator(3);
        // Last match
        i = a.lastIndexOf("1");
        // Remove location 1
        a.remove(1);
        // Remove this object
        a.remove("3");
        // Set location 1 to "y"
        a.set(1, "y");
        // Keep everything that's in the argument
        // (the intersection of the two sets):
        a.retainAll(Countries.names(5));
        // Remove everything that's in the argument:
        a.removeAll(Countries.names(5));
        // How big is it?
        i = a.size();
        // Remove all elements
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Must move to an element after add():
        it.next();
        // Remove the element after the newly produced one:
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        print(a);
        List<String> b = Countries.names(5);
        print("b = " + b);
        a.addAll(b);
        a.addAll(b);
        print(a);
        // Insert, remove, and replace elements
        // using a ListIterator:
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        print(a);
        print(x.next());
        x.remove();
        print(x.next());
        x.set("47");
        print(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious()) {
            print(x.previous() + " ");
        }
        print("");
        print("testVisual finished");
    }

    /**
     * There are some things that only LinkedLists can do:
     */
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(Countries.names(5));
        print(ll);
        // Treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addFirst("two");
        print(ll);
        // Like "peeking" at the top of a stack:
        print(ll.getFirst());
        // Like popping a stack:
        print(ll.removeFirst());
        print(ll.removeFirst());
        // Treat it like a queue, pulling elements
        // off the tail end:
        print(ll.removeLast());
        print(ll);
    }

    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(
                new LinkedList<String>(Countries.names(5)));
        basicTest(
                new ArrayList<String>(Countries.names(5)));
        iterMotion(
                new LinkedList<String>(Countries.names(5)));
        iterMotion(
                new ArrayList<String>(Countries.names(5)));
        iterManipulation(
                new LinkedList<String>(Countries.names(5)));
        iterManipulation(
                new ArrayList<String>(Countries.names(5)));
        testVisual(
                new LinkedList<String>(Countries.names(5)));
        testLinkedList();
    }
} /* (Execute to see output) *///:~

