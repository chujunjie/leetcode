package solutions.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @Author: chujunjie
 * @Date: Create in 11:04 2020/2/6
 * @Modified By
 */
public class Solution51 {

    /**
     * 回溯算法
     * <p>
     * 框架：
     *result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     *
     * @param n n
     * @return 放置列表
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }
        backtrace(board, 0, lists, queens);
        return lists;
    }

    /**
     * 回溯尝试放置皇后
     *
     * @param board  棋盘
     * @param x      行索引
     * @param lists  有效解的集合
     * @param queens 已放置的皇后
     */
    private static void backtrace(char[][] board, int x, List<List<String>> lists, int[] queens) {
        if (x == board.length) {
            // 有效解
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            lists.add(list);
            return;
        }
        for (int y = 0; y < board.length; y++) {
            if (validate(board, x, y, queens)) {
                // 尝试放置皇后
                board[x][y] = 'Q';
                queens[x] = y;
                // 尝试下一行
                backtrace(board, x + 1, lists, queens);
                // 撤销前一次的尝试
                board[x][y] = '.';
                queens[x] = -1;
            }
        }
    }

    /**
     * 检查能否放置皇后
     *
     * @param board  棋盘
     * @param x,y    待放置皇后的坐标
     * @param queens 已放置的皇后
     * @return true-可放置，false-不可放置
     */
    private static boolean validate(char[][] board, int x, int y, int[] queens) {
        if (y == board.length) {
            return false;
        }
        // 利用两点式直线方程，验证已放置的皇后是否在待放置点（x, y）的两条斜线上
        int dx, dy;
        for (int qx = 0; qx < x; qx++) {
            dy = y - queens[qx];
            // 在同一列上有皇后
            if (dy == 0) {
                return false;
            }
            dx = x - qx;
            // 斜率为1或-1时，在斜线上有皇后
            if (dx == dy || dx == -dy) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
