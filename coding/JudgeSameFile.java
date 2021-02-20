package coding;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Classname JudgeSameFile
 * @Description TODO
 * @Date 2019/4/22 13:49
 * @Created by 14241
 */
public class JudgeSameFile {
    public static void main(String[] args) {
        compare("C:/Users/14241/Desktop/A", "C:/Users/14241/Desktop/B");
    }

    public static void compare(String frompath, String topath) {
        Map<String,String> fromMap = new HashMap<String, String>();
        Map<String,String> toMap = new HashMap<String, String>();
        try {
            System.out.println("----------------------fromMap开始----------------------------");
            LinkedList list = new LinkedList();
            File dir = new File(frompath);
            File file[] = dir.listFiles();
            for (int i = 0; i < file.length; i++) {
                if (file[i].isDirectory())
                    list.add(file[i]);
                else{
                    fromMap.put(file[i].getName(),file[i].getName());
                    //System.out.println(file[i].getName());
                }
            }
            System.out.println("----------------------toMap开始----------------------------");
            dir = new File(topath);
            File[] tofile = dir.listFiles();
            for (int i = 0; i < tofile.length; i++) {
                if (tofile[i].isDirectory())//判断读到的是否是文件夹
                    list.add(tofile[i]);
                else{
                    toMap.put(tofile[i].getName(),tofile[i].getName());
                    //System.out.println(tofile[i].getName());
                }

            }
            System.out.println("判断toMap中的值是否在fromMap中存在.");
            Iterator it = toMap.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String, String> e = (Map.Entry<String, String>) it.next();
                if(fromMap.containsKey(e.getKey())){
                }else{
                    System.out.println(e.getKey());
                }
            }
            System.out.println("判断fromMap中的值是否在toMap中存在.");
            Iterator it1 = fromMap.entrySet().iterator();
            while(it1.hasNext()){
                Map.Entry<String, String> e = (Map.Entry<String, String>) it1.next();
                if(toMap.containsKey(e.getKey())){
                }else{
                    System.out.println(e.getKey());
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
