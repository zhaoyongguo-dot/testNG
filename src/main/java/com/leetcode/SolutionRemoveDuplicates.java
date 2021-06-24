package com.leetcode;

/**
 * @description:removeDuplicates
 * @author:zyg
 * @time:2021/6/24 下午 11:21
 */
public class SolutionRemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1,1,2,3,3,4,4,4,5};
        removeDuplicates(array);
    }

    /**
     * 考虑到已经按升序排序,只要返回数组长度即可,所以只要依次从0开始向后比较是否相等,相等就长度减一.
     * @param array
     */
    public static void removeDuplicates(int[] array) {
        int len = array.length;
        int l = len;
        for (int i = 0; i < len-1; i++) { // i < len 的话,下一行就会数组越界
            if (array[i] == array[i+1]) {
                l--;
            }
        }
        System.out.println("移除重复数组后的长度:" + l);
    }
}
