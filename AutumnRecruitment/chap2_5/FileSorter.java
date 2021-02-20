package AutumnRecruitment.chap2_5;

import java.io.File;
import java.util.Arrays;

/**
 * @Classname FileSorter
 * @Description TODO
 * @Date 2019/12/5 16:49
 * @Created by 14241
 */
public class FileSorter {

    public static void main(String[] args) {
        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.out.println(args[0] + " does not exist");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            return;
        }
        String[] files = directory.list();
        if (files == null) {
            System.out.println("could not read files");
            return;
        }
        Arrays.sort(files);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
