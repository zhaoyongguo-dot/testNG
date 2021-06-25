package com.leetcode.string;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/6/25 下午 9:48
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("第一次出现唯一字符的索引:" + firstUniqueChar(s));
        System.out.println("第一次出现唯一字符的索引1:" + firstUniqueChar1(s));
    }

    /**
     * 依次循环比较第i个 与 后面每一个是否相等,相等就跳出循环,执行下一次,否则判断后面的是否比较完，
     * 比较完了,则返回i,否则继续比较下一个
     * @param s
     * @return
     */
    public static int firstUniqueChar(String s) {
        int l = s.length();
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    break;
                } else if (j == l-1) { // 要确定比较完了都没有相等的--->则唯一且第一个
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 取得第i个字符的第一个和最后一个索引--->如果相等表示只有一个,且i从0开始,是第一个
     * @param s
     * @return
     */
    public static int firstUniqueChar1(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
