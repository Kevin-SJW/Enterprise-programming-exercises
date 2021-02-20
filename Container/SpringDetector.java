package Container;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static Container.Countries.print;

/**
 * @Classname SpringDetector
 * @Description TODO
 * @Date 2019/10/11 16:07
 * @Created by 14241
 */
public class SpringDetector {
    // Uses a Groundhog or class derived from Groundhog:
    public static <T extends Groundhog>
    void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog,Prediction> map =
                new HashMap<Groundhog,Prediction>();
        for(int i = 0; i < 10; i++)
            map.put(ghog.newInstance(i), new Prediction());
        print("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println();
        print("Looking up prediction for " + gh);
        if(map.containsKey(gh))
            print(map.get(gh));
        else
            System.out.println();
            print("Key not found: " + gh);
    }
    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
} /* Output:
map = {Groundhog #3=Early Spring!, Groundhog #7=Early Spring!, Groundhog #5=Early Spring!, Groundhog #9=Six more weeks of Winter!, Groundhog #8=Six more weeks of Winter!, Groundhog #0=Six more weeks of Winter!, Groundhog #6=Early Spring!, Groundhog #4=Six more weeks of Winter!, Groundhog #1=Six more weeks of Winter!, Groundhog #2=Early Spring!}
Looking up prediction for Groundhog #3
Key not found: Groundhog #3
*///:~

