package CredibleExam.exam_9_26;

/**
 * @Classname Ip2CIDR
 * @Description TODO
 * @Date 2020/7/5 20:01
 * @Created by Administrator
    思路，找到这些IPs中从右往左第一位相同的二进制位
    x & -x ;-x是x的补码，返回x与2^64的最大公约数，
    即x最多能被n个2整除就返回2^n,如果x是奇数返回1;返回值为0 ，
    说明x=0;为其他数，表示x为x与2^64的最大公约数
    一言以蔽之就是获取32位二进制表示中从右往左首次出现1的位置
 */
public class Ip2CIDR {
    public static void main(String[] args) {
        Ip2CIDR i2 = new Ip2CIDR();
        System.out.println(i2.IC("255.0.0.7", 10));
    }
    public String IC(String ip,int n){
        long x = 0;
        //以"."划分每个IP
        String[] ipsegment = ip.split("\\.");
        for(int i=0;i<ipsegment .length;i++){
            x = Integer.parseInt(ipsegment [i])+x*256;
        }
        String res = "";
        while(n>0){
            long temp = x & -x;
            while(temp>n) {
                temp = temp/2; }
            res+=longToIP(x, (int)temp)+"  ";
            x+=temp;//temp个ips考虑好了，接下来考虑从x+temp考虑
            n-=temp;//还有几个IPs要求ICDR的
        }
        return  res;
    }
    public String longToIP(long x,int temp){
        int netID = 32;
        while(temp>0){
            temp/=2;
            netID--;
        }

        int[] ans = new int[4];
        for(int i=0;i<ans.length-1;i++){
            ans[i] = (int)(x & 255);
            x>>=8;
        }
        ans[ans.length-1] = (int)x;
        netID++; //加1：比如说某些IPs有m位相同，是指0-m-1位相同
        return ans[3]+"."+ans[2]+"."+ans[1]+"."+ans[0]+"/"+netID;
    }

}
