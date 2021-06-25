package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:twoSum3
 * @author:zyg
 * @time:2021/5/12 下午 9:51
 */
public class SolutionTwoSum {
    public static void main(String[] args) {
        int[] nums = {3,4,9,5,7};
        int target = 9;
        int[] indes = twoSum3(nums, target);
        System.out.println(Arrays.toString(indes));
    }

    // 暴力破解
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) { // 从第一个开始依次和后面的相加=9
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 9) {
                    return new int[]{i, j}; // 返回下标数组
                }
            }
           // break; //找到一个就返回,只有一个----->有没有无所谓,因为上一步已经return了。
        }
        return null;
    }

    // 双指针
    public static int[] twoSum2(int[] nums, int target) {
        int i = 0;
        int j = 1;
        int max = nums.length - 1; // 定义后指针的最大index
        while (nums[i] + nums[j] != target) { // 相等就直接返回index
            if (j == max) { // 如果j=max,进行第二轮
                i++;
                j = i; // 第二轮循环的j应该从i+1开始,因为外层有j++了,所以此处为将i赋给j
            }
            j++;
        }
        return new int[] {i, j}; // = target 就直接return
    }

    // HashMap
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {    // map里的key是数组元素,map里的value是数组的index
            if (m.get(target - nums[i]) != null) { // 通过target - 当前nums[i] != null,说明map中先前存入的数组元素中存在一个value使得,key + nums[i] = target.
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i); // 每次将nums[i],i 对放入map中
        }
        return new int[]{0, 0};
    }
}
