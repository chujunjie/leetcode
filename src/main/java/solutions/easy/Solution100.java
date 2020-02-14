package solutions.easy;

import solutions.datastructure.TreeNode;

/**
 * @Description: 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @Author: chujunjie
 * @Date: Create in 20:35 2020/2/2
 * @Modified By
 */
public class Solution100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        TreeNode a2 = new TreeNode(1);
        a1.left = b;
        a1.right = c;
        a2.left = b;
//        a2.right = c;

        System.out.println(isSameTree(a1, a2));
    }
}
