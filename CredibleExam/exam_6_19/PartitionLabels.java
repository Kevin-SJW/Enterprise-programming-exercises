package CredibleExam.exam_6_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname PartitionLabels
 * @Description TODO
 * @Date 2020/8/2 21:13
 * @Created by Administrator
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Arrays.stream(partionLabel(s)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] partionLabel(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int left=0;
        int right=0;
        List<Integer> list=new ArrayList<>();
        for(int j=0;j<s.length();j++){
            right=Math.max(right,map.get(s.charAt(j)));
            if(right==j){
                list.add(j-left+1);
                left=j+1;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
