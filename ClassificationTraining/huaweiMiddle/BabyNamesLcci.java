package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname BabyNamesLcci
 * @Description TODO
 * @Date 2020/9/2 0:56
 * @Created by Administrator
 */
public class BabyNamesLcci {
    public static void main(String[] args) {
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        Arrays.stream(trulyMostPopular(names, synonyms)).forEach(t-> System.out.print(t+" "));
    }
    public static String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String,Integer> map= new HashMap<>();
        // 处理成map对象  字符串 统计值
        for (String name : names) {
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int f = Integer.valueOf(name.substring(idx1+1,idx2));
            map.put(name.substring(0,idx1),f);
        }
        HashMap<String,String> unionMap = new HashMap<>();
        for (String synonym : synonyms) {
            int idx = synonym.indexOf(",");
            String name1 = synonym.substring(1,idx);
            String name2 = synonym.substring(idx+1,synonym.length()-1);

            while (unionMap.containsKey(name1)){ // 追溯 原始姓名
                name1=unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)){
                name2= unionMap.get(name2);
            }

            if(!name1.equals(name2)){
                int f = map.getOrDefault(name1,0)
                        +map.getOrDefault(name2,0);
                //字典序最小的名字作为真实名字
                String tName = name1.compareTo(name2)<0?name1:name2;
                String nName = name1.compareTo(name2)<0?name2:name1;
                // 建立追溯关系
                unionMap.put(nName,tName);
                map.remove(nName);
                map.put(tName,f);
            }
        }
        String[] res = new String[map.size()];
        int i = 0;
        for (String key :map.keySet()){
            StringBuilder stringBuilder = new StringBuilder(key);
            stringBuilder.append('(');
            stringBuilder.append(map.get(key));
            stringBuilder.append(')');
            res[i]=stringBuilder.toString();
            i++;
        }
        return res;

    }
}
