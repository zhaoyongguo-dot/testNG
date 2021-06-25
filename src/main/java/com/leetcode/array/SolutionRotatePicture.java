package com.leetcode.array;

import java.util.Arrays;

/**
 * @description:rotatePicture
 * @author:zyg
 * @time:2021/6/23 下午 9:16
 *
 * rotate--->旋转
 * matrix--->矩阵
 *
 * int rotate[][] = new int[3][3]
 * int[][] rotate = new int[3][3]
 */
public class SolutionRotatePicture {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}
                         ,{5, 6, 7, 8}
                         ,{9, 10, 11, 12}};
        Rotate(matrix);
    }

    /**
     * [0][0]--->[0][2]
     * [1][0]--->[0][1]
     * [2][0]--->[0][0]
     * 1.行列交换
     * 2.列--->行
     * 3.行--->倒排序
     */
    public static void Rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rotate_matrix = new int[col][row]; // int rotate_matrix[][] = new int[col][row];
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                rotate_matrix[j][row-i-1] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(rotate_matrix));
    }
}
