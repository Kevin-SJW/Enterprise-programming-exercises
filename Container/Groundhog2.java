package Container;

/**
 * @Classname Groundhog2
 * @Description TODO
 * @Date 2019/10/6 16:09
 * @Created by 14241
 */

public class Groundhog2 extends Groundhog {
    public Groundhog2(int n) { super(n); }
    @Override
    public int hashCode() { return number; }
    @Override
    public boolean equals(Object o) {
        return o instanceof Groundhog2 &&
                (number == ((Groundhog2)o).number);
    }
} ///:~
