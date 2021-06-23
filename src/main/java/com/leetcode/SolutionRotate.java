package com.leetcode;

import java.util.Arrays;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/9 下午 6:23
 */
class SolutionRotate {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    // 旋转,rotate
    public static void rotate(int[] nums, int k) {
        int len = nums.length;  // 定义数组长度
        for(int i = 1; i <= k; i++) { // 循环k次
            int temp = nums[len-1];   // 将最后一个数取出
            for(int j = len; j >= 2; j-- ) { // 从后向前,依次将数右移一位
                nums[j-1] = nums[j-2];
            }
            nums[0] = temp; // 将最后一位数放到数组第一位
        }
        System.out.println(Arrays.toString(nums));
    }
}
