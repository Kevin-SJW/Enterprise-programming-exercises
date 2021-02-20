package Container;

import java.util.ArrayList;

/**
 * @Classname CollectionData
 * @Description TODO
 * @Date 2019/10/6 16:47
 * @Created by 14241
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i = 0; i < quantity; i++)
            add(gen.next());
    }
    // A generic convenience method:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
} ///:~
