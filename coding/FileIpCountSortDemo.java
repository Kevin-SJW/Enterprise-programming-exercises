package coding;

import java.io.*;
import java.util.*;

/**
 * @Classname FileIpCountSortDemo
 * @Description TODO
 * * 一个每行都是ip的文本文件 ， 请统计出每个ip一共出现过多少次，
 * 并且根据出现次数从大到小排序，输出到新的文本文件
 * @Date 2019/4/17 15:04
 * @Created by 14241
 */


public class FileIpCountSortDemo {
    public static HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
    public static List<Map.Entry<String,Integer>> listData=null;

    public static void main(String[] args) {
        String filePath = "C:/Users/14241/Desktop/in.txt";
        String file = "C:/Users/14241/Desktop/out.txt";
        readFile(filePath);
        writeFile(file);

    }

    /**
     * 读入txt
     *
     * @param filePath
     */
    public static void readFile(String filePath) {
        try {
//            File fileName =new File(filePath);
//            InputStreamReader reader=new InputStreamReader(new FileInputStream(fileName));
//            BufferedReader br=new BufferedReader(reader);
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            line=br.readLine();
            while(line!=null){
                if(hashMap.containsKey(line)){
                    hashMap.put(line,hashMap.get(line)+1);
                }else{
                    hashMap.put(line,1);
                }
                line=br.readLine();
            }

            listData = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
            Collections.sort(listData, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }


            });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 写入txt
     *
     * @param file
     */
    public static void writeFile(String file) {
        try {
            File writeName=new File(file);
            writeName.createNewFile();
            FileWriter fileWriter=new FileWriter(writeName);
            BufferedWriter bw=new BufferedWriter(fileWriter);
            for(Map.Entry<String,Integer> entry:listData){
               if(entry.getKey()!=null){
                   bw.write(entry.getKey()+"\t"+entry.getValue()+"\r\n");
                   bw.flush();
               }

            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
