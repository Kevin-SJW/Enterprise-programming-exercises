package AutumnRecruitment.chap1;

/**
 * @Classname TestGc
 * @Description TODO
 * @Date 2019/9/21 21:17
 * @Created by 14241
 */
public class TestGc{

    public static void main(String[] args){

        byte[] holder = new byte[32*1024*1024];

        System.gc();

    }

}
