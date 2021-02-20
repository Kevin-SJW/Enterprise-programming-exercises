package Container;

/**
 * @Classname StringHashCode
 * @Description TODO
 * @Date 2019/10/11 16:25
 * @Created by 14241
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
} /* Output: (Sample)
*/
