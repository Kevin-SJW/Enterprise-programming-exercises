package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname LogAnonymize
 * @Description TODO
 * @Date 2021/2/18 22:31
 * @Created by Administrator
 */
public class LogAnonymize {
    public static void main(String[] args) {
        String[] keys = {"IMSI", "CellId", "UserIP", "CID", "CID"};
        String log = "";
        System.out.println(logAnonymize(keys, log));
    }

    public static String logAnonymize(String[] keys, String log) {
        StringBuilder encryptedInfo = new StringBuilder();
        List<String> keyList = new ArrayList<>();
        for (String key : keys) {
            keyList.add(key.toUpperCase());
        }
        for (String str : log.split(",")) {
            String[] info = str.split(":");
            if (info[0].equals("password") || info[0].equals("pwd")) {
                encryptedInfo.append(info[0] + ":******,");
            } else if (keyList.contains(info[0].toUpperCase())) {
                if (info[0].toUpperCase().endsWith("IP")) {
                    String[] ip = info[1].split("\\.");
                    encryptedInfo.append(info[0] + ":" + ip[0] + ".***.***." + ip[3] + ",");
                } else {
                    encryptedInfo.append(info[0] + ":" + getNumInfo(info[1]) + ",");
                }
            } else {
                encryptedInfo.append(str + ",");
            }
        }
        return encryptedInfo.substring(0, encryptedInfo.length() - 1);
    }

    public static String getNumInfo(String info) {
        int count = 0;
        for (int i = info.length() - 1; i >= 0; i--) {
            while (i >= 0 && Character.isLetter(info.charAt(i))) {
                i--;
                count++;
            }
            if (count >= 4) {
                int rightLength = count / 4 + 1;
                int middleLength = count / 2;
                int startIndex = i + 2 + count - rightLength - middleLength;
                return info.substring(0, startIndex) + String.join("", Collections.nCopies(middleLength, "*"))
                        + info.substring(startIndex + middleLength);
            }
            count = 0;
        }
        return info;
    }
}
