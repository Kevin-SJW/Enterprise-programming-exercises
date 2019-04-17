
import java.io.*;
import java.util.*;

/**
 * 一个每行都是ip的文本文件 ， 请统计出每个ip一共出现过多少次，
 *  * 并且根据出现次数从大到小排序，输出到新的文本文件
 */
public class FileIpCountSort {
    public static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    public static List<Map.Entry<String, Integer>> list_Data = null;

    public static void main(String args[]) {
        String filePath = "C:/Users/14241/Desktop/input.txt";
        String file = "C:/Users/14241/Desktop/output.txt";
        readFile(filePath);
        writeFile(file);

    }

    /**
     * 读入TXT文件
     */
    public static void readFile(String filePath) {
        try {
            /*要读取以上路径的input.txt文件*/
            File filename = new File(filePath);
            InputStreamReader reader = new InputStreamReader(
                    /*建立一个输入流对象reader*/
                    new FileInputStream(filename));
            /*建立一个对象，它把文件内容转成计算机能读懂的语言*/
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {

                if (hashMap.containsKey(line)) {
                    hashMap.put(line, hashMap.get(line) + 1);
                } else {
                    hashMap.put(line, 1);
                }
                /*一次读入一行数据*/
                line = br.readLine();

            }

            list_Data = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
            Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());

                }
            });

        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT文件
     */
    public static void writeFile(String file) {
        try {
            /*相对路径，如果没有则要建立一个新的output.txt文件*/
            File writeName = new File(file);
            /*创建新文件,有同名的文件的话直接覆盖*/
            writeName.createNewFile();
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);

            for (Map.Entry<String, Integer> entry : list_Data) {
                if (entry.getKey() != null) {
                    /*\r\n即为换行*/
                    out.write(entry.getKey() + "\t" + entry.getValue() + "\r\n");
                    /*把缓存区内容压入文件*/
                    out.flush();

                }
            }
            out.close();
        } catch (IOException e) {
            System.out.println("写文件出错");
            e.printStackTrace();
        }
    }
}

