package solutions.easy;

import solutions.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @Author: chujunjie
 * @Date: Create in 11:30 2020/2/3
 * @Modified By
 */
public class Solution107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 深搜
        dfs(root, 0, list);

        // 反转
        Collections.reverse(list);
        return list;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            // 说明当前层，还没有开始存数据,进行初始化
            list.add(level, new ArrayList<>());
        }

        // 将当前节点的数据存储到当前层
        list.get(level).add(root.val);

        // 继续遍历遍历下一层的数据
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.right = b;
        b.right = c;
        c.right = d;

        System.out.println(levelOrderBottom(a));
    }
}
