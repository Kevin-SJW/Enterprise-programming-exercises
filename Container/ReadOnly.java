package Container;

import java.util.*;

import static Container.Countries.print;

/**
 * @Classname ReadOnly
 * @Description TODO
 * @Date 2019/10/11 14:35
 * @Created by 14241
 */
public class ReadOnly {
    static Collection<String> data =
            new ArrayList<String>(Countries.names(6));
    public static void main(String[] args) {
        Collection<String> c =
                Collections.unmodifiableCollection(
                        new ArrayList<String>(data));
        System.out.println("! c.add(\"one\"):");
        print(c); // Reading is OK
        //! c.add("one"); // Can't change it

        List<String> a = Collections.unmodifiableList(
                new ArrayList<String>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println("! lit.add(\"one\"):");
        print(lit.next()); // Reading is OK
        //! lit.add("one"); // Can't change it

        Set<String> s = Collections.unmodifiableSet(
                new HashSet<String>(data));
        System.out.println("Reading is OK:");
        print(s); // Reading is OK
        //! s.add("one"); // Can't change it

        // For a SortedSet:
        System.out.println("For a SortedSet:");
        Set<String> ss = Collections.unmodifiableSortedSet(
                new TreeSet<String>(data));

        Map<String,String> m = Collections.unmodifiableMap(
                new HashMap<String,String>(Countries.capitals(6)));
        print(m); // Reading is OK
        //! m.put("Ralph", "Howdy!");

        // For a SortedMap:
        System.out.println("For a SortedMap:");
        Map<String,String> sm =
                Collections.unmodifiableSortedMap(
                        new TreeMap<String,String>(Countries.capitals(6)));

    }
} /* Output:
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
ALGERIA
[BULGARIA, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA]
{BULGARIA=Sofia, BURKINA FASO=Ouagadougou, BOTSWANA=Gaberone, BENIN=Porto-Novo, ANGOLA=Luanda, ALGERIA=Algiers}
*///:~

