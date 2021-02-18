package ClassificationTraining.huaweiMiddle;

/**

 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，
 * 它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * 请你返回 s 中好分割的数目。
 */
public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(numSplits2(s));
    }

    public static int numSplits(String s) {
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            nums2[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            nums1[s.charAt(i) - 'a']++;
            nums2[s.charAt(i) - 'a']--;
            int a1 = 0, a2 = 0;
            for (int j = 0; j < 26; j++) {
                if (nums1[j] != 0) {
                    a1++;
                }
                if (nums2[j] != 0) {
                    a2++;
                }
            }
            if (a1 == a2) {
                res++;
            }
        }
        return res;

    }

    public static int numSplits2(String s) {
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            nums2[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            nums1[s.charAt(i) - 'a']++;
            nums2[s.charAt(i) - 'a']--;
            int a1 = 0, a2 = 0;
            for (int j = 0; j < 26; j++) {
                if (nums1[j] != 0) {
                    a1++;
                }
                if (nums2[j] != 0) {
                    a2++;
                }
            }

            if (a1 == a2) {
                res++;
            }

        }

        return res;
    }
}
