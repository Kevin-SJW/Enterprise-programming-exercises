package Container;

import java.util.LinkedHashMap;

import static Container.Countries.print;

/**
 * @Classname LinkedHashMapDemo
 * @Description TODO
 * @Date 2019/10/6 16:11
 * @Created by 14241
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap =
                new LinkedHashMap<Integer, String>(
                        new CountingMapData(9));
        System.out.println("origin format:");
        print(linkedMap);
        // Least-recently-used order:
        linkedMap =
                new LinkedHashMap<Integer, String>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        System.out.println("Least-recently-used order:");
        print(linkedMap);
        System.out.println("Cause accesses:");
        // Cause accesses:
        for (int i = 0; i < 6; i++) {
            linkedMap.get(i);
        }
        print(linkedMap);
//        linkedMap.get(0);
        System.out.println("linkedMap.get(0):");
        print(linkedMap.get(0));
    }
} /* Output:
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
{6=G0, 7=H0, 8=I0, 0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0}
{6=G0, 7=H0, 8=I0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 0=A0}
*///:~

