package solutions.easy;

import solutions.datastructure.TreeNode;

/**
 * @Description: 给定一个二叉树，检查它是否是镜像对称的。
 * @Author: chujunjie
 * @Date: Create in 10:26 2020/2/3
 * @Modified By
 */
public class Solution101 {

    public static boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(2);
        TreeNode c1 = new TreeNode(3);
        TreeNode c2 = new TreeNode(3);
        TreeNode d1 = new TreeNode(4);
        TreeNode d2 = new TreeNode(4);

        a.left = b1;
        a.right = b2;
        b1.left = c1;
        b1.right = d1;
        b2.left = d2;
//        b2.right = c2;
        System.out.println(isSymmetric(a));
    }
}
