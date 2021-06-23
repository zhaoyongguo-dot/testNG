package com.leetcode;

import java.util.Arrays;

/**
 * @description:singleNumber
 * @author:zyg
 * @time:2021/5/9 下午 11:26
 */
public class SolutionSingleNumber {
    public static void main(String[] args) {
        int nums[] = {1,2,1,2,3};
        singleNumber(nums);
    }

    // singleNumber (only one once, others twice)
    public static void singleNumber(int[] nums) {
        // 哈哈 利用异或运算的特性,foreach
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        System.out.println(result);

        // 代码落后了......
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        System.out.println(a);
    }
}
