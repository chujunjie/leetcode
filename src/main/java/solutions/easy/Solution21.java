package solutions.easy;

import solutions.datastructure.ListNode;

/**
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author: chujunjie
 * @Date: Create in 15:26 2020/1/28
 * @Modified By
 */
public class Solution21 {

    /**
     * 递归
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode node = new ListNode(-1);
        // 哨兵节点
        ListNode current = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
//        while (l1 != null) {
//            current.next = new ListNode(l1.val);
//            l1 = l1.next;
//            current = current.next;
//        }
//        while (l2 != null) {
//            current.next = new ListNode(l2.val);
//            l2 = l2.next;
//            current = current.next;
//        }

        // 优化
        current.next = l1 == null ? l2 : l1;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        a1.next = b1;
        b1.next = c1;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        a2.next = b2;
        b2.next = c2;

        ListNode listNode = mergeTwoLists2(a1, a2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
