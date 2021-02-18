package ClassificationTraining.huaweiSimple;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < arr.length && judge(arr[l])) {
                l++;
            }
            while (r >= 0 && judge(arr[r])) {
                r--;
            }
            if (l >= r) {
                break;
            }
            char tmp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = tmp;
        }
        // String result = String.valueOf(arr);
        return new String(arr);
    }

    public static boolean judge(char c) {
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
                && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            return true;
        } else {
            return false;
        }
    }
}

//if (s == null || s.length() == 0) {
//        return null;
//        }
//        List<Character> vowelList = Arrays.asList('a', 'e', 'u', 'i', 'o', 'A', 'E', 'U', 'I', 'O');
//        char[] a = s.toCharArray();
//        for (int i = 0; i < a.length; i++) {
//        for (int j = i + 1; j < a.length; j++) {
//        if (vowelList.contains(a[i]) && vowelList.contains(a[j])) {
//        char temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//        }
//        }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < a.length; i++) {
//        sb.append(a[i]);
//        }
//        return sb.toString();
