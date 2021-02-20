package CredibleExam.exam_9_25;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Classname RouteSearch
 * @Description TODO
 * @Date 2020/11/11 22:56
 * @Created by Administrator
 * 匹配规则：若entryIp和srcIp表示的前m个bit相同，则说明该条路由是匹配的
 * 所有匹配的路由中，m最大的即为“最长匹配”
 *
 */

//192.168.0.3
//6
//10.166.50.0/23
//192.0.0.0/8
//10.255.255.255/32
//192.168.0.1/24
//127.0.0.0/8
//192.168.0.0/24
//
//192.168.0.1/24
public class RouteSearch {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String dstIp = cin.nextLine();
        int row = Integer.parseInt(cin.nextLine());
        int col = 2;
        String[][] ipTable = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] current = cin.nextLine().split("/");
            System.arraycopy(current, 0, ipTable[0], 0, col);
        }
        cin.close();
        String result = routeSearch(dstIp, ipTable);
        System.out.println(result);
    }

    private static String routeSearch(String dstIp, String[][] ipTable) {
        String result = "empty";
        int m = 0;
        //转换十进制
        String ipStrTen = getTenString(dstIp);
        for (String[] ipTableStr : ipTable) {
            String ipTableStr0 = getTenString(ipTableStr[0]);
            Integer ipTableStrT = Integer.valueOf(ipTableStr[1]);
            if ("0".equals(ipTableStrT.toString())) {
                result = ipTableStr[0] + "/" + ipTableStrT;
            } else if (ipStrTen.substring(0, ipTableStrT)
                    .equals(ipTableStr0.substring(0, ipTableStrT)) && ipTableStrT > m) {
                m = ipTableStrT;
                result = ipTableStr[0] + "/" + ipTableStrT;

            }
        }
        return result;
    }

    private static String getTenString(String dstIp) {
        String ipStrTen = "";
        String[] ipArry = dstIp.replace(".", ",").split(",");
        for (String ipStr : ipArry) {
            String ipStrNew = Integer.toBinaryString(Integer.valueOf(ipStr));
            ipStrTen = ipStrTen + "00000000".substring(0, 8 - ipStrNew.length()) + ipStrNew;
        }
        return ipStrTen;
    }
}
