package solutions.easy;

import solutions.datastructure.TreeNode;

/**
 * @Description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author: chujunjie
 * @Date: Create in 17:45 2020/2/3
 * @Modified By
 */
public class Solution112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        sum -= root.val;
        return hasPathSum(root.left, sum) | hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.right = b;
        b.right = c;
        c.right = d;

        System.out.println(hasPathSum(a, 10));
    }
}
