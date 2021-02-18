package ClassificationTraining.huaweiSimple;

/**
 * @Classname InvalidateIpAddress
 * @Description TODO
 * @Date 2020/10/3 20:06
 * @Created by Administrator
 */
public class InvalidateIpAddress {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }
    public static String defangIPaddr(String address) {

        return address.replace(".","[.]");
    }
}
