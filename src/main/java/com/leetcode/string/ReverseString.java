package com.leetcode.string;

import java.util.Arrays;

/**
 * @description:reverseString
 * @author:zyg
 * @time:2021/6/25 上午 7:33
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'1', '3', '7', '2', '4', '8'};
        reverseString(s);
    }

    /**
     * 分2,
     * 交换之,
     * 奇数取整即可,偶数取整要注意边界值--从整除2的边界值开始取
     * @param s char
     */
    public static void reverseString(char[] s) {
        int l = s.length;
        for (int i = 0, j = l-1; i < (l / 2) && j >= (l/2); i++, j--) {
            char a;
            a = s[i];
            s[i] = s[j];
            s[j] = a;
        }
        System.out.println("反转后的字符串是:" + Arrays.toString(s));
    }
}
