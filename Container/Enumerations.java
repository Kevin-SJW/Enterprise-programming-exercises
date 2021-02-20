package Container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Classname Emuerations
 * @Description TODO
 * @Date 2019/10/6 15:37
 * @Created by 14241
 */
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v =
                new Vector<String>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + ", ");
            System.out.println(e.hasMoreElements());
        }
        // Produce an Enumeration from a Collection:
        System.out.println();
        e = Collections.enumeration(new ArrayList<String>());
        System.out.println("e:"+e);
    }
} /* Output:
ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC,
*///:~
