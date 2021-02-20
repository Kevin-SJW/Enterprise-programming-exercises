package CredibleExam;

/**
 * @Classname ValidIpAddress
 * @Description TODO
 * @Date 2020/7/18 0:23
 * @Created by Administrator
 */
public class ValidIpAddress {
    public static void main(String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(IP));

    }
    public static String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isIPv4(String IP) {
        if (IP.length() < 7 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] strings = IP.split("\\.");
        if (strings.length != 4) {
            return false;
        }
        for (String string : strings) {
            if (string.length() == 0 || (string.charAt(0) == '0' && string.length() != 1)) {
                return false;
            }
            int num = 0;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!(c >= '0' && c <= '9')) {
                    return false;
                }
                num = num * 10 + c - '0';
                if (num > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isIPv6(String IP) {
        if (IP.length() < 15 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] strings = IP.split(":");
        if (strings.length != 8) {
            return false;
        }
        for (String string : strings) {
            if (string.length() == 0 || string.length() > 4) {
                return false;
            }
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
