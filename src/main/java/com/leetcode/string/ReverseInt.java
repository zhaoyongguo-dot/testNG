package com.leetcode.string;

/**
 * @description:reverseInt
 * @author:zyg
 * @time:2021/6/25 上午 8:03
 */
public class ReverseInt {
    public static void main(String[] args) {
        int x = 324540;
        System.out.println("翻转后的Int:" + reverseInt(x));
    }

    /**
     * 定义初始结果res=0
     * 取得个位数+res*10 再取整将最后一位数排除掉---> 依次循环(每次*10--->个位变十位变百位...)
     * @param x
     * @return
     */
    public static int reverseInt(int x) {
        int res = 0; // 定义一个结果初始值
        while (x != 0) {
            int last = x % 10; // 取余--->个位数(最后一位数)
            res = res * 10 + last;
            x /= 10; // 取整,将计算过的最后一位数值排除掉
        }
        return res;
    }
}
