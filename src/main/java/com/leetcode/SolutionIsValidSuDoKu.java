package com.leetcode;

import java.util.HashSet;

/**
 * @description:iSValidSuDo
 * @author:zyg
 * @time:2021/6/14 下午 1:27
 */
public class SolutionIsValidSuDoKu {
    public static void main(String[] args) {
        char board[][] = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                         ,{'.','9','8','.','.','.','.','6','.'}
                         ,{'8','.','.','.','6','.','.','.','3'}
                         ,{'4','.','.','8','.','3','.','.','1'}
                         ,{'7','.','.','.','2','.','.','.','6'}
                         ,{'.','6','.','.','.','.','2','8','.'}
                         ,{'.','.','.','4','1','9','.','.','5'}
                         ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("result-----" + isValidSuDoKu(board));
    }

    public static boolean isValidSuDoKu(char[][] board) {
        int a = board.length;
        int b = board[0].length;
        // 新建每一行、列、方快的集合
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<Character> squSet = new HashSet<>();
        char rowChar = 0, colChar = 0, squChar = 0;
        for (int i = 0; i < a; i++) {
            // 每一行、列、方快搞完,要清零再开始其他
            rowSet.clear();
            colSet.clear();
            squSet.clear();
            for (int j = 0; j < b; j++) {
                rowChar = board[i][j]; // 行
                colChar = board[j][i]; // 列
                squChar = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]; // 方块
                /**
                 * 字符 ！= '.'
                 * 判断对应的集合是否包含该字符,包含则重复--false,否则添加到集合,进行下一个的比较
                 */
                if (rowChar != '.') {
                    if (rowSet.contains(rowChar)) {return false;}
                    else {rowSet.add(rowChar);}
                }
                if (colChar != '.') {
                    if (colSet.contains(colChar)) {return false;}
                    else {colSet.add(colChar);}
                }
                if (squChar != '.') {
                    if (squSet.contains(squChar)) {return false;}
                    else {squSet.add(squChar);}
                }
            }
        }
        return true;
    }
}
