package coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class DecomposeStringASC {
    public static void main(String[] args) {
        // 2 abc 123456789
        // 12345678 900000000 abc00000
        /*输出的字符串按照升序排列*/
        Scanner in = new Scanner(System.in);
        ArrayList<String> lists = new ArrayList<String>();
        int total = in.nextInt();
        for(int i = 0; i < total; i++) {
            String string = in.next();
            ArrayList<String> list = solution(string);
            for (String s : list) {
                lists.add(s);
            }
        }
        Collections.sort(lists);
        String result = lists.toString().replaceAll(", ", " ");
        System.out.println(result.substring(1, result.length() - 1));
//        System.out.println(result);
    }

    private static ArrayList<String> solution(String string) {
        int index = 8;
        ArrayList<String> list = new ArrayList<String>();

        while (index < string.length()) {
            String str = string.substring(index - 8, index);
            list.add(str);
            index = index + 8;
        }

        index = index - 8;
        String str = string.substring(index, string.length());
        while (str.length() < 8) {
            str = str + "0";
        }
        list.add(str);

        return list;
    }

}

