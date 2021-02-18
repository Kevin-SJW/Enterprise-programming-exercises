package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname HTMLEntityParser
 * @Description TODO
 * @Date 2020/10/1 23:47
 * @Created by Administrator
 */
public class HTMLEntityParser {
    public static void main(String[] args) {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        System.out.println(entityParser(text));

    }

    public static String entityParser(String text) {
        Map<String,String> map=new HashMap<>();
        map.put("quot;","\"");
        map.put("apos;","\'");
        map.put("amp;","&");
        map.put("gt;",">");
        map.put("lt;","<");
        map.put("frasl;","/");
        String[] s1=text.split("&");
        Arrays.stream(s1).forEach(t-> System.out.print(t+" "));
        System.out.println();
        StringBuilder sb=new StringBuilder();
        sb.append(s1[0]);
        System.out.println(sb.toString());
        System.out.println();
        for(int j=1;j<s1.length;j++){
            int i=s1[j].indexOf(';');
            String ss=s1[j].substring(0,i+1);
            String last=s1[j].substring(i+1);

            sb.append(map.getOrDefault(ss,"&"+ss));
            sb.append(last);
        }

        return sb.toString();

    }
}
