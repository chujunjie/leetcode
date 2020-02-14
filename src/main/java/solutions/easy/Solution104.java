package solutions.easy;

import solutions.datastructure.TreeNode;

/**
 * @Description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author: chujunjie
 * @Date: Create in 10:54 2020/2/3
 * @Modified By
 */
public class Solution104 {

    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int depth = 0;
        return depth(root, depth);
    }

    private static int depth(TreeNode node, int depth) {
        if (null == node) {
            return depth;
        }

        depth++;
        // DFS 深度优先搜索
        return Math.max(depth(node.left, depth), depth(node.right, depth));
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.right = b;
        b.right = c;
        c.right = d;

        System.out.println(maxDepth(a));
    }
}
