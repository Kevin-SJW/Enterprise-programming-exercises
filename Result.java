import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @Classname Result
 * @Description TODO
 * @Date 2019/4/24 20:20
 * @Created by 14241
 */
public class Result {
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int sCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> s = IntStream.range(0, sCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.funWithAnagrams(s);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))

                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static List<String> funWithAnagrams(List<String> s){
        int n=Integer.parseInt(s.get(0));
        List<String> list=new ArrayList<>();
        List<String> lists=new ArrayList<>();
        Set<String> set=new HashSet<>();
        boolean judge=true;
        for(int i=1;i<n;i++){
            judge=isAnagrams(s.get(i),s.get(i+1));
            if(judge){
                list.add(s.get(i));
            }

        }
        set.addAll(list);
        lists.addAll(set);
        Collections.sort(lists);
        return lists;

    }
    /*判断相同字母异序词*/
    private static boolean isAnagrams(String s1,String s2){
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return  Arrays.equals(c1,c2);
    }
}
