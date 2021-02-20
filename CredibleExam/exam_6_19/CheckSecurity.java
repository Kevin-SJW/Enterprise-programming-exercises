package CredibleExam.exam_6_19;

import java.util.Arrays;

/**
 * @Classname CheckSecurity
 * @Description TODO
 * @Date 2020/7/18 22:02
 * @Created by Administrator
 * 获取需要重点观察的人员
 */
public class CheckSecurity {
    public static void main(String[] args) {
        int[][] records={{20,50,23,44},{30,53,60},{1000,700,20}};
        int k=60,times=3;
        Arrays.stream(checkSecurity(records, k, times)).forEach(t-> System.out.print(t+" "));

    }
    public static int[] checkSecurity(int[][] records,int k,int times){
        if(records==null||records.length==0){
            return new int[]{0};
        }
        int[] ans=new int[records.length];
        int index=0;
       for(int i=0;i<records.length-1;i++){
           int[] record=records[i];
           if(record.length<times){
               continue;
           }
           Arrays.sort(record);
           if(isNotSecurity(record,k,times)){
               ans[index++]=i;
           }
       }
       return Arrays.copyOf(ans,index);

    }

    public static boolean isNotSecurity(int[] records,int k,int times){
        int left=0;
        int len=records.length;
        for(int i=0;i<len;i++){
            if(left+times-1>len){
                continue;
            }
            if(records[left+times-1]-records[left]>=k){
                return false;
            }
        }
        return true;
    }
}
