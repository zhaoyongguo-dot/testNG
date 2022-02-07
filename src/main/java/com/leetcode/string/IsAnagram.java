package com.leetcode.string;

import java.util.Arrays;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean r = isAnagram(s, t);
        System.out.println(r);
    }

    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        /*
        转换成数组长度不等 一定不是异位词 / 未排序相等也不是异位词
        排序后比较依然相等才是异位词
        数组排序 sort()-->数组自带的排序方法,改变数组本身 / sorted()-->全局排序方法,返回副本
               list.sort(s)                         s1 = sorted(s)
        数组比较  == / equals()
               比较值相等 / 比较对象,引用,变量地址
         */

        if (s1.length != t1.length) {
            return false;
        } else if (Arrays.equals(s1, t1)) {
            return false;
        } else {
            Arrays.sort(s1);
            Arrays.sort(t1);
            return Arrays.equals(s1, t1);
        }
    }
}
