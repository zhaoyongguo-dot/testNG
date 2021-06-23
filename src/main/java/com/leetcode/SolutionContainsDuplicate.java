package com.leetcode;

/**
 * @description:containsDuplicate
 * @author:zyg
 * @time:2021/5/9 下午 10:45
 */
public class SolutionContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        containsDuplicate(nums);
    }

    // 存在重复元素
    public static void containsDuplicate(int[] nums) {
        int len = nums.length;
        boolean flag = false;
        for (int i = 0; i < len-1; i++) {
            for (int j = 1; j <= len-1; j++) {
                if (nums[i] == nums[j]) {
                    flag = true;
                    System.out.println(flag);
                    break;
                }
            }
            break;
        }
    }
}
