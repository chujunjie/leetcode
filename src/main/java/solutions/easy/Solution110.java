package solutions.easy;

import solutions.datastructure.TreeNode;

/**
 * @Description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @Author: chujunjie
 * @Date: Create in 17:10 2020/2/3
 * @Modified By
 */
public class Solution110 {

    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.right = b;
        b.right = c;
        c.right = d;

        System.out.println(isBalanced(a));
    }
}
