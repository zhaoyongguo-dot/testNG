package com.leetcode;

import java.util.Arrays;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/12 上午 5:52
 */
public class SolutionMoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,4,0,51,0};
        int[] move = moveZeroes(nums);
        System.out.println(Arrays.toString(move));
    }

    private static int[] moveZeroes(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length-flag; i++) { // -flag是为了减少循环次数,flag+1表示有falg个0移动到末尾,所以倒数flag个0就不用再移动了
            if (nums[i] == 0) {
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1]; // 判断是0就依次向左移动,下一次循环应该从i开始,前i个i=0已经移动过了
                }
                nums[nums.length-1] = 0;
                flag += 1;
            }
        }
        return nums;
    }
}
