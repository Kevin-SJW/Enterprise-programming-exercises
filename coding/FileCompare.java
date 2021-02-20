package coding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Classname FileCompare
 * @Description
 *
 * 机器上有两个目录：a b， 目录下面又有文件和文件夹，文件夹下面又有文件和文件夹，以此类推。
 * 需要找出来A B 两个目录下面有哪些文件是不同的。
 * 不同文件的定义：
 * 1. 名字不一样
 * 2. 大小不一样
 * 3. 内容不一样
 * 输出： 两个目录下有哪些是不同的。
 * @Date 2019/4/22 13:35
 * @Created by 14241
 */
public class FileCompare {
    private FileCompare() {
    }

    private void getDir(File f,Map<String, Long> map, int level) {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            if (childs[i].isDirectory()) {
                map.put(childs[i].getName(), childs[i].length());
                this.getDir(childs[i],map,level + 1);
            }else{
                map.put(childs[i].getName(), childs[i].length());
            }
        }
    }

    /**
     * 查询两个文件夹下所有的不同文件，并保存到批定的文件中
     * @param sourceFolder 源文件夹路径
     * @param targetFolder 目标文件夹路径
     * @param saveFile     保存的文件路径
     */
    private void compareFile(String sourceFolder,String targetFolder,String saveFile) {
        Map<String, Long> sourceMap = new HashMap<String, Long>();
        Map<String, Long> targetMap = new HashMap<String, Long>();
        new FileCompare().getDir(new File(sourceFolder), sourceMap,0);
        new FileCompare().getDir(new File(targetFolder), targetMap,0);

        /*判断目标文件是否存在*/
        File f = new File(saveFile);
        if (f.exists()){
            try {
                f.delete();
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else{
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        String source = null;

        byte[] bytes = null;
        OutputStream os;
        try {
            os = new FileOutputStream(saveFile);

            Set set = sourceMap.entrySet();
            Iterator i = set.iterator();
            while (i.hasNext()) {
                Map.Entry<String, Long> entry1 = (Map.Entry<String, Long>) i.next();
                if (!sourceMap.get(entry1.getKey()).equals(targetMap.get(entry1.getKey()))) {
                    source = entry1.getKey()+"\r\n";
                    bytes =  source.getBytes();

                    os.write(bytes);
                }
            }

            set = targetMap.entrySet();
            i = set.iterator();
            while (i.hasNext()) {
                Map.Entry<String, Long> entry1 = (Map.Entry<String, Long>) i.next();
                if (!targetMap.get(entry1.getKey()).equals(sourceMap.get(entry1.getKey()))) {
                    source = entry1.getKey()+"\r\n";
                    bytes =  source.getBytes();

                    os.write(bytes);
                }
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new FileCompare().compareFile("C:/Users/14241/Desktop/A",
                "C:/Users/14241/Desktop/B",
                "C:/Users/14241/Desktop/compareFile.txt");
        System.out.println("不同的文件已比较完毕，结果已保存在compareFile.txt中！");
    }
}
/*
输出compareFile.txt显示:
a2
a21.txt
a22.txt
b.txt
3.txt
b1.txt*/
