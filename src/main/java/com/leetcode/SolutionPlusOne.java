package com.leetcode;

import java.util.Arrays;

/**
 * @description:SolutionPlusOne
 * @author:zyg
 * @time:2021/5/12 上午 5:23
 */
public class SolutionPlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,9,8,9};
        int[] digit = onePLus(digits);
        System.out.println(Arrays.toString(digit));
    }

    public static int[] onePLus(int[] digits) {
        digits[digits.length-1] += 1; // 当成是整数,末尾+1
        for (int i = digits.length-1; i >= 0; i--) { // 从后向前循环判断值是否=10
            if (digits[i] == 10) {    // = 10,清0,前一位+1
                digits[i] = 0;
                digits[i-1] += 1;
            } else {break;}           // 否则,退出循环,不再需要向前判断了
        }
        return digits;
    }
}
