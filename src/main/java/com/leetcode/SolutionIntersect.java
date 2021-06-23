package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:intersect
 * @author:zyg
 * @time:2021/5/10 下午 10:09
 */
public class SolutionIntersect {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1,3,4};
        int[] nums2 = {1,2,4};
        int[] out = intersect(nums1, nums2);
        System.out.println(Arrays.toString(out));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // 升序排序,返回本身
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>(); // 定义list接受重复的元素
        // 两组指针从0开始比较,
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]) { // 哪一个小,就将指针右移一位
                i++;
            } else if (nums1[i] > nums2[j]) { // 哪一个小,就将指针右移一位
                j++;
            } else { // 相等则输出到list中
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int index = 0;
        int len = list.size();
        int[] out = new int[len];
        for (Integer integer : list) {
            out[index++] = integer;
        }
        return out;
    }
    
    // 自己还是不行啊
    public static int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.asList(nums1);
        Arrays.asList(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
        }
        return nums1;
    }
}
